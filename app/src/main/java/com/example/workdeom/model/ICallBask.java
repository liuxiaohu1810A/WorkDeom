package com.example.workdeom.model;

public interface ICallBask<T> {
    void onSuccess(T success);
    void onFail(String fail);
    void onPage(int page);
}
