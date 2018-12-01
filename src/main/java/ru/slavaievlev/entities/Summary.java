package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
public class Summary {
    @Id
    @GeneratedValue
    private int id;

    private String fio;
    private String dob;
    private String email;
    private String skype;
    private String avatar;
    private String phone;

//    private String experiences;
//    private String educations;
//    private String additionalEducations;
//    private String skills;
//    private String examplesCode;


    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPhone() {
        return phone;
    }
}
