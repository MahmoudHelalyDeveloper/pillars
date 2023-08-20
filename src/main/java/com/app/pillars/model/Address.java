package com.app.pillars.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address extends BaseEntity  {

    @Id
    @GeneratedValue(generator = "Address", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, name = "Address", sequenceName = "address_seq")
    private int id;

    private String city;

    private String st;



//   @ManyToOne(fetch =  FetchType.LAZY)
//   @JoinColumn(name = "STUDENT_ID",referencedColumnName = "id",nullable = true)
//   @JsonBackReference
//
//   private Student student;


}
