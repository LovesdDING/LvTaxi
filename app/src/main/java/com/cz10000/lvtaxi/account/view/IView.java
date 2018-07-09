package com.cz10000.lvtaxi.account.view;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public interface IView {
    //显示加载中
    void showLoading() ;
    //显示错误
    void showError(int code,String msg) ;
}
