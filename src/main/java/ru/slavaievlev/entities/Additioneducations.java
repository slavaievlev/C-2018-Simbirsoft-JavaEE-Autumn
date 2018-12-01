package ru.slavaievlev.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Additioneducations {

    @Id
    @GeneratedValue
    private int id;
    private int summaryid;
    private String additioneducations;

    public int getId() {
        return id;
    }

    public int getSummaryid() {
        return summaryid;
    }

    public String getAdditioneducations() {
        return additioneducations;
    }
}
