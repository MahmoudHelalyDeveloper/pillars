package com.app.pillars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student extends BaseEntity implements Serializable {


    @Id
    @GeneratedValue(generator = "Student", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, name = "Student", sequenceName = "Student_seq")
    private Integer id;

    @Column(name = "name")
    private String name;


    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
//    @JsonIgnore
//    @JoinColumn(name = "STUDENT_ID",referencedColumnName = "id")
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "STUDENT_ID")

    private List<Address> addresses = new ArrayList<Address>();


    @ManyToMany


    @Fetch(FetchMode.SUBSELECT)
//    @JoinColumn(name = "STUDENT_ID")
    @JoinTable(name = "STUDENT_COURSES",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSES_ID")
    )
    @JsonIgnore
    private List<Course> courses = new ArrayList<Course>();


    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }

//    public void removeTag(Tag tag) {
//        tags.remove(tag);
//        tag.getPosts().remove(this);
//    }


//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
////    @JsonIgnore
////    @JoinColumn(name = "STUDENT_ID",referencedColumnName = "id")
//    @Fetch(FetchMode.SUBSELECT)
//    @JoinColumn(name = "STUDENT_ID")
//
//    private List<CourseStudent> courseStudents = new ArrayList<CourseStudent>();
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;
    return id != null && id.equals(((Student) o).getId());
}

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
