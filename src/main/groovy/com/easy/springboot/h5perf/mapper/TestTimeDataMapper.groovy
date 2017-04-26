package com.easy.springboot.h5perf.mapper

import com.easy.springboot.h5perf.model.TestTimeData
import org.apache.ibatis.annotations.*

@Mapper
interface TestTimeDataMapper {


    @Insert(["INSERT INTO `h5perf`.`test_time_data` ( `tid`,`on_received_title`, `dom_total`, `dom_content_load`, `load`, `gmt_created`) ",
            "VALUES (#{t.tid}, #{t.onReceivedTitle}, #{t.domTotal}, #{t.domContentLoad}, #{t.load}, #{t.gmtCreated})"])
    @Options(useGeneratedKeys = true, keyProperty = "t.id")
    int insert(@Param("t") TestTimeData testTimeData)


    @Select("select * from test_time_data where tid=#{tid} limit 1")
    TestTimeData findByTid(@Param("tid") String tid)

    int insertSelective(TestTimeData testTimeData)
}
