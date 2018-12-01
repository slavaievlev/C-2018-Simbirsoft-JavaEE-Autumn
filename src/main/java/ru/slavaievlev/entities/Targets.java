package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
@Table(name = "TARGETS")
public class Targets {
    @Id
    @GeneratedValue
    private int id;
    private String target;

    public Targets() {
    }

    @ManyToOne
    @JoinColumn(name = "summary_id", nullable = false)
    private Summary summary;

    public void setId(int id) {
        this.id = id;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public int getId() {
        return id;
    }
}
