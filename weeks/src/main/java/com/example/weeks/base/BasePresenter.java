package com.example.weeks.base;


import java.util.ArrayList;
import java.util.List;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView>{
    protected List<BaseModel> list=new ArrayList<>();
     protected M myModel;
     protected V myView;

    public void initModel(M initMvpM) {
        this.myModel=initMvpM;
        list.add(initMvpM);
    }

    public void attachView(V initMvpV) {
       this.myView=initMvpV;
    }

    public void destroy() {
        if (list!=null&&list.size()>0){
            for (BaseModel baseModel:list) {
                baseModel.destroy();
            }
        }
        if (myView!=null){
            myView=null;
        }
        if (myModel!=null){
            myModel=null;
        }
    }
}
