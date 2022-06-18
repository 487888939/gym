package com.gymSQL.pojo;

import org.omg.CORBA.StringHolder;

public class coach_login {
    private Integer id;
    private String coa_name;
    private String password;
    private String state;

    public coach_login() {
    }

    public coach_login(Integer id, String coa_name, String password, String state) {
        this.id = id;
        this.coa_name = coa_name;
        this.password = password;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoa_name() {
        return coa_name;
    }

    public void setCoa_name(String coa_name) {
        this.coa_name = coa_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "coach_login{" +
                "id=" + id +
                ", coa_name='" + coa_name + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
