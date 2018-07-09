package com.cz10000.lvtaxi.account.model;

/**
 * 账号相关的业务逻辑 抽象
 * Created by cz10000_001 on 2018/7/9.
 */

public interface IAccountManager {
    // 服务器错误
    static final int SERVER_FAIL = -999;
    // 验证码发送成功
    static final int SMS_SEND_SUC = 1;
    // 验证码发送失败
    static final int SMS_SEND_FAIL = -1;
    // 验证码校验成功
    static final int SMS_CHECK_SUC = 2;
    // 验证码错误
    static final int SMS_CHECK_FAIL = -2;
    // 用户已经存在
    static final int USER_EXIST = 3;
    // 用户不存在
    static final int USER_NOT_EXIST = -3;
    // 注册成功
    static final int REGISTER_SUC = 4;
    // 登录成功
    static final int LOGIN_SUC = 5;
    // 密码错误
    static final int PW_ERROR = -5;
    // 登录失效
    static final int TOKEN_INVALID = -6;


    /**
     * 下发验证码
     */
    void  fetchSmsCode (String phone) ;

    /**
     * 校验验证码
     * @param phone
     * @param smsCode
     */
    void checkSmsCode(String phone,String smsCode) ;
    /**
     * 检查用户是否注册
     * @param phone
     */
    void checkUserExist(String phone) ;
    /**
     * 注册
     * @param phone
     */
    void register(String phone,String password) ;
    /**
     * 登录
     * @param phone
     * @param password
     */
    void login(String phone,String password) ;

    /**
     * token 登录
     */
    void loginByToken() ;
    /**
     * 是否登录
     * @return
     */
    boolean isLogin() ;
}
