package com.ywp.shppingcartbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.ywp.shppingcartbackend.mapper")
@EnableScheduling
public class ShppingcartBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShppingcartBackendApplication.class, args);
    }

}
