package com.easy.springboot.h5perf.service

import com.easy.springboot.h5perf.model.TestCase
import com.github.pagehelper.PageInfo

/**
 * Created by jack on 2017/4/23.
 */
interface TestCaseService {
    def save(TestCase testCase)

    PageInfo<TestCase> findAll(Integer pageNo, Integer pageSize)

    TestCase findOne(Integer id)

    PageInfo<TestCase> queryByPage(String netType, Integer pageNo, Integer pageSize)

}
