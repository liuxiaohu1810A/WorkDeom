package com.example.singleton2;

import android.util.Log;

//双重同步锁
public class Singleton3 {
    //构造函数私有化
    private Singleton3(){};
    //声明
    private static Singleton3 singleton3;

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
    public void Lxn3(){
        Log.d(TAG, "Lxn: 真好");
    }
}
