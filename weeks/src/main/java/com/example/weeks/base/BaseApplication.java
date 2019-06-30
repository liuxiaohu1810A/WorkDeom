package com.example.weeks.base;

import android.app.Application;

import com.example.xts.greendaodemo.db.DaoMaster;
import com.example.xts.greendaodemo.db.DaoSession;

public class BaseApplication extends Application {
    private static BaseApplication application;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        initData();
    }

    private void initData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "lxh.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }

    public static BaseApplication getApplication(){
        return application;
    }
}
