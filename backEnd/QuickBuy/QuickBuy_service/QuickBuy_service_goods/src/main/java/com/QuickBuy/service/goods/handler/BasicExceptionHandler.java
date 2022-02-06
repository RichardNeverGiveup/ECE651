package com.QuickBuy.service.goods.handler;

import com.QuickBuy.common.pojo.Result;
import com.QuickBuy.common.pojo.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//该类用于统一异常处理
@ControllerAdvice  //声明该类是一个增强类，
public class BasicExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, "System error, please try again later.");
    }
}
