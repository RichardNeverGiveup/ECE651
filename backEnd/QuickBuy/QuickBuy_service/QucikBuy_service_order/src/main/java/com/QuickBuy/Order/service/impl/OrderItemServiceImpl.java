package com.QuickBuy.Order.service.impl;

import com.QuickBuy.Order.dao.OrderItemMapper;
import com.QuickBuy.Order.service.OrderItemService;
import com.QuickBuy.order.pojo.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    private OrderItemMapper orderItemMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<OrderItem> findAll() {
        return orderItemMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public OrderItem findById(String id){
        return  orderItemMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param orderItem
     */
    @Override
    public void add(OrderItem orderItem){
        orderItemMapper.insert(orderItem);
    }


    /**
     * 修改
     * @param orderItem
     */
    @Override
    public void update(OrderItem orderItem){
        orderItemMapper.updateByPrimaryKey(orderItem);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        orderItemMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<OrderItem> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return orderItemMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // ID
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andEqualTo("id",searchMap.get("id"));
           	}
            // SPU_ID
            if(searchMap.get("spuId")!=null && !"".equals(searchMap.get("spuId"))){
                criteria.andEqualTo("spuId",searchMap.get("spuId"));
           	}
            // SKU_ID
            if(searchMap.get("skuId")!=null && !"".equals(searchMap.get("skuId"))){
                criteria.andEqualTo("skuId",searchMap.get("skuId"));
           	}
            // 订单ID
            if(searchMap.get("orderId")!=null && !"".equals(searchMap.get("orderId"))){
                criteria.andEqualTo("orderId",searchMap.get("orderId"));
           	}
            // 商品名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // 图片地址
            if(searchMap.get("image")!=null && !"".equals(searchMap.get("image"))){
                criteria.andLike("image","%"+searchMap.get("image")+"%");
           	}
            // 是否退货
            if(searchMap.get("isReturn")!=null && !"".equals(searchMap.get("isReturn"))){
                criteria.andEqualTo("isReturn",searchMap.get("isReturn"));
           	}

            // 1级分类
            if(searchMap.get("categoryId1")!=null ){
                criteria.andEqualTo("categoryId1",searchMap.get("categoryId1"));
            }
            // 2级分类
            if(searchMap.get("categoryId2")!=null ){
                criteria.andEqualTo("categoryId2",searchMap.get("categoryId2"));
            }
            // 3级分类
            if(searchMap.get("categoryId3")!=null ){
                criteria.andEqualTo("categoryId3",searchMap.get("categoryId3"));
            }
            // 单价
            if(searchMap.get("price")!=null ){
                criteria.andEqualTo("price",searchMap.get("price"));
            }
            // 数量
            if(searchMap.get("num")!=null ){
                criteria.andEqualTo("num",searchMap.get("num"));
            }
            // 总金额
            if(searchMap.get("money")!=null ){
                criteria.andEqualTo("money",searchMap.get("money"));
            }
            // 实付金额
            if(searchMap.get("payMoney")!=null ){
                criteria.andEqualTo("payMoney",searchMap.get("payMoney"));
            }
            // 重量
            if(searchMap.get("weight")!=null ){
                criteria.andEqualTo("weight",searchMap.get("weight"));
            }
            // 运费
            if(searchMap.get("postFee")!=null ){
                criteria.andEqualTo("postFee",searchMap.get("postFee"));
            }

        }
        return example;
    }

}
