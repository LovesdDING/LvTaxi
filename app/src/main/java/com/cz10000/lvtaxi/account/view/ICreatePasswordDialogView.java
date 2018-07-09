package com.cz10000.lvtaxi.account.view;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public interface ICreatePasswordDialogView extends IView {

    void  showRegisterSuc() ; //显示注册成功
    void showLoginSuc() ;  //显示登录成功
    void showPasswordnull() ; //显示密码为空
    void  showPasswordNotEqual() ; //显示两次输入密码不一致
}
