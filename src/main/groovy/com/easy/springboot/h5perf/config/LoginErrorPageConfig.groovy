package com.easy.springboot.h5perf.config

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.web.servlet.ErrorPage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus

/**
 * Created by jack on 2017/4/24.
 */
@Configuration
class LoginErrorPageConfig {
    @Bean
    EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        new MyCustomizer()
    }

    class MyCustomizer implements EmbeddedServletContainerCustomizer {
        void customize(ConfigurableEmbeddedServletContainer container) {
            //对于返回值为HttpStatus.FORBIDDEN的请求，将其交给/403进行处理。
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"))
        }
    }
}
