package com.cz10000.lvtaxi.common.storage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * sharepreference 读取对象
 * Created by cz10000_001 on 2018/7/9.
 */

public class SharePreferencesDao {
    private static final String TAG= "SharePreferencesDao"  ;
    public static final String FILE_ACCOUNT = "FILE_ACCOUNT" ;
    public static final String KEY_ACCOUNT = "KEY_ACCOUNT" ;

    private SharedPreferences sharedPreferences ;

    /**
     * 初始化
     * @param application
     * @param file_name
     */
    public SharePreferencesDao(Application application,String file_name){
        sharedPreferences = application.getSharedPreferences(file_name, Context.MODE_PRIVATE) ;
    }

    /**
     * 保存 k-v
     * @param key
     * @param value
     */
    public void save(String key,String value){
       sharedPreferences.edit().putString(key,value).commit() ;
    }

    /**
     * 读取 k-v
     * @param key
     * @return
     */
    public String get(String key){
        return sharedPreferences.getString(key,null ) ;
    }

    /**
     * 保存对象
     * @param key
     * @param object
     */
    public void save(String key,Object object){
        String value = new Gson().toJson(object) ;
        save(key, value) ;
    }


    /**
     * 读取对象
     * @param key
     * @param cls
     * @return
     */
    public Object get(String key,Class cls){
        String value = get(key) ;
        try {
            if(value!=null){
                Object o = new Gson().fromJson(value,cls) ;
                return  o ;
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            Log.e(TAG,e.getMessage()) ;
        }

        return null ;


    }



}
