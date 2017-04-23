package com.easy.springboot.h5perf.model

/**
 * Created by jack on 2017/4/22.
 */
class TestCase {
    Integer id
    String containerType
    String testUrl
    String netType
    Date gmtCreated
    Date gmtModified

    @Override
    String toString() {
        return "TestCase{" +
                "id=" + id +
                ", containerType='" + containerType + '\'' +
                ", testUrl='" + testUrl + '\'' +
                ", netType='" + netType + '\'' +
                ", gmtCreated=" + gmtCreated +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
