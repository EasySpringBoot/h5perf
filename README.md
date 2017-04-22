
第14章 Spring Boot集成Swagger2构建自动化Rest API文档
====

##Swagger2的API文档


在以往的项目中，关于API接口文档，我们一般使用wiki或者干脆就是“线下文档”。缺点是很明显的：在迭代开发过程中，API会频繁变动，这样文档需要同步修改。繁琐。如果不及时更新，就会出生调用方没有及时了解到API签名的变化，导致较大的沟通很改动成本。

 微服务时代，效率第一。

使用Swagger可以在部署的时候，实时生成最新的在线API文档，而且不仅仅是文档，同时支持API接口的测试。

我们使用Swagger，只需要在我们的开发代码中，加上少量的注解配置，即可 自动化构建Rest API文档。在多人协作的开发过程中，API文档不仅可以减少等待，也能保证开发的持续进行。有一些单元测试框架可以生成API文档，而Swagger可以在不写单元测试的情况下生成在线的API页面，并且可以直接在页面进行API调试。


##SpringBoot集成Swagger2步骤

1.添加工程依赖的jar

在build.gradle中添加swagger2的依赖：
```
    // https://mvnrepository.com/artifact/io.springfox/springfox-swagger2
    compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.6.1'
   // https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
    compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.6.1'

```

完整的build.gradle配置如下：

```
group 'com.easy.springboot'
version '1.0-SNAPSHOT'

apply plugin: 'groovy'
apply plugin: 'java'
apply plugin: 'org.springframework.boot'

sourceCompatibility = 1.8

repositories {
//    mavenCentral()
//    jcenter()
    maven {
        url 'http://maven.aliyun.com/nexus/content/groups/public/'
    }

}

dependencies {
    compile 'org.codehaus.groovy:groovy-all:2.3.11'
    testCompile group: 'junit', name: 'junit', version: '4.12'

    compile('org.springframework.boot:spring-boot-starter-web')
    
    // https://mvnrepository.com/artifact/io.springfox/springfox-swagger2
    compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.6.1'
   // https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
    compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.6.1'

}

buildscript {
    ext {
        springBootVersion = '1.5.2.RELEASE'
    }
    repositories {
//        mavenCentral()
//        jcenter()
        maven {
            url 'http://maven.aliyun.com/nexus/content/groups/public/'
        }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

```

2.配置Swagger的Docket Bean
```
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
```
这个 Docket类，是Springfox 框架的API配置机制实现的builder类。

我们通过@Configuration标记此类为配置类，会在SpringBoot项目启动的时候加载，
实际上我们已经完成了对Swagger的配置，Swagger会自动扫描我们配置的cn.com.wenyi.controller包下的接口自动生成接口文档。

3.配置WebMvc的addResourceHandlers
```
package com.easy.springboot.h5perf.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by jack on 2017/4/23.
 * http://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/web/WebMvcAutoConfiguration.EnableWebMvcConfiguration.html
 */

@Configuration
class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }


}

```
4.Swagger的API注解在Controller上面的使用
```
package com.easy.springboot.h5perf.controller

import com.easy.springboot.h5perf.mapper.TestCaseMapper
import com.easy.springboot.h5perf.model.TestCase
import com.easy.springboot.h5perf.result.Result
import groovy.json.JsonOutput
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by jack on 2017/4/22.
 * http://springfox.github.io/springfox/docs/current/#springfox-samples
 */
@Api(value = "测试任务管理", tags = ["测试任务管理API"], description = "描述信息")
@Controller
class TestCaseController {
    @Autowired
    TestCaseMapper testCaseMapper

    @PostMapping("/saveTestCase")
    @ResponseBody
    def saveTestCase(TestCase testCase) {
        testCase.gmtCreated = new Date()
        println("testCase===" + testCase)
        int insert = testCaseMapper.insert(testCase)
        println("testCase===" + testCase)
        Result result = new Result()
        if (insert == 1) {
            result.success = true
            result.result = testCase
        } else {
            result.success = false
            result.result = testCase
        }
        def jsonOutput = new JsonOutput()
        println("saveTestCase result===" + jsonOutput.toJson(result))
        result
    }

    @GetMapping("/listTestCase")
    def listTestCase(Model model) {
        model.addAttribute("testCaseList", testCaseMapper.findAll())
        "/test_case/list"
    }

    @ApiOperation(value = "list all TestCase Json", notes = "listTestCaseJson", produces = "application/json")
    @GetMapping("/listTestCaseJson")
    @ResponseBody
    def listTestCaseJson() {
        testCaseMapper.findAll()
    }

    @ApiOperation(value = "findOne TestCase Json", notes = "findOne TestCase", produces = "application/json")
    @ApiImplicitParam(name = "id",
            value = "测试任务ID",
            dataType = "Integer",//This can be the class name or a primitive
            required = true,
            paramType = "query")//Valid values are {@code path}, {@code query}, {@code body}, {@code header} or {@code form}
    @GetMapping("/findOne")
    @ResponseBody
    def findOne(@RequestParam(value = "id", required = true) Integer id) {
        testCaseMapper.findOne(id)
    }


}

```


@API表示这个类提供一个开放的API，可以通过description简要描述该API的功能。
在一个@API下，可有多个@ApiOperation，表示针对该API的CRUD操作。

在ApiOperation Annotation中可以通过value，notes描述该操作的作用，response描述正常情况下该请求的返回对象类型。 在一个ApiOperation下，可以通过ApiResponses描述该API操作可能出现的异常情况。

ApiParam用于描述该API操作接受的参数类型

我们也可以为项目的Model对象添加Swagger Annotation，这样Swagger Scanner可以获取更多关于Model对象的信息。但是，这样感觉侵入的代码有点多。酌情考虑。




5.启动@EnableSwagger2

在Application.groovy 微服务程序入口类上添加注解@EnableSwagger2：

```
package com.easy.springboot.h5perf

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by jack on 2017/4/22.
 */
@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
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

```

@EnableSwagger2这个注解用来启动Swagger的文档配置功能，我们通过源码可以看到，它Import了配置类Swagger2DocumentationConfiguration。

而Swagger2DocumentationConfiguration类又@Import了SpringfoxWebMvcConfiguration，SwaggerCommonConfiguration配置类。到最后，SpringfoxWebMvcConfiguration类Import了配置类ModelsConfiguration。

Swagger具体的实现原理，可以参考[1]~[6]。

6.运行测试

文档展示

![](http://upload-images.jianshu.io/upload_images/1233356-ac43f67eeb1a9091.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

实时测试


![](http://upload-images.jianshu.io/upload_images/1233356-727a1abb7b415cc7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


小结
===

Swagger可以充当前后端协同工作，自由联调的重要桥梁。方便快捷。很实用。

使用Swagger，我们可以自由生产，显示和消费自己的RESTful服务。不需要代理和第三方服务。同时，集成swagger-ui，通过Swagger API动态的生成漂亮的文档和API测试空间。



参考资料：
1.http://springfox.github.io/springfox/docs/current/#springfox-configuration-and-demo-applications
2.http://swagger.io/
3.https://github.com/martypitt/swagger-springmvc
4.https://github.com/swagger-api/swagger-ui
5.https://github.com/swagger-api/swagger-core
6.https://github.com/swagger-api/swagger-spec



# h5perf
SpringBoot集成Swagger2，Mybatis，Druid，Groovy，Freemarker ，WebJars 实例工程
