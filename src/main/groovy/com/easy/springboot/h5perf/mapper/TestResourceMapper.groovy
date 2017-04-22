package com.easy.springboot.h5perf.mapper

import com.easy.springboot.h5perf.model.TestResource
import org.apache.ibatis.annotations.Mapper

@Mapper
public interface TestResourceMapper {
    int insert(TestResource record);

    int insertSelective(TestResource record);
}
