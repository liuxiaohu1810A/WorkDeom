package com.example.singleton2;

import android.util.Log;
//懒汉式
public class Singleton {
    //函数构造私有化
    private Singleton(){};
    //声明
    private  static Singleton singleton;
    public static synchronized Singleton getInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }

    private static final String TAG = "Singleton";
    public void Lxn(){
        Log.d(TAG, "Lxn: 好的呢");
    }
}
