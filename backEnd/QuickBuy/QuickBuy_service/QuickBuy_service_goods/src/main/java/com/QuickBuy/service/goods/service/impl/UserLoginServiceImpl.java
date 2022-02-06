package com.QuickBuy.service.goods.service.impl;

import com.QuickBuy.goods.pojo.Brand;
import com.QuickBuy.goods.pojo.UserLogin;
import com.QuickBuy.service.goods.dao.UserLoginMapper;
import com.QuickBuy.service.goods.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService{
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> findList() {
        return userLoginMapper.selectAll();
    }

    @Override
    @Transactional
    public int addUser(UserLogin user) {
        return userLoginMapper.insert(user);
    }

    @Override
    public Boolean checkUserExistence(UserLogin user) {
        return userLoginMapper.existsWithPrimaryKey(user.getUsername());
    }

    @Override
    public Boolean checkPassword(UserLogin user) {
        return userLoginMapper.selectByPrimaryKey(user.getUsername()).getPassword().equals(user.getPassword());
    }

    @Override
    @Transactional
    public void updatePassword(UserLogin user) {
        userLoginMapper.updatePasswordValues(user);
    }
}
