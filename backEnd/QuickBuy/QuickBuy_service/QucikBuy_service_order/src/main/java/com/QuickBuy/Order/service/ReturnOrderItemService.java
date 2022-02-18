package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.ReturnOrderItem;


import java.util.List;
import java.util.Map;

public interface ReturnOrderItemService {

    /***
     * 查询所有
     * @return
     */
    List<ReturnOrderItem> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    ReturnOrderItem findById(String id);

    /***
     * 新增
     * @param returnOrderItem
     */
    void add(ReturnOrderItem returnOrderItem);

    /***
     * 修改
     * @param returnOrderItem
     */
    void update(ReturnOrderItem returnOrderItem);

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
    List<ReturnOrderItem> findList(Map<String, Object> searchMap);





}
