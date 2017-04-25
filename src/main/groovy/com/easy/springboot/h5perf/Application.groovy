package com.easy.springboot.h5perf

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

/**
 * Created by jack on 2017/4/22.
 */
@SpringBootApplication
@ComponentScan("com.easy.springboot.h5perf")
//@MapperScan('com.easy.springboot.h5perf.mapper') // 此处注解，与在Mapper接口上添加@Mapper注解功能等效
class Application implements CommandLineRunner {
    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }

    @Override
    void run(String... args) throws Exception {


    }
}
