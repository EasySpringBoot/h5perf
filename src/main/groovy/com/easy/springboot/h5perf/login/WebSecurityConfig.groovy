//package com.easy.springboot.h5perf.login
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.core.userdetails.UserDetailsService
//
///**
// * Created by jack on 2017/4/24.
// *
//
// 从数据库中查询出来用户数据交给Spring Security这里有两种主要的方式：
//
// AuthenticationProvider&&UserDetailsService
//
// Spring Security认证是由 AuthenticationManager 来管理的，但是真正进行认证的是 AuthenticationManager 中定义的 AuthenticationProvider。
// AuthenticationManager 中可以定义有多个 AuthenticationProvider。
//
// 当我们使用 authentication-provider 元素来定义一个 AuthenticationProvider 时，
// 如果没有指定对应关联的 AuthenticationProvider 对象，
// Spring Security 默认会使用 DaoAuthenticationProvider。
//
// DaoAuthenticationProvider 在进行认证的时候需要一个 UserDetailsService 来获取用户的信息 UserDetails，其中包括用户名、密码和所拥有的权限等。
//
// 所以如果我们需要改变认证的方式，我们可以实现自己的 AuthenticationProvider；
//
// 如果需要改变认证的用户信息来源，我们可以实现 UserDetailsService。
//
// */
//@Configuration
////@EnableWebSecurity(debug = true)
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    AuthenticationProvider customAuthenticationProvider
//    @Autowired
//    UserDetailsService customUserDetailsService
//
//    @Override
//    void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/static/**", "/public/**", "/webjars/**", "/webjarslocator/**", "/swagger-ui.html").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username").passwordParameter("password")
//                .defaultSuccessUrl("/index")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//    }
//
//    /**
//     * 如果我们需要改变认证的方式，我们可以实现自己的 AuthenticationProvider；
//     * 如果需要改变认证的用户信息来源，我们可以实现 UserDetailsService。
//     *
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    void configure(AuthenticationManagerBuilder auth) throws Exception {
////      //加载用户信息
////        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
////        auth.authenticationProvider(customAuthenticationProvider)
//
//        //使用内存用户名，密码数据鉴权
//        auth.inMemoryAuthentication()
//                .withUser("root")
//                .password("123456").roles("ADMIN")
//
////        auth.inMemoryAuthentication()
////        .withUser("jack")
////        .password("123456").roles("USER")
//
//    }
//
//    /**
//     * 设置用户密码的加密方式为MD5加密
//     * @return
//     */
////    @Bean
////    Md5PasswordEncoder passwordEncoder() {
////        new Md5PasswordEncoder()
////    }
//
//}
//
//
//
