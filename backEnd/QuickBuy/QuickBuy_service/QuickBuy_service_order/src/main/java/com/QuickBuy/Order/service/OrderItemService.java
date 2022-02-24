package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.OrderItem;


import java.util.List;
import java.util.Map;

public interface OrderItemService {

    /***
     * 查询所有
     * @return
     */
    List<OrderItem> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    OrderItem findById(String id);

    /***
     * 新增
     * @param orderItem
     */
    void add(OrderItem orderItem);

    /***
     * 修改
     * @param orderItem
     */
    void update(OrderItem orderItem);

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
    List<OrderItem> findList(Map<String, Object> searchMap);






}
