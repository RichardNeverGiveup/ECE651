package com.ecommerce.ecommercesystem.service;

import com.ecommerce.ecommercesystem.model.UserLogin;
import org.apache.catalina.User;

public interface UserLoginService {
    public UserLogin addUser(UserLogin user);
}
