package com.omsk.maptest.mvp.bean;

public class ZzaqRyBean {

    public ZzaqRyBean() {
    }

    public ZzaqRyBean(String name, String sex, String code, String address) {
        this.name = name;
        this.sex = sex;
        this.code = code;
        this.address = address;
    }

    private String name;

    private String sex;

    private String code;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
