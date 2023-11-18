package com.app.pillars.service.user;

import com.app.pillars.dto.CourseDto;
import com.app.pillars.request.CourseRequest;

import java.util.List;

public abstract class CourseService {

    public abstract List<CourseDto> getAllCourseForUser(int studentId);
}
