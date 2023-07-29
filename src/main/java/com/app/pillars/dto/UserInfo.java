package com.app.pillars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Setter
@Getter
public class UserInfo extends User {

    private  int id;

    public UserInfo(int id,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id=id;
    }


}
