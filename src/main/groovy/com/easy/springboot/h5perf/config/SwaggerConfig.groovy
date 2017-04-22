package com.easy.springboot.h5perf.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

/**
 * Created by jack on 2017/4/23.
 */

@Configuration
class SwaggerConfig {

    /**
     * Docket: Springfox’s, primary api configuration mechanism is initialized for swagger specification 2.0
     *
     * A builder which is intended to be the primary interface into the swagger-springmvc framework.
     * Provides sensible defaults and convenience methods for configuration.
     * @return
     */
    @Bean
    Docket myApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.easy.springboot.h5perf"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()

    }

    def apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot集成Swagger2构建自动化Rest API文档")
                .description("Spring Boot开发从0到1教程")
                .version("1.0")
                .build()
    }
}
