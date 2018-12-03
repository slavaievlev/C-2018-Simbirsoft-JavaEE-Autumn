package ru.slavaievlev.controllers.request_models;

import java.io.Serializable;

public class RequestModelForPutSummary implements Serializable {
    private String nameField;
    private int indexField;
    private String valueField;

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public int getIndexField() {
        return indexField;
    }

    public void setIndexField(int indexField) {
        this.indexField = indexField;
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }
}
