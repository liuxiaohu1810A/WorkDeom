package com.example.workdeom.api;

import com.example.workdeom.bean.User;
import com.example.workdeom.bean.User2;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServer {
    String url="http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<User> getJava(@Query("page") int page);


    String url2="http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/{page}")
    Observable<User2> getRxJava(@Path("page") int page);
}
