package com.ywp.shoppingcartbackend.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("http://localhost:8088"))
                .info(new Info().title("丽娃购物车商城系统")
                        .description("丽娃购物车商城文档")
                        .contact(new Contact().name("liwa").email("111@qq.com").url("https://github.com/zhubaiali"))
                        .version("1.0"));
    }
}
