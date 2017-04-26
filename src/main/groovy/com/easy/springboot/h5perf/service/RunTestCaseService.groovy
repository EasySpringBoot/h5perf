package com.easy.springboot.h5perf.service

/**
 * Created by jack on 2017/4/26.
 */
interface RunTestCaseService {
    def run(String testUrl, Long tid)
    def run(String testUrl)
}
