package com.app.pillars.service.user;

import com.app.pillars.model.Student;
import com.app.pillars.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
public abstract class StudentService {


    public abstract Page<Student> getAllStudents(Pageable pageable);

    public abstract Student getStudent(int id);
    public abstract Student addStudent(StudentRequest studentRequest);
    public abstract Student updateStudent(StudentRequest studentRequest);

    public  abstract  boolean deleteUser(int id);



}
