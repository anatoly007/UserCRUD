package com.spitsin.main;

import java.util.Date;

/**
 * Created by aser on 15.02.2016.
 */

public class User {

    private int id;
    private String fname;
    private String lname;
    private Date birthDate;
    private String city;


    public User(String fname, String lname, int age, String city) {
        this.fname = fname;
        this.lname = lname;
        this.city = city;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + '\'' +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", birth date =" + birthDate +
                ", city='" + city + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBirthDate() {
        return String.valueOf(birthDate);
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

