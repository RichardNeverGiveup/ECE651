package com.QuickBuy.Order.controller;

import com.QuickBuy.Order.service.CartService;
import com.QuickBuy.order.pojo.Cart;
import com.QuickBuy.common.pojo.Result;
import com.QuickBuy.common.pojo.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/cart")
@RestController
@CrossOrigin

public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/showCart")
    public Result<List<Cart>> showCart(@RequestParam Map<String, Object> searchMap){
        List<Cart> cartList = cartService.showCart(searchMap);
        return new Result<>(true, StatusCode.OK, "Query OK.", cartList);
    }

    @PostMapping("/addCart")
    public Result addCart(@RequestParam Map<String, String> searchMap){
        cartService.addCart(Integer.parseInt(searchMap.get("num")),searchMap.get("username"),searchMap.get("sku"));
        return new Result(true, StatusCode.OK, "Add OK.");
    }

    @DeleteMapping("/deleteFull")
    public Result deleteFullCart(@RequestParam Map<String, Object> searchMap){
        cartService.deleteFullCart(searchMap);
        return new Result(true, StatusCode.OK, "Delete OK.");
    }

    @DeleteMapping("/deleteSingle")
    public Result deleteSingleCart(@RequestParam Map<String, String> searchMap){
        cartService.deleteSingleCart(searchMap.get("username"),searchMap.get("sku"));
        return new Result(true, StatusCode.OK, "Delete OK.");
    }
    @PutMapping("/update")
    public Result updateCart(@RequestParam Map<String, String> searchMap){
        cartService.updateCart(Integer.parseInt(searchMap.get("num")),searchMap.get("username"),searchMap.get("sku"));
        return new Result(true, StatusCode.OK, "Update OK.");
    }
}
