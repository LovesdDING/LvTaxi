package com.cz10000.lvtaxi.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cz10000.lvtaxi.MyApplication;
import com.cz10000.lvtaxi.R;
import com.cz10000.lvtaxi.account.model.AccoutManagerImpl;
import com.cz10000.lvtaxi.account.model.IAccountManager;
import com.cz10000.lvtaxi.common.http.IHttpClient;
import com.cz10000.lvtaxi.common.http.impl.OkHttpClientImpl;
import com.cz10000.lvtaxi.common.storage.SharePreferencesDao;

/**
 * 主页面：
 * -- 登录逻辑
 * 检查本地记录 -登录态检查
 * 若用户没有登录则登录
 * 登陆之前校验手机号
 * token有效 使用token自动登录
 * <p>
 * todo: 地图初始化 接入
 */
public class Main2Activity extends AppCompatActivity {

    private IAccountManager accountManager;
    private IHttpClient httpClient;
    private SharePreferencesDao sharePreferenceDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        httpClient = new OkHttpClientImpl();
        sharePreferenceDao = new SharePreferencesDao(MyApplication.getInstance(), SharePreferencesDao.KEY_ACCOUNT);

        accountManager = new AccoutManagerImpl(httpClient, sharePreferenceDao);

        checkLoginState();
    }

    /**
     * 检查登录态
     * <p>
     * 判断token是否过期 过期 就进行输入手机号的登录注册
     * 未过期 自动登录
     */
    private void checkLoginState() {

        accountManager.isLogin();

    }
}
