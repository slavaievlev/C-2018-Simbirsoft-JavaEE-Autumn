package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
@Table(name = "EDUCATIONS")
public class Educations {

    @Id
    @GeneratedValue
    private int id;
    private String education;

    @ManyToOne
    @JoinColumn(name = "summary_id", nullable = false)
    private Summary summary;

    public void setId(int id) {
        this.id = id;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public String getEducation() {
        return education;
    }
}
