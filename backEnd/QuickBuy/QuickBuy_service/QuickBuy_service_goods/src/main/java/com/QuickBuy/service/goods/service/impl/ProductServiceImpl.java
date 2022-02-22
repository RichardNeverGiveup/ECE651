package com.QuickBuy.service.goods.service.impl;

import com.QuickBuy.goods.pojo.Product;
import com.QuickBuy.service.goods.dao.ProductMapper;
import com.QuickBuy.service.goods.service.ProductService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource(type = ProductMapper.class)
    private ProductMapper productMapper;

    //返回全部的product
    @Override
    public List<Product> findProList(){

        return productMapper.selectAll();
    }

    //根据sku返回单独的product
    @Override
    public Product findProId(String Id) {

        return productMapper.selectByPrimaryKey(Id);
    }

    @Override
    public List<Product> findByCat(Map<String, Object> searchMap) {

        Example example = new Example(Product.class);

        Example.Criteria criteria = example.createCriteria();
        if(searchMap != null){

            //Search by category_id
            if(searchMap.get("category_id") != null && !"".equals(searchMap.get("category_id"))){
                criteria.andEqualTo("category_id", searchMap.get(("category_id")));
            }

        }

        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> findByName(Map<String, Object> searchMap) {
        Example example = new Example(Product.class);

        Example.Criteria criteria = example.createCriteria();
        if(searchMap != null){

            //Search by name(like)
            if(searchMap.get("name") != null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
        }

        return productMapper.selectByExample(example);
    }


}
