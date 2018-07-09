package com.cz10000.lvtaxi.account.model;

import android.os.Handler;

import com.cz10000.lvtaxi.account.model.response.Account;
import com.cz10000.lvtaxi.common.http.IHttpClient;
import com.cz10000.lvtaxi.common.storage.SharePreferencesDao;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public class AccoutManagerImpl implements IAccountManager {

    private IHttpClient httpClient ;  //网络请求库

    private static final String TAG = "AccoutManagerImpl"  ;
    //数据存储
    private SharePreferencesDao sharePreferencesDao ;

    private Handler mHandler ;  //发送消息handelr



    public AccoutManagerImpl(IHttpClient client,SharePreferencesDao sharePreferencesDao){
            this.httpClient = client ;
            this.sharePreferencesDao = sharePreferencesDao ;
    }

    @Override
    public void fetchSmsCode(String phone) {

    }

    @Override
    public void checkSmsCode(String phone, String smsCode) {

    }

    @Override
    public void checkUserExist(String phone) {

    }

    @Override
    public void register(String phone, String password) {

    }

    @Override
    public void login(String phone, String password) {

    }

    @Override
    public void loginByToken() {

    }

    @Override
    public boolean isLogin() {
        //获取本地登录信息
        Account account = (Account) sharePreferencesDao.get(SharePreferencesDao.KEY_ACCOUNT,Account.class);

        //登录是否过期
        boolean tokenValid = false ;

        if(account!=null){
            if(account.getExpired()>System.currentTimeMillis()){
                tokenValid = true ;
            }
        }

        return tokenValid;
    }
}
