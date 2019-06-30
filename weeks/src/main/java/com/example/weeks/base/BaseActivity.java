package com.example.weeks.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        //初始化加载控件
        ButterKnife.bind(this);

        initView();
        initData();
        initListenter();
    }

    protected void initListenter() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected abstract int getLayoutID();
}
