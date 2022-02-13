package com.QuickBuy.service.goods;

import com.QuickBuy.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient  //声明为eureka客户端
@MapperScan(basePackages = {"com.QuickBuy.services.goods.dao"})
public class GoodsApplication {

    @Value("${workerID}")
    private Integer workerID;

    @Value("${datacenterID}")
    private Integer datacenterID;

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(workerID, datacenterID);
    }
}
