package com.example.week3.app;

import android.os.Environment;


import com.example.week3.base.BaseApplication;

import java.io.File;

/**
 * Created by $lzj on 2019/5/5.
 */
public interface AppConstants {
//选中Fragment页面
    public static final int zhihu =0;
    public static final int wechat =1;
    public static final int gank =2;
    public static final int golad =3;
    public static final int v2ex =4;
    public static final int collect =5;
    public static final int setting =6;
    public static final int about =7;

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "code" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApplication.getApplication().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";

}
