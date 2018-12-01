package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
@Table(name = "ADDITION_EDUCATIONS")
public class Additioneducations {

    @Id
    @GeneratedValue
    private int id;
    private String additioneducations;

    @ManyToOne
    @JoinColumn(name = "summary_id", nullable = false)
    private Summary summary;

    public void setId(int id) {
        this.id = id;
    }

    public void setAdditioneducations(String additioneducations) {
        this.additioneducations = additioneducations;
    }

    public int getId() {
        return id;
    }

    public String getAdditioneducations() {
        return additioneducations;
    }
}
