package com.example.week2.net;

import android.util.Log;

import io.reactivex.android.BuildConfig;


/**
 * Created by $lzj on 2019/5/5.
 */
public class Logger {

    public static void logD(String tag,String msg){
        if (BuildConfig.DEBUG){
            Log.d(tag, "logD: "+msg);
        }
    }
}
