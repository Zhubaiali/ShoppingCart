package com.ywp.shoppingcartbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("com.ywp.shoppingcartbackend.mapper")
@EnableScheduling
public class ShoppingcartBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingcartBackendApplication.class, args);
        System.out.println("----------------------start success-----------------------");
    }

}
