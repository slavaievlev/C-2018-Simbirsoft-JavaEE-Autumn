package ru.slavaievlev.entities;

import javax.persistence.*;

@Entity
@Table(name = "EXAMPLES_CODE")
public class Examplescode {

    @Id
    @GeneratedValue
    private int id;
    private String nameresource;
    private String link;

    @ManyToOne
    @JoinColumn(name = "summary_id", nullable = false)
    private Summary summary;

    public void setId(int id) {
        this.id = id;
    }

    public void setNameresource(String nameresource) {
        this.nameresource = nameresource;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNameresource() {
        return nameresource;
    }

    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }
}
