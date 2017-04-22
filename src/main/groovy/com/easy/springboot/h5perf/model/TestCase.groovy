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

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    String getContainerType() {
        return containerType
    }

    void setContainerType(String containerType) {
        this.containerType = containerType
    }

    String getTestUrl() {
        return testUrl
    }

    void setTestUrl(String testUrl) {
        this.testUrl = testUrl
    }

    String getNetType() {
        return netType
    }

    void setNetType(String netType) {
        this.netType = netType
    }

    Date getGmtCreated() {
        return gmtCreated
    }

    void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated
    }

    Date getGmtModified() {
        return gmtModified
    }

    void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified
    }

    @Override
    public String toString() {
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
