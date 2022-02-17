package com.QuickBuy.goods.pojo;

import java.util.List;

public class Goods {

    //spu
    private Spu spu;

    //sku list
    List<Sku> skuList;

    public Spu getSpu() {
        return spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
