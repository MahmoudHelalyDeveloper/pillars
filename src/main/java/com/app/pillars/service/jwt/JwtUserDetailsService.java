package com.app.pillars.service.jwt;

import com.app.pillars.dto.UserInfo;
import com.app.pillars.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
        com.app.pillars.model.User byUserName = userRepo.findByUserName(username);
        if (byUserName!=null) {
            			return new UserInfo(byUserName.getId(),username,byUserName.getPassword(), new ArrayList<>());

        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
