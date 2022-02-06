package com.QuickBuy.goods.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_brand")
public class Brand implements Serializable {

    @Id
    private Integer id; //品牌ID
    private String name; //品牌名称
    private String image; //品牌图片地址
    private String letter; //品牌首字母
    private String seq; //排序

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getLetter() {
        return letter;
    }

    public String getSeq() {
        return seq;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
