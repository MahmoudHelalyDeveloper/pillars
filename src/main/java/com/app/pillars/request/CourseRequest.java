package com.app.pillars.request;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    private int id;

    private String name;

    private int value;

}
