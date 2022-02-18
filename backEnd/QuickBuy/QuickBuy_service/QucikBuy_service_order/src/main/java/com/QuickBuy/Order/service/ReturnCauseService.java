package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.ReturnCause;

import java.util.List;
import java.util.Map;

public interface ReturnCauseService {

    /***
     * 查询所有
     * @return
     */
    List<ReturnCause> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    ReturnCause findById(Integer id);

    /***
     * 新增
     * @param returnCause
     */
    void add(ReturnCause returnCause);

    /***
     * 修改
     * @param returnCause
     */
    void update(ReturnCause returnCause);

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
    List<ReturnCause> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */




}
