package com.app.pillars.controller;

import com.app.pillars.configure.exception.ResourceNotFoundException;
import com.app.pillars.dto.UserDto;
import com.app.pillars.model.User;
import com.app.pillars.service.user.UserService;
import com.app.pillars.util.Constant;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;


@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService User;
    @Autowired

    private HttpServletRequest httpServletRequest;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getAllUsers")
    public ResponseEntity<UserDto> getAllUser(@RequestParam(value = "pageNo", required = false) int pageNo, @RequestParam(value = "pageSize", required = false) int pageSize, @RequestParam(value = "orderBy", required = false) String orderBy, @RequestParam(value = "asc", required = false) boolean asc) {

        logger.info("start get all users");
        Sort sort = null;
        if (orderBy == null) {
            sort = asc == true ? Sort.by("id").ascending() : Sort.by("id").descending();
            logger.info("orderBy is null");

        } else {
            logger.info("orderBy is not null");

            sort = asc == true ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();

        }
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
        logger.info("pageable is{}",pageable.toString());

        Page<UserDto> all = this.User.findAll(pageable);
        logger.info("all is{}",all.getContent().toString());

        return new ResponseEntity(all.getContent(), HttpStatus.OK);
    }

    @GetMapping("/AllUsers")
    public ResponseEntity<UserDto> AllUser(@RequestParam(value = "pageNo", required = false,defaultValue = "1") int pageNo , @RequestParam(value = "pageSize", required = false,defaultValue = "2147483647") int pageSize, @RequestParam(value = "orderBy", required = false) String orderBy, @RequestParam(value = "asc", required = false) boolean asc) {
        logger.info("start get all users");
//        logger.info("pageNo{},pageSize{},orderBy{},asc{}",pageNo,pageSize,orderBy,asc);

        String userName = httpServletRequest.getUserPrincipal().getName();
        logger.info("userName{}",userName);

        Sort sort = null;
        if (orderBy == null) {
            logger.info("orderBy is null");

            sort = asc == true ? Sort.by("id").ascending() : Sort.by("id").descending();
        } else {
            logger.info("orderBy is not null");

            sort = asc == true ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();

        }


        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);
        logger.info("pageable is{}",pageable.toString());

        Page<UserDto> all = this.User.findAll(pageable);
        logger.info("all is{}",all.toString());

        return new ResponseEntity(all, HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserDto> getUser(@RequestParam("id") int id) throws ResourceNotFoundException {

        UserDto user = this.User.getUser(id);
        if (user == null) {
            throw new ResourceNotFoundException("user is not found");
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        com.app.pillars.model.User user1 = this.User.addUser(user);


        return new ResponseEntity(user1, HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        com.app.pillars.model.User user1 = this.User.updateUser(user);


        return new ResponseEntity(user1, HttpStatus.OK);
    }

    @GetMapping("/deleteUser")
    public ResponseEntity<Boolean> deleteUser(@RequestParam("id") int id) {

        boolean isDeleted = this.User.deleteUser(id);
        return new ResponseEntity(isDeleted, HttpStatus.OK);
    }
}
