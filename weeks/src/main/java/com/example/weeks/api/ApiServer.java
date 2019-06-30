package com.example.weeks.api;


import com.example.weeks.bean.GankAndroidBean;
import com.example.weeks.bean.GankIosBean;
import com.example.weeks.bean.GankWebBean;
import com.example.weeks.bean.GoldBean;
import com.example.weeks.bean.HotBean;
import com.example.weeks.bean.RandomBean;
import com.example.weeks.bean.User;
import com.example.weeks.bean.V2exBean;
import com.example.weeks.bean.WechatBean;
import com.example.weeks.bean.ZhihuBean;
import com.example.weeks.bean.ZhuanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServer {
    //日报
    String ZhUrl="http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<ZhihuBean> textRxJava();

   //热门
    String HotUrl="http://news-at.zhihu.com/";
    @GET("api/{page}/news/hot")
    Observable<HotBean> HotRxJava(@Path("page") int page);
    //专栏
    String ZtUrl="http://news-at.zhihu.com/";
    @GET("api/{page}/sections")
    Observable<ZhuanBean> ZtRxJava(@Path("page") int page);
    //微信精选
    String WxUrl="http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WechatBean> WxRxJava();
    //微信精选(搜索)
    String SeatchUrl="http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10")
    Observable<WechatBean> SeatchRxJava(@Query("word") String word);
    //gank   android
    String gankAndroidUrl = "http://gank.io/";
    @GET("api/data/Android/15/1")
    Observable<GankAndroidBean> getAndroidData();
 //gank   Seatchandroid
 String SeatchgankAndroidUrl = "http://gank.io/";
 @GET("api/search/query/{}/category/Android/count/10/page/1")
 Observable<GankAndroidBean> getsectchAndroidData(@Query("word") String word);
    //gank  ios
    String gankIosUrl = "http://gank.io/";
    @GET("api/data/iOS/15/1")
    Observable<GankIosBean> getIosData();

    //gank  web
    String gankWebUrl = "http://gank.io/";
    @GET("api/data/前端/15/1")
    Observable<GankWebBean> getWebData();

    //gank  user
    String gankLikeUrl = "http://gank.io/";
    @GET("api/data/福利/10/1")
    Observable<User> getUserData();

    //gold
    String goldUrl = "https://gank.io/api/";
    @GET("data/瞎推荐/15/1")
    Observable<GoldBean> getGoldData();

    //v2ex
    String v2exUrl = "http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<V2exBean> getV2exData();

    //随机图片
    String randomUrl = "http://gank.io/";
    @GET("api/random/data/Android/20")
    Observable<RandomBean> getRandomData();
}
