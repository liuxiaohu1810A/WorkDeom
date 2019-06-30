package com.example.week3.bean;

import java.io.Serializable;

public class GoldtabBean implements Serializable {
    private String name;
    private Boolean isSelected;

    public GoldtabBean(String name, Boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "GoldtabBean{" +
                "name='" + name + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
