package com.example.singleton;

import android.util.Log;

public class Singleton3 {
    //私有化构造
    private Singleton3(){}
    //声明 类名
     private static Singleton3 singleton3;
     //加双重同步锁
    public static Singleton3 getInstance(){
        if (singleton3==null){
            synchronized (Singleton3.class){
                if (singleton3==null){
                    singleton3=new Singleton3();
                }
            }
        }
        return singleton3;
    }

    private static final String TAG = "Singleton3";
    public void Lxh3(){
        Log.d(TAG, "Lxh3: 泡一泡");
    }
}
