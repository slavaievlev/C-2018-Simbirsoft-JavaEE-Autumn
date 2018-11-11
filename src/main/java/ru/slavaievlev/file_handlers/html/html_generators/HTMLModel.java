package ru.slavaievlev.file_handlers.html.html_generators;

import java.util.LinkedList;

public class HTMLModel {

    // ФИО.
    private String fio = null;

    // Дата рождения.
    private String dob = null;

    // Электронная почта.
    private String email = null;

    // Адрес skype.
    private String skype = null;

    // Ссылка на аватар.
    private String avatar = null;

    // Цель резюме.
    private LinkedList<String> target = null;

    // Номер телефона.
    private String phone = null;

    // Опыт работы.
    private LinkedList<String> experiences = null;

    // Образование.
    private LinkedList<String> educations = null;

    // Дополнительное образование.
    private LinkedList<String> additional_educations = null;

    // Навыки.
    private LinkedList<String> skills = null;

    // Примеры кода.
    private LinkedList<String> examples_code = null;


    
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LinkedList<String> getTarget() {
        return target;
    }

    public void setTarget(LinkedList<String> target) {
        this.target = target;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LinkedList<String> getExperiences() {
        return experiences;
    }

    public void setExperiences(LinkedList<String> experiences) {
        this.experiences = experiences;
    }

    public LinkedList<String> getEducations() {
        return educations;
    }

    public void setEducations(LinkedList<String> educations) {
        this.educations = educations;
    }

    public LinkedList<String> getAdditional_educations() {
        return additional_educations;
    }

    public void setAdditional_educations(LinkedList<String> additional_educations) {
        this.additional_educations = additional_educations;
    }

    public LinkedList<String> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<String> skills) {
        this.skills = skills;
    }

    public LinkedList<String> getExamples_code() {
        return examples_code;
    }

    public void setExamples_code(LinkedList<String> examples_code) {
        this.examples_code = examples_code;
    }
}
