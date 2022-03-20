package com.QuickBuy.Order.dao;

import com.QuickBuy.order.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import tk.mybatis.mapper.common.Mapper;

public interface OrderMapper extends Mapper<Order> {

    @Insert("INSERT INTO tb_order(total_num, total_money, username) VALUES(#{totalNum}, #{totalMoney}, #{username})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertOrder(Order order);



}
