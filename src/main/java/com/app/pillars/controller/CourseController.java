package com.app.pillars.controller;

import com.app.pillars.dto.CourseDto;
import com.app.pillars.request.CourseRequest;
import com.app.pillars.service.user.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCoursesForUser")
    public ResponseEntity<CourseDto> getAllCoursesForUser(@RequestParam("studentId") int studentId){

        List<CourseDto> allCourseForUser = this.courseService.getAllCourseForUser(studentId);
        return new ResponseEntity(allCourseForUser, HttpStatus.OK);
    }


}
