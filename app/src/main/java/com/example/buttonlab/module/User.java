package com.example.buttonlab.module;


import java.io.Serializable;

public class User  {
    private String name;
    private String gender;
    private String dob;
    private String country;
    private String phone;
    private String email;

    public User(String name, String gender, String dob, String country, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}