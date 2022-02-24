package com.QuickBuy.Order.service;

import com.QuickBuy.order.pojo.Preferential;

import java.util.List;
import java.util.Map;

public interface PreferentialService {

    /***
     * 查询所有
     * @return
     */
    List<Preferential> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Preferential findById(Integer id);

    /***
     * 新增
     * @param preferential
     */
    void add(Preferential preferential);

    /***
     * 修改
     * @param preferential
     */
    void update(Preferential preferential);

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
    List<Preferential> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */


}
