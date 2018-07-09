package com.cz10000.lvtaxi.common.http;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public interface IHttpClient {
    IResponse get(IRequest request, boolean forceCache);
    IResponse post(IRequest request, boolean forceCache);
}
