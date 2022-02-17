package com.QuickBuy.service.goods.service;

import com.QuickBuy.goods.pojo.UserLogin;

import java.util.List;

public interface UserLoginService {

    int addUser(UserLogin user);

    Boolean checkUserExistence(UserLogin user);

    void updatePassword(UserLogin user);

    Boolean checkPassword(UserLogin user);

    List<UserLogin> findList();
}
