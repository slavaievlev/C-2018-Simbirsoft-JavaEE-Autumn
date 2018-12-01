package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
@Table(name = "EXPERIENCES")
public class Experiences {

    @Id
    @GeneratedValue
    private int id;
    private String experience;

    @ManyToOne
    @JoinColumn(name = "summary_id", nullable = false)
    private Summary summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience() {
        return experience;
    }
}
