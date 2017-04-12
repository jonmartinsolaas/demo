package com.example;

import java.io.Serializable;

public class SearchBean implements Serializable {

    public String caption;
    public String value;
    public Integer id;

    public SearchBean(String caption, String value, Integer id) {
        this.caption = caption;
        this.value = value;
        this.id = id;
    }

    public SearchBean() {} // default constructor

    public String getCaption() {
        return caption;
    }

    public String getValue() {
        return value;
    }

    public Integer getId() {
        return id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
