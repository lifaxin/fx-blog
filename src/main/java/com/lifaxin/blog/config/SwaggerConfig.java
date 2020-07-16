package com.lifaxin.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

/**
 * @Description Swagger 配置
 * @Author LiFaXin
 * @Date 2020/7/7 20:15
 * @Version
 **/
@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("FX博客系统")
                        .title("FX博客系统接口文档")
                        .version("1.0.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lifaxin.blog.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
