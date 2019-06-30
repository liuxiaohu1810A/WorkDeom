package com.example.week2.base;

public interface BaseCallBask<T> {
    void onSuccess(T success);
    void onPage(int page);
    void onFail(String fail);
}
