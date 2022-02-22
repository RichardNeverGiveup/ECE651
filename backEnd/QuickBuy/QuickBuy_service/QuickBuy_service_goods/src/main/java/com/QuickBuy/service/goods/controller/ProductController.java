package com.QuickBuy.service.goods.controller;

import com.QuickBuy.common.pojo.Result;
import com.QuickBuy.common.pojo.StatusCode;
import com.QuickBuy.goods.pojo.Product;
import com.QuickBuy.service.goods.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/product")
@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Result<List<Product>> findProList(){
        List<Product> productList = productService.findProList();
        return new Result<>(true, StatusCode.OK, "Query OK", productList);
    }

    @GetMapping("/{id}")
    public Result<Product> findProId(@PathVariable("id") String id){
        Product product = productService.findProId(id);
        return new Result<>(true, StatusCode.OK, "Query OK", product);
    }

    @GetMapping("/category")
    public Result<List<Product>> findByCat(@RequestParam Map<String, Object> searchMap){
        List<Product> productList = productService.findByCat(searchMap);
        return new Result<>(true, StatusCode.OK, "Query OK", productList);
    }

    @GetMapping("/name")
    public Result<List<Product>> findByName(@RequestParam Map<String, Object> searchMap){
        List<Product> productList = productService.findByName(searchMap);
        return new Result<>(true, StatusCode.OK, "Query OK", productList);
    }
}
