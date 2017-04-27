package com.easy.springboot.h5perf.model

/**
 * Created by jack on 2017/4/25.
 */
class RequestResource {
    Integer id;
    String tid;
    String testUrl;
    Integer index;// 请求先后的序号
//    Integer countInterceptRequest;
    Long startTimestamp;// 测试开始时间戳
    Long timestamp;// 请求的时间戳
    Integer timeCost; // 当前请求时间戳 - 测试开始时间戳
    String requestUrl;// 请求URL

    String contentEncoding
    String contentType
    String contentLength

    String method;//GET,POST
//    Map<String, String> headers;
    String headers; // json string

    @Override
    public String toString() {
        return "RequestResource{" +
                "id=" + id +
                ", tid='" + tid + '\'' +
                ", testUrl='" + testUrl + '\'' +
                ", index=" + index +
                ", startTimestamp=" + startTimestamp +
                ", timestamp=" + timestamp +
                ", timeCost=" + timeCost +
                ", requestUrl='" + requestUrl + '\'' +
                ", contentEncoding='" + contentEncoding + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contentLength='" + contentLength + '\'' +
                ", method='" + method + '\'' +
                ", headers='" + headers + '\'' +
                '}';
    }
}
