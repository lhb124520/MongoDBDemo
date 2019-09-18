package com.example.demo.configure;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.example.demo.configure
 * @Author: lhb
 * @CreateTime: 2019-05-10 11:57
 * @Description: swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(requestHandler -> requestHandler != null && requestHandler.findControllerAnnotation(Api.class).isPresent())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot工程")
                .description("springboot工程 swagger restful APIS")
                .version("1.0")
                .build();
    }
}
