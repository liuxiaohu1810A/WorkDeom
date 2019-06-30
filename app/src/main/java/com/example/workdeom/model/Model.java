package com.example.workdeom.model;

import com.example.workdeom.api.ApiServer;
import com.example.workdeom.bean.User;
import com.example.workdeom.bean.User2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements IModel{

    private int page=1;

    @Override
    public void getDataM(final ICallBask<User> iCallBask) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiServer.url)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<User> java = apiServer.getJava(page);
        java.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                         iCallBask.onSuccess(user);
                         iCallBask.onPage(page);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallBask.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void getDataM2(final ICallBask<User2> iCallBask) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiServer.url2)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<User2> java = apiServer.getRxJava(page);
        java.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User2 user) {
                        iCallBask.onSuccess(user);
                        iCallBask.onPage(page);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallBask.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
