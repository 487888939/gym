package com.gymSQL.pojo;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.Date;

public class coach {
    private Integer id;
    private String coach_name;
    private String coach_sex;
    private int coach_age;
    private String coach_phone;
    private String pre_address;
    private Date hire_date;
    private String coach_state;
    private Integer teaching_age;
    private Double salary;

    public coach() {
    }

    public coach(Integer id, String coach_name, String coach_sex,
                 int coach_age, String coach_phone, String pre_address,
                 Date hire_date, String coach_state, Integer teaching_age, Double salary) {
        this.id = id;
        this.coach_name = coach_name;
        this.coach_sex = coach_sex;
        this.coach_age = coach_age;
        this.coach_phone = coach_phone;
        this.pre_address = pre_address;
        this.hire_date = hire_date;
        this.coach_state = coach_state;
        this.teaching_age = teaching_age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoach_name() {
        return coach_name;
    }

    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    public String getCoach_sex() {
        return coach_sex;
    }

    public void setCoach_sex(String coach_sex) {
        this.coach_sex = coach_sex;
    }

    public int getCoach_age() {
        return coach_age;
    }

    public void setCoach_age(int coach_age) {
        this.coach_age = coach_age;
    }

    public String getCoach_phone() {
        return coach_phone;
    }

    public void setCoach_phone(String coach_phone) {
        this.coach_phone = coach_phone;
    }

    public String getPre_address() {
        return pre_address;
    }

    public void setPre_address(String pre_address) {
        this.pre_address = pre_address;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getCoach_state() {
        return coach_state;
    }

    public void setCoach_state(String coach_state) {
        this.coach_state = coach_state;
    }

    public Integer getTeaching_age() {
        return teaching_age;
    }

    public void setTeaching_age(Integer teaching_age) {
        this.teaching_age = teaching_age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "coach{" +
                "id=" + id +
                ", coach_name='" + coach_name + '\'' +
                ", coach_sex='" + coach_sex + '\'' +
                ", coach_age=" + coach_age +
                ", coach_phone='" + coach_phone + '\'' +
                ", pre_address='" + pre_address + '\'' +
                ", hire_date=" + hire_date +
                ", coach_state='" + coach_state + '\'' +
                ", teaching_age=" + teaching_age +
                ", salary=" + salary +
                '}';
    }
}
