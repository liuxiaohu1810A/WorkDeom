package com.example.workdeom.view;

public interface IView<T> {
    void onSuccess(T success);
    void onFail(String fail);
    void onPage(int page);
}
