package com.app.pillars.service.user;

import com.app.pillars.dto.UserDto;
import com.app.pillars.model.User;
import com.app.pillars.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("User")
public class UserServiceImpl extends UserService {


    @Autowired
    private UserRepo userRepo;


    @Override
  public   Page<UserDto> findAll(Pageable pageable) {
        Page<UserDto> all = this.userRepo.findAllBy(pageable);

        return all;
    }

    @Override
    public UserDto getUser(int id) {
        UserDto byId = this.userRepo.findProjectionById(id);
        return byId;
    }

    @Override
    public  User addUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public   User updateUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public boolean deleteUser(int id) {
        User user = null;
        boolean isDeleted=false;
        try {
            user = this.userRepo.findById(id).get();
            this.userRepo.delete(user);
            isDeleted=true;
        } catch (Exception e) {
            isDeleted=false;

        }
        return isDeleted;
    }

    @Override
    public Page<UserDto> search(Pageable pageable,String searchValue) {
        Page<UserDto> allByUserNameOrCreatedNameOrUpdatedName = this.userRepo.findAllByUserNameContainsOrUpdatedNameContainsOrGenderEnContainsOrGenderArContainsOrCreatedNameContains(pageable,searchValue,searchValue,searchValue,searchValue,searchValue);
        return allByUserNameOrCreatedNameOrUpdatedName;
    }
}
