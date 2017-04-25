package com.easy.springboot.h5perf.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by jack on 2017/4/23.
 * 有些灵活的配置，还是使用代码，更加灵活方便
 * http://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration.EnableWebMvcConfiguration.html
 */

@Configuration
@EnableWebMvc
class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }


}

//#    mvc:
//#    # 所有的访问都匹配映射到静态资源路径,spring.mvc.static-path-pattern 只可以定义一个，目前不支持多个逗号分割的方式
//#        static-path-pattern: /**
//#
//#    resources:
//#    # 这里的配置是覆盖默认配置，所以需要将默认的也加上否则static、public等这些路径将不能被当作静态资源路径
//#        static-locations: classpath:/static/,classpath:/public/,classpath:/resources/,classpath:/META-INF/resources/,classpath:/META-INF/resources/webjars/
