package com.QuickBuy.service.goods.controller;

import com.QuickBuy.common.pojo.Result;
import com.QuickBuy.common.pojo.StatusCode;
import com.QuickBuy.goods.pojo.UserLogin;
import com.QuickBuy.service.goods.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
@CrossOrigin

public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    /*
    Secure Password requirements
    Password must contain at least one digit [0-9].
    Password must contain at least one lowercase Latin character [a-z].
    Password must contain at least one uppercase Latin character [A-Z].
    Password must contain at least one special character like ! @ # & ( ).
    Password must contain a length of at least 8 characters and a maximum of 20 characters.
    */

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @PostMapping("/add")
    public Result add(@RequestBody UserLogin userLogin){
        Matcher matcher = pattern.matcher(userLogin.getPassword());
        if (matcher.matches()) {
            try {
                userLoginService.addUser(userLogin);
            } catch (Exception e) {
                return new Result(false, StatusCode.ERROR, "Duplicated Username.");
            }
            return new Result(true, StatusCode.OK, "Add OK.");
        } else {
            return new Result(false, StatusCode.ERROR, "Invalid Password.");
        }

    }

    @PostMapping("/update")
    public Result update(@RequestBody UserLogin userLogin){

        if (userLoginService.checkUserExistence(userLogin)){
            Matcher matcher =pattern.matcher(userLogin.getPassword());
            if (matcher.matches()) {
                try {
                    userLoginService.updatePassword(userLogin);
                } catch (Exception e) {
                    return new Result(false, StatusCode.ERROR, "System error.");
                }
                return new Result(true, StatusCode.OK, "Update OK.");
            } else {
                return new Result(false, StatusCode.ERROR, "Invalid Password.");
            }
        } else {
            return new Result(false, StatusCode.ERROR, "User doesn't exist.");
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserLogin userLogin){
        if (userLoginService.checkUserExistence(userLogin)){
           if (userLoginService.checkPassword(userLogin)){
               return new Result(true, StatusCode.OK, "Log in OK.");
           } else {
               return new Result(false, StatusCode.ERROR, "Wrong Password.");
           }
        } else {
            return new Result(false, StatusCode.ERROR, "User doesn't exist.");
        }

    }


}
