package com.QuickBuy.cart;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_cart")
public class Cart {

    @Id
    private String cart_id;

    private String username;
    private String sku;
    private Integer num;
    private Integer price;

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public String getSku() {
        return sku;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getPrice() {
        return price;
    }
}
