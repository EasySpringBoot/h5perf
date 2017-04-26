//package com.easy.springboot.h5perf.login
//
//import com.easy.springboot.h5perf.dao.UserDao
//import com.easy.springboot.h5perf.model.User
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.security.core.Authentication
//import org.springframework.security.core.AuthenticationException
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.stereotype.Component
//
///**
// * Created by jack on 2017/4/25.
// */
//@Component
//class CustomAuthenticationProvider implements AuthenticationProvider {
//    @Autowired
//    UserDao userDao
//
//    @Override
//    Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String loginName = authentication.getName();
//        String password = authentication.getCredentials().toString()
//        List<GrantedAuthority> grantedAuths = new ArrayList<>()
//        if (vaildateUser(loginName, password, grantedAuths)) {
//            Authentication auth = new UsernamePasswordAuthenticationToken(loginName, password, grantedAuths)
//            auth
//        } else {
//            null
//        }
//    }
//
//    @Override
//    boolean supports(Class<?> authentication) {
//        authentication == (UsernamePasswordAuthenticationToken.class)
//    }
//
//
//    boolean vaildateUser(String loginName, String password, List<GrantedAuthority> grantedAuths) {
//        User user = userDao.findUserByEmail(loginName)
//
//        if (user == null || loginName == null || password == null) {
//            return false;
//        }
//        if (user.password == password) {
//            String rolestr = user.role
//            if (rolestr.isEmpty()) {
//                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//            }
//            for (String role : rolestr.split(",")) {
//                if (role != null && "" != (role)) {
//                    grantedAuths.add(new SimpleGrantedAuthority(role))
//                }
//            }
//            return true
//        }
//        return false
//    }
//
//
//}
