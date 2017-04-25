package com.easy.springboot.h5perf.model

/**
 * Created by jack on 2017/4/24.
 */
class User {
    Integer id
    String workno
    String name
    String email
    String password
    String role //ROLE_ADMIN,ROLE_USER 权限类型

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", workno='" + workno + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
