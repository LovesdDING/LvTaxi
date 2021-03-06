package com.cz10000.lvtaxi.common.http.impl;

import com.cz10000.lvtaxi.common.http.IRequest;
import com.cz10000.lvtaxi.common.http.api.API;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装参数的 实现
 * Created by cz10000_001 on 2018/7/9.
 */

public class BaseRequest implements IRequest{

    private String method = POST ;
    private String url ;
    private Map<String,String> header ;
    private Map<String,Object> body ;


    public BaseRequest(String url){
        /**
         * 公共参数 及 头部信息
         */
        this.url = url ;
        header = new HashMap<>() ;
        body = new HashMap<>() ;
        header.put("X-Bmob-Application-Id", API.Config.getAppId()) ;
        header.put("X-Bmob-REST-API-Key", API.Config.getAppKey());
    }

    @Override
    public void setMethod(String method) {
        this.method = method ;
    }

    @Override
    public void setHeader(String key, String value) {
        header.put(key,value) ;
    }

    @Override
    public void setBody(String key, String value) {
            body.put(key,value) ;
    }

    @Override
    public String getUrl() {
        if(GET.equals(method)){
            //组装get 参数
            for (String key : body.keySet()) {
                url = url.replace("${"+ key +"}",body.get(key).toString()) ;
            }

        }
        return url;
    }

    @Override
    public Map<String, String> getHeader() {
        return header;
    }

    @Override
    public Object getBody() {
        if(body!=null){
            return new Gson().toJson(this.body,HashMap.class) ;
        }else{
            return "{ }" ;
        }
    }
}
