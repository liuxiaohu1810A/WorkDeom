package com.example.week3;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.week3.app.AppConstants;
import com.example.week3.base.BaseActivity;
import com.example.week3.fragments.AboutFragment;
import com.example.week3.fragments.CollectFragment;
import com.example.week3.fragments.GankFragment;
import com.example.week3.fragments.GoldFragment;
import com.example.week3.fragments.SettingsFragment;
import com.example.week3.fragments.V2exFragment;
import com.example.week3.fragments.WxFragment;
import com.example.week3.fragments.ZhiHuFragment;
import com.example.week3.net.FragmentUtils;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;

//刘小虎1811A
public class MainActivity extends BaseActivity {

    @BindView(R.id.draw)
    DrawerLayout mDraw;
    @BindView(R.id.tool)
    Toolbar mTool;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    @BindView(R.id.frame)
    FrameLayout mFrame;
    @BindView(R.id.nav)
    NavigationView mNav;
    private ArrayList<Integer> titles;
    private ArrayList<Fragment> fm;
    private FragmentManager fms;
    private FragmentTransaction ft;
    private int mLastype;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        initList();
        initTool();
        fms = getSupportFragmentManager();
        initFragment();
        initShow();
        mNav.setItemIconTintList(null);
    }

    private void initTool() {
        mTool.setTitle(titles.get(0));
        setSupportActionBar(mTool);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, mDraw, mTool, R.string.app_name, R.string.app_name);
        abdt.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDraw.addDrawerListener(abdt);
        abdt.syncState();
    }


    private void initFragment() {
        fm = new ArrayList<>();
        fm.add(new ZhiHuFragment());
        fm.add(new WxFragment());
        fm.add(new GankFragment());
        fm.add(new GoldFragment());
        fm.add(new V2exFragment());
        fm.add(new CollectFragment());
        fm.add(new SettingsFragment());
        fm.add(new AboutFragment());
    }


    private void initList() {
        titles = new ArrayList<>();
        titles.add(R.string.zhihu);
        titles.add(R.string.wechat);
        titles.add(R.string.gank);
        titles.add(R.string.gold);
        titles.add(R.string.collect);
        titles.add(R.string.settings);
        titles.add(R.string.about);
    }

    private void initShow() {
        ft = fms.beginTransaction();
        ft.add(R.id.frame, fm.get(0));
        ft.commit();
    }



    @Override
    protected void initListenter() {
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.zhihu:
                        FragmentUtils.addFragment(fms, ZhiHuFragment.class, R.id.frame);
                        switchName(AppConstants.zhihu);
                        break;
                    case R.id.wechat:
                        FragmentUtils.addFragment(fms, WxFragment.class, R.id.frame);
                        switchName(AppConstants.wechat);

                        break;
                    case R.id.gank:
                        FragmentUtils.addFragment(fms, GankFragment.class, R.id.frame);
                        switchName(AppConstants.gank);
                        break;
                    case R.id.gold:
                        FragmentUtils.addFragment(fms, GoldFragment.class, R.id.frame);
                        switchName(AppConstants.golad);

                        break;
                    case R.id.v2ex:
                        FragmentUtils.addFragment(fms, V2exFragment.class, R.id.frame);
                        switchName(AppConstants.v2ex);
                        break;
                    case R.id.collect:
                        FragmentUtils.addFragment(fms, CollectFragment.class, R.id.frame);
                        switchName(AppConstants.collect);
                        break;
                    case R.id.settings:
                        FragmentUtils.addFragment(fms, SettingsFragment.class, R.id.frame);
                        switchName(AppConstants.setting);
                        break;
                    case R.id.ahout:
                        FragmentUtils.addFragment(fms, AboutFragment.class, R.id.frame);
                        switchName(AppConstants.about);
                        break;

                }
                mDraw.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }

    private void switchName(int type) {
      /*  if (type==AppConstants.wechat||type==AppConstants.gank){

        }*/


        mTool.setTitle(titles.get(type));
    }
}
