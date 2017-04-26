package com.easy.springboot.h5perf.service

import com.easy.springboot.h5perf.mapper.RequestResourceMapper
import com.easy.springboot.h5perf.model.RequestResource
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by jack on 2017/4/26.
 */
@Service
class RequestResourceServiceImpl implements RequestResourceService {
    @Autowired
    RequestResourceMapper requestResourceMapper

    @Override
    PageInfo<RequestResource> listTestResult(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo
        pageSize = pageSize == null ? 10 : pageSize
        PageHelper.startPage(pageNo, pageSize)
        List<RequestResource> all = requestResourceMapper.listTestResult()
        new PageInfo<RequestResource>(all)
    }
}
