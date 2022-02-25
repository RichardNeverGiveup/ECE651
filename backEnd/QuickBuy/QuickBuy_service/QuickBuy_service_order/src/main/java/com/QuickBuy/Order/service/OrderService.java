package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    /***
     * 查询所有
     * @return
     */
    List<Order> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Order findById(String id);

    /***
     * 新增
     * @param order
     */
    void add(Order order);

    /***
     * 修改
     * @param order
     */
    void update(Order order);

    /***
     * 删除
     * @param id
     */
    void delete(String id);

    /***
     * 多条件搜索
     * @param searchMap
     * @return
     */
    List<Order> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */




}
