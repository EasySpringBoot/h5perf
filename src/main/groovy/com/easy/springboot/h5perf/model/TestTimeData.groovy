package com.easy.springboot.h5perf.model

/**
 * Created by jack on 2017/4/22.
 */
class TestTimeData {
    Integer id
    Integer testCaseId
    String onRecieveTitle
    String onPageFinished
    String domContentLoad
    String load
    Date gmtCreated


    @Override
    public String toString() {
        return "TestTimeData{" +
                "id=" + id +
                ", testCaseId=" + testCaseId +
                ", onRecieveTitle='" + onRecieveTitle + '\'' +
                ", onPageFinished='" + onPageFinished + '\'' +
                ", domContentLoad='" + domContentLoad + '\'' +
                ", load='" + load + '\'' +
                ", gmtCreated=" + gmtCreated +
                '}';
    }
}
