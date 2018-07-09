package com.cz10000.lvtaxi.common.http;

/**
 *  封装的数据请求返回值
 * Created by cz10000_001 on 2018/7/9.
 */

public interface IResponse {

    // 状态码
    int getCode();
    // 数据体
    String getData();

}
