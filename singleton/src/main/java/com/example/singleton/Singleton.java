package com.example.singleton;

import android.util.Log;

public class Singleton {

    //私有化构造
    private Singleton(){};
    //声明 类名
    private static Singleton singleton;
    //提供外部唯一实例
    public static synchronized Singleton getInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
    private static final String TAG = "Singleton";
    public void Lxh(){
        Log.d(TAG, "Lxh: 摇一摇");
    }
}
