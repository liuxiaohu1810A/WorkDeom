package com.example.week2.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutFragment(),container,false);
        //加载控件
        bind = ButterKnife.bind(this, view);
        initMVP();
        initView(view);
        initData();
        initListenter();
        return view;
    }

    protected void initListenter() {

    }

    protected void initMVP() {

    }

    protected void initData() {

    }

    protected void initView(View view) {

    }

    protected abstract int getLayoutFragment();

    @Override
    public void onDestroyView() {
        super.onDestroyView();

            bind.unbind();
    }
}
