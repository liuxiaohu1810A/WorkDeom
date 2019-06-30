package com.example.workdeom.DBUtils;

import android.util.Log;


import com.example.workdeom.MyApplication;
import com.example.workdeom.bean.DataBean;
import com.example.xts.greendaodemo.db.DaoSession;
import com.example.xts.greendaodemo.db.DataBeanDao;

import java.util.List;

public class DBUtils {
    private static final String TAG = "DBUtils";
    //插入
    public static void insert(DataBean datasBean){
        DaoSession daoSession = MyApplication.getDaoSession();
        if (query(datasBean)==null){
            daoSession.insert(datasBean);
            Log.e("数据库=====","添加");
        }else{
            Log.d(TAG, "insert: "+daoSession);
        }
    }
    //删除
    public static void delete(DataBean datasBean){
        DaoSession daoSession = MyApplication.getDaoSession();
        if (query(datasBean)!=null){
            daoSession.delete(datasBean);
        }else{
            Log.d(TAG, "insert: "+datasBean);
        }
    }
    //查询
    public static List<DataBean> select(){
        DaoSession daoSession = MyApplication.getDaoSession();
        return daoSession.queryBuilder(DataBean.class).list();
    }
    //修改
    public static void update(DataBean datasBean){
        DaoSession daoSession = MyApplication.getDaoSession();
        daoSession.update(datasBean);
    }
    public static DataBean query(DataBean datasBean){
        DaoSession daoSession = MyApplication.getDaoSession();
        if(datasBean!=null){
            return daoSession.queryBuilder(DataBean.class)
                    .where(DataBeanDao.Properties.Title.eq(datasBean.getTitle()))
                    .build()
                    .unique();
        }else {
            return null;
        }

    }
}
