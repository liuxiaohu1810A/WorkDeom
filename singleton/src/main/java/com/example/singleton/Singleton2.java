package com.example.singleton;

import android.util.Log;

public class Singleton2 {
    //私有化构造
    private Singleton2(){};
    //声明 类名
    private static Singleton2 singleton2=new Singleton2();

    public static synchronized Singleton2 getInstance(){
        return singleton2;
    }

    private static final String TAG = "Singleton2";
    public void Lxh2(){
        Log.d(TAG, "Lxh2: 扭一扭");
    }
}
