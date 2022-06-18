package com.gymSQL.pojo;

public class goods {
    private Integer id;
    private String g_name;
    private Double g_price;
    private Integer g_account;
    private String g_brand;

    public goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public Double getG_price() {
        return g_price;
    }

    public void setG_price(Double g_price) {
        this.g_price = g_price;
    }

    public Integer getG_account() {
        return g_account;
    }

    public void setG_account(Integer g_account) {
        this.g_account = g_account;
    }

    public String getG_brand() {
        return g_brand;
    }

    public void setG_brand(String g_brand) {
        this.g_brand = g_brand;
    }

    @Override
    public String toString() {
        return "goods{" +
                "id=" + id +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_account=" + g_account +
                ", g_brand='" + g_brand + '\'' +
                '}';
    }
}
