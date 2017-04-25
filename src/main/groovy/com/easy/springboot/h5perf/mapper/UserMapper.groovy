package com.easy.springboot.h5perf.mapper

import com.easy.springboot.h5perf.model.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * Created by jack on 2017/4/24.
 */
@Mapper
interface UserMapper {

    @Select("select * from user where email = #{email}")
    User findUserByEmail(@Param(value = "email") String email)

}
