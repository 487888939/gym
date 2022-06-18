package com.gymSQL.pojo;

import java.util.Date;

public class User{
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Date reg_date;
    private String login_limit;
    private String vip_type;

    public User() {
    }
    public User(Integer id, String username, String password, String email,Date reg_date,String login_limit ,String vip_type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.reg_date=reg_date;
        this.login_limit=login_limit;
        this.vip_type=vip_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getReg_date() {
        return reg_date;
    }
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getLogin_limit() {
        return login_limit;
    }

    public void setLogin_limit(String login_limit) {
        this.login_limit = login_limit;
    }

    public String getVip_type() {
        return vip_type;
    }

    public void setVip_type(String vip_type) {
        this.vip_type = vip_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", reg_date=" + reg_date +
                ", login_limit='" + login_limit + '\'' +
                ", vip_type='" + vip_type + '\'' +
                '}';
    }
}
