package com.easy.springboot.h5perf.controller

import com.easy.springboot.h5perf.mapper.RequestResourceMapper
import com.easy.springboot.h5perf.mapper.TestTimeDataMapper
import com.easy.springboot.h5perf.service.RequestResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by jack on 2017/4/26.
 */

@Controller
class TestResultController {
    @Autowired
    RequestResourceService requestResourceService
    @Autowired
    TestTimeDataMapper testTimeDataMapper
    @Autowired
    RequestResourceMapper requestResourceMapper

    @GetMapping("/detailTestResultApi")
    @ResponseBody
    def detailTestResultApi(@RequestParam(value = "tid") String tid) {
        Map map = new HashMap()
        map.put("testTimeData", testTimeDataMapper.findByTid(tid))
        map.put("requestResource", requestResourceMapper.findByTid(tid))
        map
    }

    @GetMapping("/detailTestResult")
    def detailTestResult(@RequestParam(value = "tid") String tid, Model model) {
        Map map = new HashMap()
        map.put("testTimeData", testTimeDataMapper.findByTid(tid))
        map.put("requestResource", requestResourceMapper.findByTid(tid))
        model.addAllAttributes(map)
        "/test_result/detail"
    }


    @GetMapping("/listTestResult")
    def listTestResult(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo,
                       @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        def pageInfo = requestResourceService.listTestResult(pageNo, pageSize)
        model.addAttribute("listTestResult", pageInfo.list)

        model.addAttribute("pageNo", pageInfo.pageNum)
        model.addAttribute("totalPage", pageInfo.pages)
        model.addAttribute("prePage", pageInfo.prePage)
        model.addAttribute("nextPage", pageInfo.nextPage)
        model.addAttribute("hasPreviousPage", pageInfo.hasPreviousPage)
        model.addAttribute("hasNextPage", pageInfo.hasNextPage)

        "/test_result/list"
    }
}
