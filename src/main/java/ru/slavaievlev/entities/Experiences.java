package ru.slavaievlev.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Experiences {

    @Id
    @GeneratedValue
    private int id;
    private int summaryid;
    private String experience;

    public int getId() {
        return id;
    }

    public int getSummaryid() {
        return summaryid;
    }

    public String getExperience() {
        return experience;
    }
}
