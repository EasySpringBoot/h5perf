package com.easy.springboot.h5perf.service

import com.easy.springboot.h5perf.model.RequestResource
import com.github.pagehelper.PageInfo
import org.apache.ibatis.annotations.Param

/**
 * Created by jack on 2017/4/26.
 */
interface RequestResourceService {
    PageInfo<RequestResource> listTestResult(Integer pageNo, Integer pageSize)

    int insert(RequestResource requestResource)


}
