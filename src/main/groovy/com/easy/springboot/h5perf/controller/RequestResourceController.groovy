package com.easy.springboot.h5perf.controller

import com.easy.springboot.h5perf.mapper.RequestResourceMapper
import com.easy.springboot.h5perf.model.RequestResource
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
class RequestResourceController {
    @Autowired
    RequestResourceMapper requestResourceMapper

    @PostMapping("/postRequestResource")
    @ResponseBody
    def postRequestResource(
            @RequestParam(value = "tid") String tid,
            @RequestParam(value = "index") Integer index,
            @RequestParam(value = "testUrl") String testUrl,
            @RequestParam(value = "startTime") Long startTime,
            @RequestParam(value = "timestamp") Long timestamp,
            @RequestParam(value = "timeCost") Integer timeCost,
            @RequestParam(value = "requestUrl") String requestUrl,
            @RequestParam(value = "method") String method,
            @RequestParam(value = "headers") String headers
    ) {
        def requestResource = new RequestResource()
        requestResource.tid = tid
        requestResource.index = index
        requestResource.testUrl = testUrl
        requestResource.startTimestamp = startTime
        requestResource.timestamp = timestamp
        requestResource.timeCost = timeCost
        requestResource.requestUrl = requestUrl
        requestResource.method = method
        requestResource.headers = headers

        requestResourceMapper.insert(requestResource)
    }

    @GetMapping("/findRequestResource")
    @ResponseBody
    def findRequestResource(@RequestParam(value = "tid") String tid) {
        requestResourceMapper.findByTid(tid)
    }

}
