package com.easy.springboot.h5perf.controller

import com.easy.springboot.h5perf.service.RunTestCaseService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by jack on 2017/4/22.
 * http://springfox.github.io/springfox/docs/current/#springfox-samples
 */

//在Controller上使用@Api会生成这个Controller的整体描述
@Api(value = "执行测试用例", tags = ["执行测试用例API"], description = "RunTestCaseController")
@Controller
class RunTestCaseController {
    @Autowired
    RunTestCaseService runTestCaseService

    /**
     * 测试H5 url执行引擎
     * @param url
     * @return
     */
    @PostMapping("/runTestCase")
    @ResponseBody
    def runTestCase(@RequestParam(value = "url") String url) {
        runTestCaseService.run(url)
    }

    @GetMapping("/runResult")
    @ResponseBody
    def runResult(@RequestParam(value="tid") String tid){


    }

}
