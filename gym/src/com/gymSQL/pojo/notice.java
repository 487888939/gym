package com.gymSQL.pojo;

import java.util.Date;

public class notice {
    private Integer id;
    private String state;
    private String type;
    private Date release_date;
    private String release_name;
    private String release_content;
    private Date change_date;

    public notice() {
    }

    public notice(Integer id, String state, String type, Date release_date, String release_name, String release_content, Date change_date) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.release_date = release_date;
        this.release_name = release_name;
        this.release_content = release_content;
        this.change_date = change_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getRelease_name() {
        return release_name;
    }

    public void setRelease_name(String release_name) {
        this.release_name = release_name;
    }

    public String getRelease_content() {
        return release_content;
    }

    public void setRelease_content(String release_content) {
        this.release_content = release_content;
    }

    public Date getChange_date() {
        return change_date;
    }

    public void setChange_date(Date change_date) {
        this.change_date = change_date;
    }

    @Override
    public String toString() {
        return "notice{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", release_date=" + release_date +
                ", release_name='" + release_name + '\'' +
                ", release_content='" + release_content + '\'' +
                ", change_date=" + change_date +
                '}';
    }
}