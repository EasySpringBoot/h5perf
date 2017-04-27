package com.easy.springboot.h5perf.controller

import com.easy.springboot.h5perf.mapper.TestTaskMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by jack on 2017/4/27.
 */
@Controller
class TestTaskController {
    @Autowired
    TestTaskMapper testTaskMapper

    @PostMapping("/updateTestTask")
    @ResponseBody
    def updateTestTask(
            @RequestParam(value = "status") String status,
            @RequestParam(value = "tid") String tid) {
        testTaskMapper.updateStatusByTid(status, tid)
    }

    @GetMapping("/getTestTaskStatus")
    @ResponseBody
    def getTestTaskStatus(@RequestParam(value = "tid") String tid) {
        testTaskMapper.getStatusByTid(tid)
    }

}
