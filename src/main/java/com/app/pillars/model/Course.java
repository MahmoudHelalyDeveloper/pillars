package com.app.pillars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="course")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {


    @Id
    private int id;

    private String name;

    private int type;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students= new ArrayList<Student>();

    public Course(int id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
