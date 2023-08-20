package com.app.pillars.repo;

import com.app.pillars.model.CourseStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CourseStudentRepo extends JpaRepository<CourseStudent,Integer> {
}
