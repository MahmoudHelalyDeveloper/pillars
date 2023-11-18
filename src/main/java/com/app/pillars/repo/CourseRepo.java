package com.app.pillars.repo;

import com.app.pillars.dto.CourseDto;
import com.app.pillars.model.Course;
import com.app.pillars.request.CourseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

@Query(value = "SELECT x.id as id ,x.name as name,nvl2((SELECT 1 FROM COURSE c LEFT join STUDENT_COURSES sc   \n" +
        "ON c.ID =sc.COURSES_ID \n" +
        "right JOIN STUDENT s \n" +
        "ON s.ID =sc.STUDENT_ID \n" +
        " WHERE sc.STUDENT_ID =:studentId\n" +
        " \n" +
        " AND x.id=c.id\n" +
        " AND x.ID =sc.COURSES_ID\n" +
        "),1,0) AS value  FROM COURSE x  ",nativeQuery = true)
public List<CourseDto> getAllCourses(@Param ("studentId")int studentId);


}
