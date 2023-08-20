package com.app.pillars.service.user;

import com.app.pillars.model.Address;
import com.app.pillars.model.Course;
import com.app.pillars.model.Student;
import com.app.pillars.repo.AddressRepo;
import com.app.pillars.repo.CourseStudentRepo;
import com.app.pillars.repo.StudentRepo;
import com.app.pillars.request.AddressRequest;
import com.app.pillars.request.CourseRequest;
import com.app.pillars.request.StudentRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl extends StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private CourseStudentRepo courseStudentRepo;

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        Page<Student> allBy = studentRepo.findAllBy(pageable);
        return allBy;
    }

    @Override
    public Student getStudent(int id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {

//        Address address = new Address();
//        address.setSt("app");
//        address.setCity("C");
//        List<Address> addresses= new ArrayList<Address>();
//        addresses.add(address);
//        Student student1 = new Student();
//        student1.setId(1);
//        student1.setName("ww");
//        student1.setAddresses(addresses);
//        List<AddressRequest> addressRequests = studentRequest.getAddressRequests();
//        this.addressRepo.save(transform(addressRequests.get(0)));
//        List<Course> courses = student.getCourses();
//
//        if (courses == null) {
//            for (Course cours : courses) {
//                student.addTag(cours);
//            }
//        }
//        int studentId = save.getId();
//        Course course = new Course(1,"ar",1);
//        Course course2 = new Course(3,"math",2);
        Student student= new Student();
        student.setId(studentRequest.getId());
        student.setName(studentRequest.getName());
        List<AddressRequest> addressRequests = studentRequest.getAddressRequests();
        List<Address> addresses= new ArrayList<Address>();
        for (AddressRequest addressRequest : addressRequests) {
            Address transform = transform(addressRequest);
            addresses.add(transform);
        }
        List<CourseRequest> courseRequests = studentRequest.getCourseRequests().stream().filter(s->s.getValue()==1).toList();
        for (CourseRequest courseRequest : courseRequests) {
            Course transform = transform(courseRequest);
            student.addCourse(transform);
        }

        student.setAddresses(addresses);


        Student save = this.studentRepo.save(student);

//        this.courseStudentRepo.save()
        return save;
    }

    @Override
    public Student updateStudent(StudentRequest studentRequest) {
        Student student = transForm(studentRequest);
        List<CourseRequest> list = studentRequest.getCourseRequests().stream().filter(c -> c.getValue() == 1).toList();
        for (CourseRequest courseRequest : list) {
            student.addCourse(transform(courseRequest));

        }
        return this.studentRepo.save(student);
    }

    @Override
    public boolean deleteUser(int id) {
        Student student = this.studentRepo.findById(id).get();
        this.studentRepo.delete(student);
        return true;
    }

    public Student transForm(StudentRequest studentRequest) {
        Student student = new Student();
        student.setId(studentRequest.getId());
        student.setName(studentRequest.getName());
        List<AddressRequest> addressRequests = studentRequest.getAddressRequests();

//        List<Address> addresses = new ArrayList<Address>();
        for (AddressRequest addressRequest : addressRequests) {
            Address transform = transform(addressRequest);
//            transform.setStudent(student);
//            addresses.add( transform);
            student.getAddresses().add(transform);
        }

//        student.setAddresses(addresses);
        return student;
    }

    public Address transform(AddressRequest addressRequest) {
        Address address = new Address();
        address.setSt(addressRequest.getSt());
        address.setCity(addressRequest.getCity());
        address.setId(addressRequest.getId());
//        transForm(addressRequest.getStudentRequest());
        return address;
    }

    public Course transform(CourseRequest courseRequest) {
        Course course = new Course();
        course.setId(courseRequest.getId());
        course.setName(courseRequest.getName());

//        transForm(addressRequest.getStudentRequest());
        return course;
    }

}
