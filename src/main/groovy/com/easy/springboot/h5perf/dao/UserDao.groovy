package com.easy.springboot.h5perf.dao

import com.easy.springboot.h5perf.mapper.UserMapper
import com.easy.springboot.h5perf.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by jack on 2017/4/24.
 */
@Repository
class UserDao implements UserMapper {
    @Autowired
    UserMapper userMapper

    User findUserByWorkno(String workno) {
        userMapper.findUserByWorkno(workno)
    }

    @Override
    User findUserByEmail(String email) {
        userMapper.findUserByEmail(email)
    }
}
