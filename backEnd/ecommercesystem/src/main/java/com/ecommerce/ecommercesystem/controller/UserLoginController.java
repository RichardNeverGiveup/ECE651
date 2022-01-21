package com.ecommerce.ecommercesystem.controller;

import com.ecommerce.ecommercesystem.model.UserLogin;
import com.ecommerce.ecommercesystem.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin

public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/add")
    public String add(@RequestBody UserLogin userLogin){
        userLoginService.addUser(userLogin);
        return "new user added";
    }
}
