package com.QuickBuy.Cart.service.impl;

import com.QuickBuy.Cart.dao.CartMapper;
import com.QuickBuy.Cart.service.CartService;
import com.QuickBuy.cart.Cart;
import com.QuickBuy.service.goods.dao.ProductMapper;
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

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Cart> showCart(Map<String, Object> searchMap) {

        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("username", searchMap.get("username"));
        return cartMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void addCart(Integer num, String username, String sku) {

        //添加购物车主键
        String cart_id = username+"_"+sku;
        //获取当前添加商品的价格
        int price = productMapper.selectByPrimaryKey(sku).getPrice();

        //封装进cart实体类
        Cart cart = new Cart();
        cart.setNum(num);
        cart.setUsername(username);
        cart.setCart_id(cart_id);
        cart.setPrice(price);
        cart.setSku(sku);

        cartMapper.insert(cart);
    }

    @Override
    public void deleteFullCart(Map<String, Object> searchMap) {
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("username", searchMap.get("username"));
        cartMapper.deleteByExample(example);
    }

    @Override
    public void deleteSingleCart(String username, String sku){
        String cart_id = username+"_"+sku;
        cartMapper.deleteByPrimaryKey(cart_id);
    }

    @Override
    public void updateCart(Integer num, String username, String sku) {
        String cart_id = username+"_"+sku;
        Cart cart = cartMapper.selectByPrimaryKey(cart_id);
        cart.setNum(num);

        cartMapper.updateByPrimaryKey(cart);
    }


}
