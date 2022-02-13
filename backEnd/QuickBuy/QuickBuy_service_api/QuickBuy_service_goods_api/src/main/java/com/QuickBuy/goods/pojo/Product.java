package com.QuickBuy.goods.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tb_sku")
public class Product implements Serializable {

    @Id
    private String sku;

    private String name;
    private Integer price;
    private Integer num;
    private String image;
    private String unit;
    private Date create_time;
    private Date update_time;
    private Long spu_id;
    private Integer category_id;
    private String category_name;
    private String brand_name;
    private String spec;
    private Integer sale_num;
    private Integer comment_num;
    private String status;

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void setSale_num(Integer sale_num) {
        this.sale_num = sale_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNum() {
        return num;
    }

    public String getImage() {
        return image;
    }

    public String getUnit() {
        return unit;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public Long getSpu_id() {
        return spu_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getSpec() {
        return spec;
    }

    public Integer getSale_num() {
        return sale_num;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public String getStatus() {
        return status;
    }
}
