package com.gymSQL.pojo;

import java.util.Date;

public class cardholder {
    private Integer card_id;
    private String card_user;
    private String sex;
    private Integer age;
    private String phone;
    private Date birthday;
    private Double balance;
    private Date card_date;
    private Integer expire_date;
    private String card_state;

    public cardholder() {
    }

    public cardholder(Integer card_id, String card_user, String sex,
                      Integer age, String phone, Date birthday, Double balance, Date card_date, Integer expire_date, String card_state) {
        this.card_id = card_id;
        this.card_user = card_user;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.birthday = birthday;
        this.balance = balance;
        this.card_date = card_date;
        this.expire_date = expire_date;
        this.card_state = card_state;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getCard_user() {
        return card_user;
    }

    public void setCard_user(String card_user) {
        this.card_user = card_user;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCard_date() {
        return card_date;
    }

    public void setCard_date(Date card_date) {
        this.card_date = card_date;
    }

    public Integer getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Integer expire_date) {
        this.expire_date = expire_date;
    }

    public String getCard_state() {
        return card_state;
    }

    public void setCard_state(String card_state) {
        this.card_state = card_state;
    }

    @Override
    public String toString() {
        return "cardholder{" +
                "card_id=" + card_id +
                ", card_user='" + card_user + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", balance=" + balance +
                ", card_date=" + card_date +
                ", expire_date=" + expire_date +
                ", card_state='" + card_state + '\'' +
                '}';
    }
}