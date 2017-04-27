package com.easy.springboot.h5perf.service

import com.easy.springboot.h5perf.mapper.TestTaskMapper
import com.easy.springboot.h5perf.model.TestTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by jack on 2017/4/26.
 */
@Service
class RunTestCaseServiceImpl implements RunTestCaseService {

    @Autowired
    TestTaskMapper testTaskMapper

    @Override
    def run(String testUrl) {
        Long tid = System.currentTimeMillis()

        def testTask = new TestTask()
        testTask.tid = tid
        testTask.status = 0
        testTaskMapper.insert(testTask)

        run(testUrl, tid)
    }

    @Override
    def run(String testUrl, Long tid) {

        /**
         * PC端服务程序，调用如下命令，触发手机上的Webview壳执行：
         * adb shell am start --es url "https://jason-chen-2017.github.io/Jason-Chen-2017/" --el tid 1 com.example.jack.myapplication2/com.example.jack.myapplication2.H5TestActivity
         */

        def command = "adb shell am start --es url " + testUrl +
                " --el tid " + tid + " com.example.jack.myapplication2/com.example.jack.myapplication2.H5TestActivity"

        def proc = command.execute()
        proc.waitFor()
        println "return code: ${proc.exitValue()}"
        println "stdout: ${proc.in.text}"

        Map map = new HashMap()
        map.put("exitValue", proc.exitValue())
        map.put("tid", tid)

        map
    }
}
