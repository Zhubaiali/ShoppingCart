package com.ywp.shoppingcartbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.ywp.shoppingcartbackend.mapper")
@EnableScheduling
public class shoppingcartBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(shoppingcartBackendApplication.class, args);
    }

}
