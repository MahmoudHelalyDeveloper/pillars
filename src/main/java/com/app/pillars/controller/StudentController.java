package com.app.pillars.controller;

import com.app.pillars.dto.UserDto;
import com.app.pillars.model.Address;
import com.app.pillars.model.Student;
import com.app.pillars.request.StudentRequest;
import com.app.pillars.service.user.StudentService;
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

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired

    private HttpServletRequest httpServletRequest;

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping("/getAllStudent")

    public ResponseEntity<Page<Student>> getAllStudent(@RequestParam(value = "pageNo", required = false,defaultValue = "1") int pageNo , @RequestParam(value = "pageSize", required = false,defaultValue = "2147483647") int pageSize, @RequestParam(value = "orderBy", required = false) String orderBy, @RequestParam(value = "asc", required = false) boolean asc ){

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

        Page<Student> allStudents = this.studentService.getAllStudents(pageable);
        logger.info("all is{}",allStudents.toString());

        return new ResponseEntity(allStudents, HttpStatus.OK);


    }
    @PostMapping("/addStudent")

    public  ResponseEntity<Student> addStudent( @RequestBody StudentRequest studentRequest ){
        Student saved = this.studentService.addStudent(studentRequest);
        return  new ResponseEntity<>(saved,HttpStatus.OK);
    }

    @PostMapping("/updateStudent")

    public  ResponseEntity<Student> updateStudent( @RequestBody StudentRequest studentRequest ){
        if(studentRequest.getId()==0 ){

        }
        Student saved = this.studentService.updateStudent(studentRequest);
        return  new ResponseEntity<>(saved,HttpStatus.OK);
    }


    @PostMapping("/delete")

    public  ResponseEntity<String> addStudent( @RequestParam("id")  int id ){
        this.studentService.deleteUser(id);
        return  new ResponseEntity<>("ss",HttpStatus.OK);
    }

}
