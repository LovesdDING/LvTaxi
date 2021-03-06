package com.cz10000.lvtaxi.account.presenter;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public interface ICreatePasswordDialogPresenter  {
    /**
     * 校验密码输入合法性
     */
    boolean checkPw(String pw, String pw1);
    /**
     *  提交注册
     */
    void requestRegister(String phone, String pw);

    /**
     * 登录
     */
    void requestLogin(String phone, String pw);
}
