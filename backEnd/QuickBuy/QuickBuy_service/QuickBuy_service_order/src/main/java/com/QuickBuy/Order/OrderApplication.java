package com.QuickBuy.Order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.QuickBuy.goods.feign")
@MapperScan(basePackages = {"com.QuickBuy.Order.dao"})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run( OrderApplication.class);
    }
}
