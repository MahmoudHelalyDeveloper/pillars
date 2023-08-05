package com.app.pillars.service.user;

import com.app.pillars.dto.UserDto;
import com.app.pillars.model.User;
import com.app.pillars.request.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public abstract class UserService {


 public    abstract Page<UserDto> findAll(Pageable pageable);

    public  abstract UserDto getUser(int id);

    public   abstract  User addUser(User user);

    public  abstract  User updateUser(User user);

    public abstract boolean  deleteUser(int id);

    public    abstract Page<UserDto> search(Pageable pageable,String searchValue);

   public  abstract Page<User>  advancedSearch(Specification<User> spec, Pageable pageable) ;





   }
