package com.example.singleton2;

import android.util.Log;

//恶汉式
public class Singleton2 {
    //构造函数私有化
    private Singleton2(){};
    //声明
    private static Singleton2 singleton2=new Singleton2();

    public static synchronized Singleton2 getInstance(){
        return singleton2;
    }

    private static final String TAG = "Singleton2";
    public void Lxn2(){
        Log.d(TAG, "Lxn2: 好滴");
    }
}
