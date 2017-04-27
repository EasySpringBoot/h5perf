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

    @Override
    int insert(RequestResource requestResource) {
        String url = requestResource.requestUrl

        URL urlObj = new URL(url)
        try {
            URLConnection uc = urlObj.openConnection()
            println(url)
            def contentEncoding = uc.getContentEncoding()
            def contentType = uc.getContentType()
            def contentLength = uc.getContentLength()

            println("contentLength:" + contentEncoding)
            println("contentType:" + contentType)
            println("contentLength:" + contentLength)

            requestResource.contentLength = contentLength == null ? 0 : contentLength + ""
            requestResource.contentEncoding = contentEncoding
            requestResource.contentType = contentType

        } catch (ex) {
            println("资源异常： " + url)
            ex.printStackTrace()
        }

        requestResourceMapper.insert(requestResource)

    }


}
