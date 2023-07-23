package com.app.pillars.controller;

import com.app.pillars.configure.jwt.JwtTokenProvider;
import com.app.pillars.dto.JwtRequest;
import com.app.pillars.dto.UserInfo;
import com.app.pillars.service.jwt.JwtUserDetailsService;
import com.app.pillars.service.jwt.UserService;
import com.app.pillars.service.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth/")
public class Auth {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;



    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity<?> auth( @RequestBody JwtRequest jwtRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),
                        jwtRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.createToken(authentication);
        return ResponseEntity.ok(jwt);
    }

}
