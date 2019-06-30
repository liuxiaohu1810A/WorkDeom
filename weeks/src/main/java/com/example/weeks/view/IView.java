package com.example.weeks.view;



import com.example.weeks.base.BaseView;
import com.example.weeks.bean.User;

import java.util.List;

public interface IView<T> extends BaseView {
    void onSuccess(T success);
    void onSuccess2(User bean);
    void onPage(int page);
    void onFail(String fail);
}
