package com.app.pillars.service.jwt;

import com.app.pillars.dto.JwtRequest;
import com.app.pillars.dto.UserInfo;

public abstract class UserService {

  public abstract UserInfo authenticate(JwtRequest jwtRequest);
}
