package com.example.weeks.net;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {


    private final Retrofit.Builder builder;

    private HttpUtils() {
        builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());


    }

    private static volatile HttpUtils httpUtils;

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    public <T> T getApiServer(String baseUrl, Class<T> tClass) {
        return builder.baseUrl(baseUrl).build().create(tClass);
    }
}
