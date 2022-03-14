package com.QuickBuy.goods.feign;


import com.QuickBuy.common.pojo.Result;
import com.QuickBuy.goods.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "goods")
public interface ProductFeign {

    @GetMapping("/product/{id}")
    public Result<Product> findProId(@PathVariable("id") String id);

}
