package com.QuickBuy.service.goods.dao;

import com.QuickBuy.goods.pojo.UserLogin;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserLoginMapper extends Mapper<UserLogin> {

    @Update({"<script>",
            "update user_login",
            "  <set>",
            "    <if test='password != null'>password=#{password},</if>",
            "  </set>",
            "where username=#{username}",
            "</script>"})
    void updatePasswordValues(UserLogin userLogin);
}
