package com.gymSQL.pojo;

public class card_type {
    private Integer card_id;
    private String card_name;
    private Double card_price;
    private Integer indate;
    private Double discount;

    public card_type() {
    }
    public card_type(Integer card_id, String card_name, Double card_price, Integer indate, Double discount) {
        this.card_id = card_id;
        this.card_name = card_name;
        this.card_price = card_price;
        this.indate = indate;
        this.discount = discount;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public Double getCard_price() {
        return card_price;
    }

    public void setCard_price(Double card_price) {
        this.card_price = card_price;
    }

    public Integer getIndate() {
        return indate;
    }

    public void setIndate(Integer indate) {
        this.indate = indate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "card_type{" +
                "card_id=" + card_id +
                ", card_name='" + card_name + '\'' +
                ", card_price=" + card_price +
                ", indate=" + indate +
                ", discount=" + discount +
                '}';
    }
}
