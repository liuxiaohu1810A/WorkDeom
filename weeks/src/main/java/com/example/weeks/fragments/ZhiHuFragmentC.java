package com.example.weeks.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.weeks.R;
import com.example.weeks.base.BaseFragment;
import com.example.weeks.base.BaseMvpFragment;
import com.example.weeks.bean.User;
import com.example.weeks.bean.ZhuanBean;
import com.example.weeks.model.IModel;
import com.example.weeks.presenter.IPresent;
import com.example.weeks.view.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ZhiHuFragmentC extends BaseMvpFragment<IPresent, IModel, IView> implements IView<ZhuanBean>{
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    private ArrayList<ZhuanBean.DataBean> beans;
    private ZhuanAdapter zhuanAdapter;
    private int mpage=1;

    @Override
    protected int getLayoutFragment() {
        return R.layout.fragmentsetting;
    }

    @Override
    protected void initView(View view) {
        mRlv.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRlv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        beans = new ArrayList<>();
        zhuanAdapter = new ZhuanAdapter(getActivity(), beans);
        mRlv.setAdapter(zhuanAdapter);
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
        myPresent.initDataPZhuan();
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
    public void onSuccess(ZhuanBean success) {
        List<ZhuanBean.DataBean> data = success.getData();
        beans.addAll(data);
        mSmart.finishLoadMore();
        mSmart.finishRefresh();
        zhuanAdapter.notifyDataSetChanged();
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
