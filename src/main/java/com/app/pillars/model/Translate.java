package com.app.pillars.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TRANSALTE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Translate {

    @Id
    private int id;

    private String name;

    private String lang;

    private String word;

    private String value;

}
