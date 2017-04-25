package com.easy.springboot.h5perf.login

import com.easy.springboot.h5perf.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by jack on 2017/4/25.
 *
 *
 * 实现UserDetailsService 接口，重写loadUserByUsername方法，从数据库中取出用户信息。最后返回一个UserDetails 实现类。
 *
 */
@Service
class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao

    /**
     * 用户名，密码从数据库中取
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def user = userDao.findUserByEmail(username)

        if (user == null) {
            throw new UsernameNotFoundException("username:" + username + " not found!")
        }

        List<GrantedAuthority> authorities = new ArrayList<>()
        authorities.add(new SimpleGrantedAuthority(user.role)) // 用简单的1个role来示例
        new User(user.email, user.password, authorities)
    }

}
