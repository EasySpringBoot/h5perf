package com.easy.springboot.h5perf.mapper

import com.easy.springboot.h5perf.model.RequestResource
import org.apache.ibatis.annotations.*

/**
 * Created by jack on 2017/4/25.
 */
@Mapper
interface RequestResourceMapper {
    @Insert(["insert into request_resource(`tid`, `test_url`, `index`, `start_timestamp`, `timestamp`, `time_cost`, `request_url`, `method`, `headers`,`content_encoding`,`content_type`,`content_length`)",
            "values ( #{r.tid}, #{r.testUrl}, #{r.index}, #{r.startTimestamp}, #{r.timestamp}, #{r.timeCost}, #{r.requestUrl}, #{r.method}, #{r.headers} , #{r.contentEncoding} ,#{r.contentType}, #{r.contentLength})"])
    @Options(useGeneratedKeys = true, keyProperty = "r.id")
    int insert(@Param("r") RequestResource requestResource)

    @Select("select * from request_resource where tid = #{tid}")
    List<RequestResource> findByTid(@Param(value = "tid") String tid)


    @Select("SELECT * FROM request_resource group by tid order by id desc")
    List<RequestResource> listTestResult()


}
