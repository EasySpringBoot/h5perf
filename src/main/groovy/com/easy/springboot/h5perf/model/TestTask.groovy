package com.easy.springboot.h5perf.model

/**
 * Created by jack on 2017/4/27.
 */
class TestTask {
    Integer id
    String tid
    String status
    Date gmtCreated
    Date gmtModified


    @Override
    public String toString() {
        return "TestTask{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", status='" + status + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
