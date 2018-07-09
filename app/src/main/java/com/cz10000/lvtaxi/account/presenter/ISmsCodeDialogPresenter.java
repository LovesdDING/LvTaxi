package com.cz10000.lvtaxi.account.presenter;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public interface ISmsCodeDialogPresenter {

    /**
     *  请求下发验证码
     */
    void requestSendSmsCode(String phone);
    /**
     * 请求校验验证码
     */
    void requestCheckSmsCode(String phone, String smsCode);
    /**
     * 用户是否存在
     */
    void requestCheckUserExist(String phone);

}
