package com.app.pillars.request;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRequest {

    public UserRequest() {
    }

    private int id;

    private String password;

    private String userName;

    private String genderEn;


    private String genderAr;

    private String genderName;

    private String createdName;

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
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

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
}
