package com.example.week2.base;

import android.util.Log;

import io.reactivex.Observer;

/**
 * Created by $lzj on 2019/6/4.
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private final String TAG = getClass().getName();

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: "+e.toString());
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete: ");
    }

}
