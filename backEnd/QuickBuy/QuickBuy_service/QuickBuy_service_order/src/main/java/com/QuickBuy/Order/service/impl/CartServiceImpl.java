package com.QuickBuy.Order.service.impl;

import com.QuickBuy.Order.dao.CartMapper;
import com.QuickBuy.Order.dao.OrderItemMapper;
import com.QuickBuy.Order.service.CartService;
import com.QuickBuy.order.pojo.Cart;
import com.QuickBuy.order.pojo.Order;
import com.QuickBuy.order.pojo.OrderItem;
import com.QuickBuy.service.goods.dao.ProductMapper;
import com.QuickBuy.Order.dao.OrderMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService{

    @Resource(type = CartMapper.class)
    private CartMapper cartMapper;

    @Resource(type = ProductMapper.class)
    private ProductMapper productMapper;

    @Resource(type = OrderMapper.class)
    private OrderMapper orderMapper;

    @Resource(type = OrderItemMapper.class)
    private OrderItemMapper orderItemMapper;

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
        String image = productMapper.selectByPrimaryKey(sku).getImage();
        String name = productMapper.selectByPrimaryKey(sku).getName();

        //封装进cart实体类
        Cart cart = new Cart();
        cart.setNum(num);
        cart.setUsername(username);
        cart.setCart_id(cart_id);
        cart.setPrice(price);
        cart.setSku(sku);
        cart.setImage(image);
        cart.setName(name);

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

    @Override
    public void checkOut(String username, Integer num, Integer money) {
        //查询所有该用户的购物车信息
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);

        List<Cart> cartList = cartMapper.selectByExample(example);

        Order order = new Order();
        order.setUsername(username);
        order.setTotalNum(num);
        order.setTotalMoney(money);
        orderMapper.insertOrder(order);
        String orderId = order.getId();

        OrderItem orderItem;
        for(Cart cart : cartList){
            orderItem = new OrderItem();
            orderItem.setId(orderId+"_"+cart.getCart_id());
            orderItem.setOrderId(orderId);
            orderItem.setName(cart.getName());
            orderItem.setSkuId(cart.getSku());
            orderItem.setPrice(cart.getPrice());
            orderItem.setNum(cart.getNum());
            orderItemMapper.insert(orderItem);
            cartMapper.delete(cart);
        }

    }

}
