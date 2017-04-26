package com.easy.springboot.h5perf.service

import com.easy.springboot.h5perf.mapper.TestCaseMapper
import com.easy.springboot.h5perf.model.TestCase
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by jack on 2017/4/23.
 */
@Service
class TestCaseServiceImpl implements TestCaseService {
    @Autowired
    TestCaseMapper testCaseMapper;

    @Override
    def save(TestCase testCase) {
        testCaseMapper.insert(testCase)
    }

    @Override
    PageInfo<TestCase> findAll(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo
        pageSize = pageSize == null ? 10 : pageSize
        PageHelper.startPage(pageNo, pageSize)
        List<TestCase> testCaseList = testCaseMapper.findAll()
        //用PageInfo对结果进行包装
        new PageInfo<TestCase>(testCaseList)
    }

    @Override
    TestCase findOne(Integer id) {
        testCaseMapper.findOne(id)
    }

    @Override
    PageInfo<TestCase> queryByPage(String netType, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo
        pageSize = pageSize == null ? 10 : pageSize
        PageHelper.startPage(pageNo, pageSize)

        List<TestCase> testCaseList = testCaseMapper.findByNetType(netType)
        //用PageInfo对结果进行包装
        PageInfo<TestCase> testCasePageInfo = new PageInfo<>(testCaseList)
        testCasePageInfo
    }
}
