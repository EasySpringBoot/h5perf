package com.easy.springboot.h5perf.controller

import com.easy.springboot.h5perf.mapper.TestTimeDataMapper
import com.easy.springboot.h5perf.model.TestTimeData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by jack on 2017/4/25.
 *
 * 提供给client端写入性能数据接口api
 */
@Controller
class TestTimeDataController {
    @Autowired
    TestTimeDataMapper testTimeDataMapper


    @PostMapping("/postTestTimeData")
    @ResponseBody
    def postRequestResource(
            @RequestParam(value = "tid") String tid,
            @RequestParam(value = "onReceivedTitle") String onReceivedTitle,
            @RequestParam(value = "domTotal") String domTotal,
            @RequestParam(value = "domContentLoad") String domContentLoad,
            @RequestParam(value = "load") String load
    ) {

        def testTimeData = new TestTimeData()
        testTimeData.tid = tid
        testTimeData.onReceivedTitle = onReceivedTitle
        testTimeData.domTotal = domTotal
        testTimeData.domContentLoad = domContentLoad
        testTimeData.load = load
        testTimeData.gmtCreated = new Date()
        testTimeDataMapper.insert(testTimeData)
    }

    @GetMapping("/findTestTimeData")
    @ResponseBody
    def findTestTimeData(@RequestParam(value = "tid") String tid) {
        testTimeDataMapper.findByTid(tid)
    }

}
