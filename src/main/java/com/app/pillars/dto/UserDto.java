package com.app.pillars.dto;

import com.app.pillars.configure.jwt.CustomValueFilterArabic;
import com.app.pillars.configure.jwt.CustomValueFilterEnglish;
import com.app.pillars.util.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class UserDto {


    public UserDto(int id, String password, String userName, String genderEn, String genderAr, String genderName, String createdName, String updatedName) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.genderEn = genderEn;
        this.genderAr = genderAr;
        this.genderName = genderName;
        this.createdName = createdName;
        this.updatedName = updatedName;
    }

    private int id;

    private String password;

    private String userName;

    @JsonIgnore
    private String genderEn;

    @JsonIgnore
    private String genderAr;

    private String genderName;

    private String createdName;

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    private String updatedName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGenderEn() {
        return genderEn;
    }

    public void setGenderEn(String genderEn) {
        this.genderEn = genderEn;
    }

    public String getGenderAr() {
        return genderAr;
    }

    public void setGenderAr(String genderAr) {
        this.genderAr = genderAr;
    }

    public String getGenderName() {
        if (Constant.langApp.equals("ar")) {
            return getGenderAr();
        } else {
            return getGenderEn();
        }
    }

    public void setGenderName(String genderName) {
        this.genderName = "MAHMOUD";
    }

}
