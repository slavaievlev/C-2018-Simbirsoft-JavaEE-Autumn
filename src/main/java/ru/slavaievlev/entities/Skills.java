package ru.slavaievlev.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Skills {

    @Id
    @GeneratedValue
    private int id;
    private int summaryid;
    private String skill;
    private int experience;

    public int getExperience() {
        return experience;
    }

    public int getId() {
        return id;
    }

    public int getSummaryid() {
        return summaryid;
    }

    public String getSkill() {
        return skill;
    }
}
