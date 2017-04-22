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

/**
 * Created by jack on 2017/4/22.
 * http://springfox.github.io/springfox/docs/current/#springfox-samples
 */

//在Controller上使用@Api会生成这个Controller的整体描述
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

//    在具体方法上使用@ApiOperation可以生成接口的描述
    @ApiOperation(value = "list all TestCase Json", notes = "listTestCaseJson", produces = "application/json")
    @GetMapping("/listTestCaseJson")
    @ResponseBody
    def listTestCaseJson() {
        testCaseMapper.findAll()
    }

    @ApiOperation(value = "findOne TestCase Json", notes = "findOne TestCase", produces = "application/json")
//  在方法上使用@ApiImplicitParam可以增加对参数等的描述
    @ApiImplicitParam(name = "id",
            value = "测试任务ID",
            dataType = "Integer",//This can be the class name or a primitive
            required = true,
            paramType = "query")
//Valid values are {@code path}, {@code query}, {@code body}, {@code header} or {@code form}
    @GetMapping("/findOne")
    @ResponseBody
    def findOne(@RequestParam(value = "id", required = true) Integer id) {
        testCaseMapper.findOne(id)
    }


}
