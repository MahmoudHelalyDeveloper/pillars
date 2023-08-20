package com.app.pillars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;

@Table(name = "STUDENT_COURSES")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudent {

    @Id
    private  int id;

//    @ManyToOne
//    @JsonIgnore
//    private Student student;

    @ManyToOne
    private  Student student;
    @ManyToOne
    private Course course;


}
