package com.example.weeks.presenter;



import com.example.weeks.base.BaseCallBask;
import com.example.weeks.base.BasePresenter;
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
import com.example.weeks.model.IModel;
import com.example.weeks.view.IView;

import java.util.List;

public class IPresent extends BasePresenter<IModel, IView> {

    public void initDataP() {
         if (myModel!=null){
             myModel.getDataM(new BaseCallBask<ZhihuBean>() {
                 @Override
                 public void onSuccess(ZhihuBean success) {
                     myView.onSuccess(success);
                 }

                 @Override
                 public void onPage(int page) {

                 }

                 @Override
                 public void onFail(String fail) {
                    myView.onFail(fail);
                 }
             });
         }

    }
    public void initDataPZhuan() {
        if (myModel!=null){
            myModel.getDataM2(new BaseCallBask<ZhuanBean>() {
                @Override
                public void onSuccess(ZhuanBean success) {
                    myView.onSuccess(success);
                }

                @Override
                public void onPage(int page) {
                    myView.onPage(page);
                }

                @Override
                public void onFail(String fail) {
                    myView.onFail(fail);
                }
            });
        }

    }
    public void initDataPHot() {
        if (myModel!=null){
            myModel.getDataM3(new BaseCallBask<HotBean>() {
                @Override
                public void onSuccess(HotBean success) {
                    myView.onSuccess(success);
                }

                @Override
                public void onPage(int page) {
                    myView.onPage(page);
                }

                @Override
                public void onFail(String fail) {
                    myView.onFail(fail);
                }
            });
        }

    }
    public void initDataPWx() {
        if (myModel!=null){
            myModel.getDataMWechat(new BaseCallBask<WechatBean>() {
                @Override
                public void onSuccess(WechatBean success) {
                    myView.onSuccess(success);
                }

                @Override
                public void onPage(int page) {
                    myView.onPage(page);
                }

                @Override
                public void onFail(String fail) {
                    myView.onFail(fail);
                }
            });
        }

    }
    public void getAndroidDat(){
        myModel.getGankAndroidData(new BaseCallBask<GankAndroidBean>() {
            @Override
            public void onSuccess(GankAndroidBean gankAndroidBean) {
                myView.onSuccess(gankAndroidBean);
            }

            @Override
            public void onPage(int page) {

            }

            @Override
            public void onFail(String fail) {
                myView.onFail(fail);
            }


        });
    }

    public void getIosData(){
        myModel.getIosData(new BaseCallBask<GankIosBean>() {
            @Override
            public void onSuccess(GankIosBean gankIosBean) {
                myView.onSuccess(gankIosBean);
            }

            @Override
            public void onPage(int page) {

            }

            @Override
            public void onFail(String fail) {
                  onFail(fail);
            }


        });
    }

    public void getWebData(){
        myModel.getWebData(new BaseCallBask<GankWebBean>() {
            @Override
            public void onSuccess(GankWebBean gankWebBean) {
                myView.onSuccess(gankWebBean);
            }

            @Override
            public void onPage(int page) {

            }

            @Override
            public void onFail(String fail) {
                onFail(fail);
            }
        });
    }

    public void getUserData(){
        myModel.getGankUserData(new BaseCallBask<User>() {
            @Override
            public void onSuccess(User user) {
                myView.onSuccess(user);
            }

            @Override
            public void onPage(int page) {

            }

            @Override
            public void onFail(String fail) {
                onFail(fail);
            }
        });
    }

    public void getGoldData(){
        myModel.getGoldData(new BaseCallBask<GoldBean>() {
            @Override
            public void onSuccess(GoldBean goldBean) {
                myView.onSuccess(goldBean);
            }

            @Override
            public void onPage(int page) {

            }

            @Override
            public void onFail(String fail) {
                onFail(fail);
            }
        });
    }

    public void getV2exData(){
        myModel.getV2exData(new BaseCallBask<V2exBean>() {
            @Override
            public void onSuccess(V2exBean v2exBean) {
                myView.onSuccess(v2exBean);
            }

            @Override
            public void onPage(int page) {
            }

            @Override
            public void onFail(String fail) {
                onFail(fail);
            }
        });
    }

    public void getRandomData(){
        myModel.getRandomData(new BaseCallBask<User>() {
            @Override
            public void onSuccess(User user) {
                myView.onSuccess2(user);
            }

            @Override
            public void onPage(int page) {

            }

            @Override
            public void onFail(String fail) {
                onFail(fail);
            }
        });
    }
}
