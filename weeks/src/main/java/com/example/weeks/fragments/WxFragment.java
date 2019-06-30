package com.example.weeks.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.weeks.R;
import com.example.weeks.base.BaseFragment;
import com.example.weeks.base.BaseMvpFragment;
import com.example.weeks.bean.HotBean;
import com.example.weeks.bean.NewslistBean;
import com.example.weeks.bean.User;
import com.example.weeks.bean.WechatBean;
import com.example.weeks.model.IModel;
import com.example.weeks.presenter.IPresent;
import com.example.weeks.view.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WxFragment extends BaseMvpFragment<IPresent, IModel, IView> implements IView<WechatBean> {
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    private ArrayList<NewslistBean> beans;
    private WxAdapter wxAdapter;
    private int mpage=1;

    @Override
    protected int getLayoutFragment() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView(View view) {
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRlv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        beans = new ArrayList<>();
        wxAdapter = new WxAdapter(getActivity(), beans);
        mRlv.setAdapter(wxAdapter);
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
        myPresent.initDataPWx();
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
    public void onSuccess(WechatBean success) {
        List<NewslistBean> newslist = success.getNewslist();
        beans.addAll(newslist);
        mSmart.finishLoadMore();
        mSmart.finishRefresh();
        wxAdapter.notifyDataSetChanged();
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
