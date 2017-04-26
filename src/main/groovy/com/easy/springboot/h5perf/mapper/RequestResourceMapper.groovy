package com.easy.springboot.h5perf.mapper

import com.easy.springboot.h5perf.model.RequestResource
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param

/**
 * Created by jack on 2017/4/25.
 */
@Mapper
interface RequestResourceMapper {

//    @Insert([
//            "insert into request_resource",
//            "set tid = #{r.tid},",
//            "test_url = #{r.testUrl},",
//            "index = #{r.index},",
//            "start_timestamp = #{r.startTimestamp},",
//            "timestamp = #{r.timestamp},",
//            "time_cost = #{r.timeCost},",
//            "request_url = #{r.requestUrl},",
//            "method = #{r.method},",
//            "headers = #{r.headers}"
//    ])
    @Insert(["insert into request_resource(`tid`, `test_url`, `index`, `start_timestamp`, `timestamp`, `time_cost`, `request_url`, `method`, `headers`)",
            "values ( #{r.tid}, #{r.testUrl}, #{r.index}, #{r.startTimestamp}, #{r.timestamp}, #{r.timeCost}, #{r.requestUrl}, #{r.method}, #{r.headers})"])
    @Options(useGeneratedKeys = true, keyProperty = "r.id")
    int insert(@Param("r") RequestResource requestResource)

    //INSERT INTO `h5perf`.`request_resource` (`tid`, `test_url`, `index`, `start_timestamp`, `timestamp`, `time_cost`, `request_url`, `method`, `headers`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1');

}
