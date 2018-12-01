package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
@Table(name = "SKILLS")
public class Skills {

    @Id
    @GeneratedValue
    private int id;
    private String skill;
    private int experience;

    @ManyToOne
    @JoinColumn(name = "summary_id", nullable = false)
    private Summary summary;

    public void setId(int id) {
        this.id = id;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public int getId() {
        return id;
    }

    public String getSkill() {
        return skill;
    }
}
