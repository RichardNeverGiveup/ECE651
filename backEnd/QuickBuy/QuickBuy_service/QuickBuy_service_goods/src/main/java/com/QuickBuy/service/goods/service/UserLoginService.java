package com.QuickBuy.service.goods.service;

import com.QuickBuy.goods.pojo.Brand;
import com.QuickBuy.goods.pojo.UserLogin;
import org.apache.catalina.User;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLException;
import java.util.List;

public interface UserLoginService {

    int addUser(UserLogin user);

    Boolean checkUserExistence(UserLogin user);

    void updatePassword(UserLogin user);

    Boolean checkPassword(UserLogin user);

    List<UserLogin> findList();
}
