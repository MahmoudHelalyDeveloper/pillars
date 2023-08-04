package com.app.pillars.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.List;


@Entity
@Table(name = "users")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {



    @Id
    private int id;

    @Column(name = "username")
    private String userName;


    private String password;

    private String gender;

    @Transient
    public  String getGenderEn(){
        return genderEn;
    };

    @Transient
    public  String getGenderAr(){
        return genderAr;
    };

//    @Transient
//    public  String geGenderName(){
//        return genderName;
//    };


//    @Formula("")
//    private String genderName;

    @Formula("(select t.name from transalte t where t.VALUE=gender and t.lang='en')")
    private  String genderEn;


    @Formula("(select t.name from transalte t where t.VALUE=gender and t.lang='ar')")
    private  String genderAr;

//    private String genderName=genderAr+genderEn;
@Transient
    public  String getGenderName(){
         return  genderName;
    }
@Formula("gender")
    private String genderName="";



    @PostLoad
    public void postload() {
//        String lang = getsessionLangs();

//            this.genderName = "helaly";
//        genderName=""+genderAr+"  0 "+genderEn;
        genderName="H";
    }

}
