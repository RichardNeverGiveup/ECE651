package com.QuickBuy.service.goods.service.impl;

import com.QuickBuy.goods.pojo.Brand;
import com.QuickBuy.service.goods.dao.BrandMapper;

//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;

import com.QuickBuy.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    //品牌列表查询
    @Override
    public List<Brand> findList() {
        return brandMapper.selectAll();
    }

    //根据ID查询品牌信息
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    //添加品牌
    @Override
    @Transactional
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    //根据ID修改品牌
    @Override
    @Transactional
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    //根据ID删除品牌
    @Override
    @Transactional
    public void delById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    //品牌条件查询
    @Override
    public List<Brand> list(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);

        //封装查询条件
        Example.Criteria criteria = example.createCriteria();
        if(searchMap != null){
            //品牌名称（模糊查询）: like, %
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))){  //确保searchMap的name有内容
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }

            //按品牌首字母查询(精确查询)
            if(searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))){
                criteria.andEqualTo("letter", searchMap.get("letter"));
            }

        }

        return brandMapper.selectByExample(example);
    }


   /* @Override

    public Page<Brand> findPage(int page, int size) {

        PageHelper.startPage(page, size);
        return (Page<Brand>)brandMapper.selectAll();
    }

    @Override
    public Page<Brand> findPage(Map<String, Object> searchMap, int page, int size) {

        //设置分页
        PageHelper.startPage(page, size);

        //设置查询条件
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
//        brandMapper.selectByExample(example);
        //封装查询条件
        if(searchMap != null){
            //品牌名称（模糊查询）: like, %
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))){  //确保searchMap的name有内容
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }

            //按品牌首字母查询(精确查询)
            if(searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))){
                criteria.andEqualTo("letter", searchMap.get("letter"));
            }

        }

        return (Page<Brand>)brandMapper.selectByExample(example);
    }

    }*/
}
