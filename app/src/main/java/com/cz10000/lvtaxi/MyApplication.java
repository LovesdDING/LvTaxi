package com.cz10000.lvtaxi;

import android.app.Application;

/**
 * Created by cz10000_001 on 2018/7/9.
 */

public class MyApplication extends Application {

    private static  MyApplication instance  ;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this ;
    }

    public static MyApplication getInstance(){
        return instance ;
    }


}
