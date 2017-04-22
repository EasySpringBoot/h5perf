package com.easy.springboot.h5perf.mapper

import com.easy.springboot.h5perf.model.TestCase
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface TestCaseMapper {

    @Insert([
            "insert into test_case",
            "set container_type = #{t.containerType},",
            "test_url = #{t.testUrl},",
            "net_type = #{t.netType},",
            "gmt_created = #{t.gmtCreated},",
            "gmt_modified = #{t.gmtModified}"
    ])
    @Options(useGeneratedKeys = true, keyProperty = "t.id")
    int insert(@Param("t") TestCase testCase)

    @Select("select * from test_case")
    List<TestCase> findAll()

    @Select("select * from test_case where net_type=#{netType}")
    List<TestCase> findByNetType(@Param(value="netType")String netType)

    @Select("select * from test_case where id=#{id} limit 1")
    TestCase findOne(@Param(value="id")Integer id)

    int insertSelective(TestCase record)
}
