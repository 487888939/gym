package com.gymSQL.pojo;

import java.util.Date;

public class equipment{
    private Integer id;
    private String equ_name;
	private Integer account;
    private Double purchase;
    private String merchant;
    private Date buy_time;
    private String equ_state;

    public equipment() {
    }

    public equipment(Integer id, String equ_name, Integer account, Double purchase, String merchant, Date buy_time, String equ_state) {
        this.id = id;
        this.equ_name = equ_name;
        this.account = account;
        this.purchase = purchase;
        this.merchant = merchant;
        this.buy_time = buy_time;
        this.equ_state = equ_state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEqu_name() {
        return equ_name;
    }

    public void setEqu_name(String equ_name) {
        this.equ_name = equ_name;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Double getPurchase() {
        return purchase;
    }

    public void setPurchase(Double purchase) {
        this.purchase = purchase;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Date getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(Date buy_time) {
        this.buy_time = buy_time;
    }

    public String getEqu_state() {
        return equ_state;
    }

    public void setEqu_state(String equ_state) {
        this.equ_state = equ_state;
    }

    @Override
    public String toString() {
        return "equipment{" +
                "id=" + id +
                ", equ_name='" + equ_name + '\'' +
                ", account=" + account +
                ", purchase=" + purchase +
                ", merchant='" + merchant + '\'' +
                ", buy_time=" + buy_time +
                ", equ_state='" + equ_state + '\'' +
                '}';
    }
}
