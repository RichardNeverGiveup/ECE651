package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {

    //展示当前用户的购物车信息
    List<Cart> showCart(Map<String, Object> searchMap);

    //添加到购物车
    void addCart(Integer num, String username, String sku);

    //删除购物车(全部)
    void deleteFullCart(Map<String, Object> searchMap);

    //删除购物车(单独)
    void deleteSingleCart(String username, String sku);

    //更新购物车
    void updateCart(Integer num, String username, String sku);

    //结账
    void checkOut(String username);

}
