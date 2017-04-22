package com.easy.springboot.h5perf.model

/**
 * Created by jack on 2017/4/22.
 */
class TestResource {
    Integer id
    Long startTime
    String resourceUrl
    String resourceType
    Long resourceTime
    Integer resourceSize
    Date gmtCreated


    @Override
    public String toString() {
        return "TestResource{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceTime=" + resourceTime +
                ", resourceSize=" + resourceSize +
                ", gmtCreated=" + gmtCreated +
                '}';
    }
}
