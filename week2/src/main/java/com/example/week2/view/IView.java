package com.example.week2.view;


import com.example.week2.base.BaseView;
import com.example.week2.bean.User;

public interface IView<T> extends BaseView {
    void onSuccess(T success);
    void onSuccess2(User bean);
    void onPage(int page);
    void onFail(String fail);
}
