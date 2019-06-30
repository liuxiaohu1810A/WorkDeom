package com.example.weeks.model;

import android.util.Log;


import com.example.weeks.api.ApiServer;
import com.example.weeks.base.BaseCallBask;
import com.example.weeks.base.BaseModel;
import com.example.weeks.base.BaseObserver;
import com.example.weeks.bean.GankAndroidBean;
import com.example.weeks.bean.GankIosBean;
import com.example.weeks.bean.GankWebBean;
import com.example.weeks.bean.GoldBean;
import com.example.weeks.bean.HotBean;
import com.example.weeks.bean.User;
import com.example.weeks.bean.V2exBean;
import com.example.weeks.bean.WechatBean;
import com.example.weeks.bean.ZhihuBean;
import com.example.weeks.bean.ZhuanBean;
import com.example.weeks.net.HttpUtils;
import com.example.weeks.net.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.GET;

public class IModel extends BaseModel {

    private int page=4;
    private String wort;

    public void getDataM(final BaseCallBask<ZhihuBean> baseCallBask) {
        ApiServer apiServer = HttpUtils.getInstance().getApiServer(ApiServer.ZhUrl, ApiServer.class);
        Observable<ZhihuBean> rxJava = apiServer.textRxJava();
        rxJava.compose(RxUtils.<ZhihuBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZhihuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhihuBean zhihuBean) {

                        baseCallBask.onSuccess(zhihuBean);
                    }
                });
    }
    public void getDataM2(final BaseCallBask<ZhuanBean> baseCallBask) {
        ApiServer apiServer = HttpUtils.getInstance().getApiServer(ApiServer.ZtUrl, ApiServer.class);
        Observable<ZhuanBean> rxJava = apiServer.ZtRxJava(page);
        rxJava.compose(RxUtils.<ZhuanBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZhuanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhuanBean zhuanBean) {

                        baseCallBask.onSuccess(zhuanBean);
                        baseCallBask.onPage(page);
                    }
                });
    }
    public void getDataM3(final BaseCallBask<HotBean> baseCallBask) {
        ApiServer apiServer = HttpUtils.getInstance().getApiServer(ApiServer.HotUrl, ApiServer.class);
        Observable<HotBean> rxJava = apiServer.HotRxJava(page);
        rxJava.compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {

                        baseCallBask.onSuccess(hotBean);
                        baseCallBask.onPage(page);
                    }
                });
    }
    public void getDataMWechat(final BaseCallBask<WechatBean> baseCallBask) {
        ApiServer apiServer = HttpUtils.getInstance().getApiServer(ApiServer.WxUrl, ApiServer.class);
        Observable<WechatBean> rxJava = apiServer.WxRxJava();
        rxJava.compose(RxUtils.<WechatBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        baseCallBask.onSuccess(wechatBean);
                    }
                });
    }
    private static final String TAG = "IModel";
    public void getGankAndroidData(final BaseCallBask<GankAndroidBean> callback){
        ApiServer data = HttpUtils.getInstance().getApiServer(ApiServer.gankAndroidUrl, ApiServer.class);
        data.getAndroidData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankAndroidBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(GankAndroidBean gankAndroidBean) {
                        callback.onSuccess(gankAndroidBean);
                        Log.d(TAG, "onNext: "+gankAndroidBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void getIosData(final BaseCallBask<GankIosBean> callback){
        ApiServer data = HttpUtils.getInstance().getApiServer(ApiServer.gankIosUrl, ApiServer.class);
        data.getIosData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankIosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(GankIosBean gankIosBean) {
                        callback.onSuccess(gankIosBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void getWebData(final BaseCallBask<GankWebBean> callback){
        ApiServer data = HttpUtils.getInstance().getApiServer(ApiServer.gankWebUrl, ApiServer.class);
        data.getWebData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankWebBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(GankWebBean gankWebBean) {
                        callback.onSuccess(gankWebBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void getGankUserData(final BaseCallBask<User> callback){
        ApiServer data = HttpUtils.getInstance().getApiServer(ApiServer.gankWebUrl, ApiServer.class);
        data.getUserData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(User user) {
                        callback.onSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void getGoldData(final BaseCallBask<GoldBean> callback){
        ApiServer data = HttpUtils.getInstance().getApiServer(ApiServer.goldUrl, ApiServer.class);
        data.getGoldData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoldBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(GoldBean goldBean) {
                        Log.d(TAG, "onNext: "+goldBean);
                        callback.onSuccess(goldBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void getV2exData(final BaseCallBask<V2exBean> callback){
        ApiServer data = HttpUtils.getInstance().getApiServer(ApiServer.v2exUrl, ApiServer.class);
        data.getV2exData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<V2exBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(V2exBean v2exBean) {
                        callback.onSuccess(v2exBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getRandomData(final BaseCallBask<User> callback){
        ApiServer data = HttpUtils.getInstance().getApiServer(ApiServer.gankLikeUrl, ApiServer.class);
        data.getUserData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        callback.onSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
