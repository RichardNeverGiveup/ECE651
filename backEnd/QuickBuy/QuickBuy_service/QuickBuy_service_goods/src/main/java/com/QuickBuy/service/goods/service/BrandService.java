package com.QuickBuy.service.goods.service;

import com.QuickBuy.goods.pojo.Brand;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface BrandService {
    //品牌列表查询方法
    List<Brand> findList();

    //根据品牌查询数据
    Brand findById(Integer id);

    //新增品牌
    void add(Brand brand);

    //品牌修改
    void update(Brand brand);

    //品牌删除
    void delById(Integer id);

    //品牌条件查询
    List<Brand> list(Map<String, Object> searchMap);

    //品牌列表分页查询
    //page: current page, size: How many result per page
    Page<Brand> findPage(int page, int size);

    //品牌分页+条件查询
    Page<Brand> findPage(Map<String, Object> searchMap, int page, int size);
}
