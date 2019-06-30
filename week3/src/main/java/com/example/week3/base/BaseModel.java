package com.example.week3.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();

    public void destroy() {
        //清空
         compositeDisposable.clear();
    }
}
