package com.example.week2.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;


import com.example.week2.R;
import com.example.week2.base.BaseMvpFragment;
import com.example.week2.bean.HotBean;
import com.example.week2.bean.User;
import com.example.week2.model.IModel;
import com.example.week2.presenter.IPresent;
import com.example.week2.view.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ZhiHuFragmentD extends BaseMvpFragment<IPresent, IModel, IView> implements IView<HotBean> {
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    private ArrayList<HotBean.RecentBean> beans;
    private HotnAdapter hotAdapter;
    private int mpage=1;

    @Override
    protected int getLayoutFragment() {
        return R.layout.fragmenthot;
    }

    @Override
    protected void initView(View view) {
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRlv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        beans = new ArrayList<>();
        hotAdapter = new HotnAdapter(getActivity(), beans);
        mRlv.setAdapter(hotAdapter);
        //自动刷新
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                beans.clear();
                mpage=1;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mpage++;
                initData();
            }
        });
    }

    @Override
    protected void initData() {
        myPresent.initDataPHot();
    }

    @Override
    protected IView initMvpV() {
        return this;
    }

    @Override
    protected IModel initMvpM() {
        return new IModel();
    }

    @Override
    protected IPresent initMvpP() {
        return new IPresent();
    }

    @Override
    public void onSuccess(HotBean success) {
        List<HotBean.RecentBean> recent = success.getRecent();
        beans.addAll(recent);
        mSmart.finishRefresh();
        mSmart.finishLoadMore();
        hotAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess2(User bean) {

    }

    @Override
    public void onPage(int page) {
          mpage=page;
    }

    @Override
    public void onFail(String fail) {

    }
}
