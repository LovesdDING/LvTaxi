package com.cz10000.lvtaxi.common.http.impl;

import com.cz10000.lvtaxi.common.http.IResponse;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public class BaseResponse implements IResponse{

    public static final int STATE_UNKNOWN_ERROR = 100001;
    public static final int STATE_OK = 200;

    // 状态码
    private int code;
    // 响应数据
    private String data;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getData() {
        return data;
    }


    public void setData(String data){
        this.data = data ;
    }

    public void setCode(int code){
        this.code = code ;
    }
}
