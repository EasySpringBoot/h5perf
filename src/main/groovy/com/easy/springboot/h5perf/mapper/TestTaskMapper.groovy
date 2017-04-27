package com.easy.springboot.h5perf.mapper

import com.easy.springboot.h5perf.model.TestTask
import org.apache.ibatis.annotations.*

/**
 * Created by jack on 2017/4/27.
 */
@Mapper
interface TestTaskMapper {

    @Insert("INSERT INTO `h5perf`.`test_task` (`tid`, `status`, `gmt_created`, `gmt_modified`) VALUES (#{t.tid}, #{t.status}, now(), now());")
    int insert(@Param(value = "t") TestTask testTask)

    @Update("UPDATE `h5perf`.`test_task` SET `status`=#{s}, `gmt_modified`=now() WHERE `tid`=#{tid}")
    int updateStatusByTid(@Param(value = "s") String status, @Param(value = "tid") String tid)

    @Select("select  `status` from `h5perf`.`test_task`  WHERE `tid`=#{tid}")
    String getStatusByTid(@Param(value = "tid") String tid)

}
