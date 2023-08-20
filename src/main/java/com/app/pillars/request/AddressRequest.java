package com.app.pillars.request;

import com.app.pillars.model.Student;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    private int id;

    private String city;

    private String st;

}
