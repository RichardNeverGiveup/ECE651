package com.QuickBuy.Cart.service.impl;

import com.QuickBuy.Cart.dao.CartMapper;
import com.QuickBuy.Cart.service.CartService;
import com.QuickBuy.cart.Cart;
import com.QuickBuy.goods.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> showCart(Map<String, Object> searchMap) {

        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("username", searchMap.get("username"));
        return cartMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void addCart(Cart cart) {
        cartMapper.insert(cart);
    }

    @Override
    public void deleteCart(Map<String, Object> searchMap) {
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("username", searchMap.get("username"));
        cartMapper.deleteByExample(example);
    }

    @Override
    public void updateCart(Cart cart, Map<String, Object> searchMap) {
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("username", searchMap.get("username"));
        cartMapper.updateByExample(cart, example);
    }


}
