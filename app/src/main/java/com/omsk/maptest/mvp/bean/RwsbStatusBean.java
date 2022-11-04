package com.omsk.maptest.mvp.bean;

public class RwsbStatusBean {

    public RwsbStatusBean() {

    }

    public RwsbStatusBean(String status, String time, String selected) {
        this.status = status;
        this.time = time;
        this.selected = selected;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String status;

    private String time;

    private String selected;

}
