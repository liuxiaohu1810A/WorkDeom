package com.example.week3.base;

public abstract class BaseMvpFragment<P extends BasePresenter,M extends BaseModel,V extends BaseView> extends BaseFragment {
    protected P myPresent;

    @Override
    protected void initMVP() {
        myPresent=initMvpP();
        if (myPresent!=null){
            myPresent.initModel(initMvpM());
            myPresent.attachView(initMvpV());
        }
    }

    protected abstract V initMvpV();

    protected abstract M initMvpM();

    protected abstract P initMvpP();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myPresent!=null){
            myPresent.destroy();
            myPresent=null;
        }
    }
}
