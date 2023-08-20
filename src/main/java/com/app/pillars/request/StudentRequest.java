package com.app.pillars.request;

import com.app.pillars.model.Address;
import com.app.pillars.model.Student;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StudentRequest{

    private int id;

    private String name;

    private List<AddressRequest> addressRequests;

    private List<CourseRequest> courseRequests;



}
