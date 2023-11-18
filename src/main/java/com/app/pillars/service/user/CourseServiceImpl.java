package com.app.pillars.service.user;

import com.app.pillars.dto.CourseDto;
import com.app.pillars.repo.CourseRepo;
import com.app.pillars.request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl extends CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Override
    public List<CourseDto> getAllCourseForUser(int studentId) {
        return this.courseRepo.getAllCourses(studentId);
    }
}
