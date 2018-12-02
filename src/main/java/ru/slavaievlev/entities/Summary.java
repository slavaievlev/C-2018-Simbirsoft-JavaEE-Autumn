package ru.slavaievlev.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "SUMMARY")
public class Summary {
    @Id
    @GeneratedValue
    private int id;

    public Summary() {
    }

    private String fio;
    private String dob;
    private String email;
    private String skype;
    private String avatar;
    private String phone;

    @OneToMany(mappedBy = "summary")
    private List<Targets> targets;

    @OneToMany(mappedBy = "summary")
    private List<Additioneducations> additioneducations;

    @OneToMany(mappedBy = "summary")
    private List<Educations> educations;

    @OneToMany(mappedBy = "summary")
    private List<Examplescode> examplescodes;

    @OneToMany(mappedBy = "summary")
    private List<Experiences> experiences;

    @OneToMany(mappedBy = "summary")
    private List<Skills> skills;

    public void setTargets(List<Targets> targets) {
        this.targets = targets;
    }

    public void setAdditionEducations(List<Additioneducations> additioneducations) {
        this.additioneducations = additioneducations;
    }

    public void setEducations(List<Educations> educations) {
        this.educations = educations;
    }

    public void setExamplesCodes(List<Examplescode> examplescodes) {
        this.examplescodes = examplescodes;
    }

    public void setExperiences(List<Experiences> experiences) {
        this.experiences = experiences;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Targets> getTargets() {
        return targets;
    }

    public List<Additioneducations> getAdditionEducations() {
        return additioneducations;
    }

    public List<Educations> getEducations() {
        return educations;
    }

    public List<Examplescode> getExamplesCodes() {
        return examplescodes;
    }

    public List<Experiences> getExperiences() {
        return experiences;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
