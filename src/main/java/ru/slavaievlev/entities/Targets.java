package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
public class Targets {
    @Id
    @GeneratedValue
    private int id;
    private int summaryid;
    private String target;

    public int getSummaryid() {
        return summaryid;
    }

    public String getTarget() {
        return target;
    }

    public int getId() {
        return id;
    }
}
