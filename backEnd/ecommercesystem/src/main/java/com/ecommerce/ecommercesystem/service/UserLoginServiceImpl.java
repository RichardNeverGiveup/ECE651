package com.ecommerce.ecommercesystem.service;

import com.ecommerce.ecommercesystem.model.UserLogin;
import com.ecommerce.ecommercesystem.repository.UserLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService{
    @Autowired
    private UserLoginRepo userLoginRepo;

    @Override
    public UserLogin addUser(UserLogin user) {
        return userLoginRepo.save(user);
    }
}
