package com.example.workdeom.presenter;

import com.example.workdeom.bean.User;
import com.example.workdeom.bean.User2;
import com.example.workdeom.model.ICallBask;
import com.example.workdeom.model.Model;
import com.example.workdeom.view.IView;

public class Presenter implements IPresenter{
    private final Model model;
    private IView iView;

    public Presenter(IView iView) {
        this.iView = iView;
        model = new Model();
    }

    @Override
    public void getDataP() {
        if (model!=null){
            model.getDataM(new ICallBask<User>() {
                @Override
                public void onSuccess(User success) {
                    iView.onSuccess(success);
                }

                @Override
                public void onFail(String fail) {
                    iView.onFail(fail);
                }

                @Override
                public void onPage(int page) {
                    iView.onPage(page);
                }
            });
        }
    }

    @Override
    public void getDataP2() {
        if (model!=null){
            model.getDataM2(new ICallBask<User2>() {
                @Override
                public void onSuccess(User2 success) {
                    iView.onSuccess(success);
                }

                @Override
                public void onFail(String fail) {
                    iView.onFail(fail);
                }

                @Override
                public void onPage(int page) {
                    iView.onPage(page);
                }
            });
        }
    }
}
