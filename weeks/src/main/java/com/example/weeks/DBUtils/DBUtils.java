package com.example.weeks.DBUtils;



import com.example.weeks.base.BaseApplication;
import com.example.weeks.bean.NewslistBean;
import com.example.xts.greendaodemo.db.DaoSession;
import com.example.xts.greendaodemo.db.NewslistBeanDao;

import java.util.List;

/**
 * Created by liuxiaohu on 2019/5/20.
 */

public class DBUtils {
    public static void insert(NewslistBean newslistBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        if (query(newslistBean)==null){
            daoSession.insert(newslistBean);
        }
    }
    public static void delete(NewslistBean newslistBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        if (query(newslistBean)!=null){
            daoSession.delete(newslistBean);
        }
    }
    public static List<NewslistBean> select(){
        DaoSession daoSession = BaseApplication.getDaoSession();
        return daoSession.loadAll(NewslistBean.class);
    }
    public static NewslistBean query(NewslistBean newslistBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        return daoSession.queryBuilder(NewslistBean.class)
                .where(NewslistBeanDao.Properties.PicUrl.eq(newslistBean.getPicUrl()))
                .build()
                .unique();
    }
}
