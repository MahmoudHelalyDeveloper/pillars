package com.app.pillars.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  extends BaseEntity {


    @Id
    private int id;

    @Column(name = "username")
    private String userName;


    private String password;


}
