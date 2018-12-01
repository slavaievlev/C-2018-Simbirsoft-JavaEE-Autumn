package ru.slavaievlev.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Examplescode {

    @Id
    @GeneratedValue
    private int id;
    private int summaryid;
    private String nameresource;
    private String link;

    public String getNameresource() {
        return nameresource;
    }

    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }

    public int getSummaryid() {
        return summaryid;
    }
}
