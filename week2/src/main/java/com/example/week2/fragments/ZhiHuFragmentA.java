package com.example.week2.fragments;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.week2.R;
import com.example.week2.base.BaseMvpFragment;
import com.example.week2.bean.User;
import com.example.week2.bean.ZhihuBean;
import com.example.week2.model.IModel;
import com.example.week2.presenter.IPresent;
import com.example.week2.view.IView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class ZhiHuFragmentA extends BaseMvpFragment<IPresent, IModel, IView> implements IView<ZhihuBean>{
    @BindView(R.id.ban)
    Banner mBan;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private View view;
    private Unbinder unbinder;
    private ArrayList<ZhihuBean.StoriesBean> beans;
    private MyAdapter_a myAdapter_a;

    @Override
    protected int getLayoutFragment() {
        return R.layout.fragmenta;
    }

    @Override
    protected void initView(View view) {
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRlv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        beans = new ArrayList<>();
        myAdapter_a = new MyAdapter_a(getActivity(), beans);
        mRlv.setAdapter(myAdapter_a);

    }

    @Override
    protected void initData() {
        myPresent.initDataP();
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
    public void onSuccess(ZhihuBean success) {
        List<ZhihuBean.StoriesBean> stories = success.getStories();
        beans.addAll(stories);
        myAdapter_a.notifyDataSetChanged();
        List<ZhihuBean.TopStoriesBean> top_stories = success.getTop_stories();
        //Banner字段
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <top_stories.size(); i++) {
            strings.add(top_stories.get(i).getTitle());
        }
        //Banner
        mBan.setImages(top_stories).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ZhihuBean.TopStoriesBean path1 = (ZhihuBean.TopStoriesBean) path;
                Glide.with(getActivity()).load(path1.getImage()).into(imageView);
            }
        });
        mBan.setBannerTitles(strings);//Banner中的Title
        mBan.setBannerStyle(Gravity.LEFT);//Banner格式
        mBan.start();//启动Banner
    }

    @Override
    public void onSuccess2(User bean) {

    }

    @Override
    public void onPage(int page) {

    }

    @Override
    public void onFail(String fail) {

    }
}
