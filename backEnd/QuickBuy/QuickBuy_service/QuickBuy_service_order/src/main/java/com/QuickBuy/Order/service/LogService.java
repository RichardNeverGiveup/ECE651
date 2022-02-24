package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.Log;


import java.util.List;
import java.util.Map;

public interface LogService {

    /***
     * 查询所有
     * @return
     */
    List<Log> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Log findById(Long id);

    /***
     * 新增
     * @param log
     */
    void add(Log log);

    /***
     * 修改
     * @param log
     */
    void update(Log log);

    /***
     * 删除
     * @param id
     */
    void delete(Long id);

    /***
     * 多条件搜索
     * @param searchMap
     * @return
     */
    List<Log> findList(Map<String, Object> searchMap);





}
