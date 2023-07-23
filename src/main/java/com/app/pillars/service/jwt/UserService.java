package com.app.pillars.service.jwt;

import com.app.pillars.dto.JwtRequest;
import com.app.pillars.dto.UserInfo;

public abstract class UserService {

   abstract UserInfo authenticate(JwtRequest jwtRequest);
}
