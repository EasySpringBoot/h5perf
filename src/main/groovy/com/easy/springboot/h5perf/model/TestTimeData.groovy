package com.easy.springboot.h5perf.model

/**
 * Created by jack on 2017/4/22.
 */
class TestTimeData {
    Integer id
    String tid
    String onReceivedTitle
    String domTotal
    String domContentLoad
    String load
    Date gmtCreated


    @Override
    public String toString() {
        return "TestTimeData{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", onReceivedTitle='" + onReceivedTitle + '\'' +
                ", domTotal='" + domTotal + '\'' +
                ", domContentLoad='" + domContentLoad + '\'' +
                ", load='" + load + '\'' +
                ", gmtCreated=" + gmtCreated +
                '}';
    }
}
