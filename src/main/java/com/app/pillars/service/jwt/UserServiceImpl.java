package com.app.pillars.service.jwt;

import com.app.pillars.dto.JwtRequest;
import com.app.pillars.dto.UserInfo;
import com.app.pillars.model.User;
import com.app.pillars.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl extends UserService {
    @Autowired
    private UserRepo userRepo;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
   public UserInfo authenticate(JwtRequest jwtRequest) {
        logger.info("authenticate ");
        User byUserNameAndPassword = userRepo.findByUserNameAndPassword(jwtRequest.getUsername(),jwtRequest.getPassword());
        UserInfo userInfo =new UserInfo(byUserNameAndPassword.getId(),byUserNameAndPassword.getUserName(),byUserNameAndPassword.getPassword(),new ArrayList<>());
        return userInfo;
//    return null;
    }

    public String getName(){
        return  "Mah";
    }


}
