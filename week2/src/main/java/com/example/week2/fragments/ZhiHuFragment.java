package com.example.week2.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.example.week2.R;
import com.example.week2.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class ZhiHuFragment extends BaseFragment {
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.vp)
    ViewPager mVp;
    private View view;
    private Unbinder unbinder;
    private ArrayList<Fragment> fm;
    private ZHVpAdapter vpAdapter;

    @Override
    protected int getLayoutFragment() {
        return R.layout.fragment_zhihu_daily_news;
    }

    @Override
    protected void initView(View view) {
        initPager();
        initTab();
    }

    private void initPager() {
        fm = new ArrayList<>();
        fm.add(new ZhiHuFragmentA());
        fm.add(new ZhiHuFragmentB());
        fm.add(new ZhiHuFragmentC());
        fm.add(new ZhiHuFragmentD());
        vpAdapter = new ZHVpAdapter(getChildFragmentManager(),fm);
        mVp.setAdapter(vpAdapter);
    }

    private void initTab() {
        mTabLayout.addTab(mTabLayout.newTab().setText("日报"));
        mTabLayout.addTab(mTabLayout.newTab().setText("主题"));
        mTabLayout.addTab(mTabLayout.newTab().setText("专栏"));
        mTabLayout.addTab(mTabLayout.newTab().setText("热点"));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {

    }
}
