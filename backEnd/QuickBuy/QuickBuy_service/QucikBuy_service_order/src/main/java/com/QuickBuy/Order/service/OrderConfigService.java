package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.OrderConfig;


import java.util.List;
import java.util.Map;

public interface OrderConfigService {

    /***
     * 查询所有
     * @return
     */
    List<OrderConfig> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    OrderConfig findById(Integer id);

    /***
     * 新增
     * @param orderConfig
     */
    void add(OrderConfig orderConfig);

    /***
     * 修改
     * @param orderConfig
     */
    void update(OrderConfig orderConfig);

    /***
     * 删除
     * @param id
     */
    void delete(Integer id);

    /***
     * 多条件搜索
     * @param searchMap
     * @return
     */
    List<OrderConfig> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */




}
