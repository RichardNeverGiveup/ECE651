package com.QuickBuy.Cart.controller;

import com.QuickBuy.Cart.service.CartService;
import com.QuickBuy.cart.Cart;
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
    public Result addCart(@RequestParam("num") Integer num, @RequestParam("username") String username, @RequestParam("sku") String sku){
        cartService.addCart(num,username,sku);
        return new Result(true, StatusCode.OK, "Add OK.");
    }

    @DeleteMapping("/deleteFull")
    public Result deleteFullCart(@RequestParam Map<String, Object> searchMap){
        cartService.deleteFullCart(searchMap);
        return new Result(true, StatusCode.OK, "Delete OK.");
    }

    @DeleteMapping("/deleteSingle")
    public Result deleteSingleCart(@RequestParam("username") String username, @RequestParam("sku") String sku){
        cartService.deleteSingleCart(username,sku);
        return new Result(true, StatusCode.OK, "Delete OK.");
    }
    @PutMapping("/update")
    public Result updateCart(@RequestParam("num") Integer num, @RequestParam("username") String username, @RequestParam("sku") String sku){
        cartService.updateCart(num, username, sku);
        return new Result(true, StatusCode.OK, "Delete OK.");
    }
}
