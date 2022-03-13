package com.QuickBuy.Cart.service;

import com.QuickBuy.cart.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {

    //展示当前用户的购物车信息
    List<Cart> showCart(Map<String, Object> searchMap);

    //添加到购物车
    void addCart(Cart cart);

    //删除购物车
    void deleteCart(Map<String, Object> searchMap);

    //更新购物车
    void updateCart(Cart cart, Map<String, Object> searchMap);

    //结账
//    void checkOut(String username);

}
