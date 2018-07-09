package com.cz10000.lvtaxi.common.http.impl;

import com.cz10000.lvtaxi.common.http.IHttpClient;
import com.cz10000.lvtaxi.common.http.IRequest;
import com.cz10000.lvtaxi.common.http.IResponse;

import java.io.IOException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * okhttp  的实现
 *
 * Created by cz10000_001 on 2018/7/9.
 */

public class OkHttpClientImpl implements IHttpClient {

    OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build() ;

    @Override
    public IResponse get(IRequest request, boolean forceCache) {
        /**
         * 解析参数
         */

        //指定请求方式
        request.setMethod(IRequest.GET);
        //解析头部
        Map<String,String> header = request.getHeader() ;
        // OKhttp的Request.Builder
        Request.Builder builder = new Request.Builder() ;
        // 组装成 okhttp的header
        for (String key :
                header.keySet()) {
            builder.header(key,header.get(key)) ;
        }

        //获取Url
        String url = request.getUrl() ;

        builder.url(url).get() ;
        Request oKRequest = builder.build() ;

        return execute(oKRequest);
    }


    /**
     * 请求 执行过程
     * @param oKRequest
     * @return
     */
    private IResponse execute(Request oKRequest) {
        BaseResponse commonResponse = new BaseResponse() ;
        try {
            Response response = mOkHttpClient.newCall(oKRequest).execute() ;
            //设置状态码
            commonResponse.setCode(response.code());
            String body = response.body().string() ;
            //设置响应数据
            commonResponse.setData(body);


        } catch (IOException e) {
            e.printStackTrace();
            commonResponse.setCode(commonResponse.STATE_UNKNOWN_ERROR);
            commonResponse.setData(e.getMessage());
        }
        return commonResponse;
    }

    @Override
    public IResponse post(IRequest request, boolean forceCache) {
        request.setMethod(IRequest.POST);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8") ;
        RequestBody body = RequestBody.create(mediaType,request.getBody().toString()) ;
        Map<String,String> header = request.getHeader() ;
        Request.Builder builder = new Request.Builder() ;
        for (String key :
               header.keySet() ) {
                builder.header(key,header.get(key)) ;
        }

        builder.url(request.getUrl())
                .post(body) ;

        Request okRequest = builder.build() ;

        return execute(okRequest);
    }
}
