package com.gymSQL.pojo;

import java.util.Date;

public class lost {
    private Integer id;
    private String l_name;
    private String l_describe;
    private String l_type;
    private String phone;
    private Date pick_date;
    private Date get_date;
    private String state;

    public lost() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getL_describe() {
        return l_describe;
    }

    public void setL_describe(String l_describe) {
        this.l_describe = l_describe;
    }

    public String getL_type() {
        return l_type;
    }

    public void setL_type(String l_type) {
        this.l_type = l_type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getPick_date() {
        return pick_date;
    }

    public void setPick_date(Date pick_date) {
        this.pick_date = pick_date;
    }

    public Date getGet_date() {
        return get_date;
    }

    public void setGet_date(Date get_date) {
        this.get_date = get_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "lost{" +
                "id=" + id +
                ", l_name='" + l_name + '\'' +
                ", l_describe='" + l_describe + '\'' +
                ", l_type='" + l_type + '\'' +
                ", phone='" + phone + '\'' +
                ", pick_date=" + pick_date +
                ", get_date=" + get_date +
                ", state='" + state + '\'' +
                '}';
    }
}
