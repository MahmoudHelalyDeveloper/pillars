package com.app.pillars.configure.jwt;


import com.app.pillars.util.Constant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.security.Key;


@Component
public class JwtTokenProvider  implements Serializable {

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    // generate token for user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        String username = userDetails.getUsername();
        return doGenerateToken(claims, username);
    }

    // while creating the token -
    // 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
    // 2. Sign the JWT using the HS512 algorithm and secret key.
    // 3. According to JWS Compact
    // compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Constant.TokenConstant.ACCESS_TOKEN_VALIDITY_SECONDS))
                .signWith(SignatureAlgorithm.HS256, Constant.TokenConstant.SIGNING_KEY).compact();
    }

//    public String generateToken(String userName) {
//        //subject-->username authenticated
//        //claims-->
//        //issuedat-->authentication time
//        //signWith-->
//        //SIGNING_KEY-->must be complex and on externalresourse outsidesource code to be secure
//       String jwtToken = "";
//
//       jwtToken = Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date(System.currentTimeMillis()))
//                                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//				.signWith(SignatureAlgorithm.HS256,ConstantStrings.SIGNING_KEY).compact();
//        return jwtToken;
//    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }




    private Claims getAllClaimsFromToken(String token) {

        return Jwts.parser()
                .setSigningKey(Constant.TokenConstant.SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    //use UserDetails
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (
                username.equals(userDetails.getUsername())
                        && !isTokenExpired(token));
    }
    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
