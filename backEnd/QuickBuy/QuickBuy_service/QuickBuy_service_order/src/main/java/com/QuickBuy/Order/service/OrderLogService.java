package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.OrderLog;


import java.util.List;
import java.util.Map;

public interface OrderLogService {

    /***
     * 查询所有
     * @return
     */
    List<OrderLog> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    OrderLog findById(String id);

    /***
     * 新增
     * @param orderLog
     */
    void add(OrderLog orderLog);

    /***
     * 修改
     * @param orderLog
     */
    void update(OrderLog orderLog);

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
    List<OrderLog> findList(Map<String, Object> searchMap);







}
