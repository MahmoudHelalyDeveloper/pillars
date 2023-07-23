package com.app.pillars.controller;

import com.app.pillars.dto.UserDto;
import com.app.pillars.model.User;
import com.app.pillars.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService User;

    @GetMapping("/getAllUsers")
    public ResponseEntity<UserDto> getAllUser(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        Page<UserDto> all = this.User.findAll(pageable);
        return new ResponseEntity(all.getContent(), HttpStatus.OK);
    }

    @GetMapping("/AllUsers")
    public ResponseEntity<UserDto> AllUser(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        Page<UserDto> all = this.User.findAll(pageable);
        return new ResponseEntity(all, HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserDto> getUser(@RequestParam("id") int id){

        UserDto user = this.User.getUser(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User userDto){

        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        com.app.pillars.model.User user1 = this.User.addUser(user);


        return new ResponseEntity(user1, HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User userDto){

        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        com.app.pillars.model.User user1 = this.User.addUser(user);


        return new ResponseEntity(user1, HttpStatus.OK);
    }

    @GetMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestParam("id") int id){

        boolean isDeleted = this.User.deleteUser(id);
        return new ResponseEntity(isDeleted, HttpStatus.OK);
    }
}
