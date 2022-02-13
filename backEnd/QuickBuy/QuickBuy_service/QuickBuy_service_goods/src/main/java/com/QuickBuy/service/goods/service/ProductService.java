package com.QuickBuy.service.goods.service;

import com.QuickBuy.goods.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    //调出所有的product
    List<Product> findProList();

    //根据sku返回单独的product
    Product findProId(String Id);

    //按categoryID调出对应的product
    List<Product> findByCat(Map<String, Object> searchMap);
}
