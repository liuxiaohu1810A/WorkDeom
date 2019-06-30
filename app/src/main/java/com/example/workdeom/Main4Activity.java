package com.example.workdeom;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.workdeom.fragments.AFragment;
import com.example.workdeom.fragments.BFragment;
import com.example.workdeom.fragments.CFragment;
import com.example.workdeom.fragments.DFragment;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    private Toolbar mTool;
    private ViewPager mVp;
    private TabLayout mTab;
    private NavigationView mNa;
    private DrawerLayout mDraw;
    private ArrayList<Fragment> fm;
    private TextView mTvName;
    private MyVpAdapter myVpAdapter;
    private ImageView mTu;
    private Notification build;
    private int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        initVape();
        initTab();
        initData();
    }

    private void initData() {
          NotificationManager service = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                          Intent in = new Intent(this, WebActivity.class);
                          PendingIntent activities = PendingIntent.getActivity(this, 10,in,PendingIntent.FLAG_CANCEL_CURRENT);
                          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                              NotificationChannel channel = new NotificationChannel("10", "ss", NotificationManager.IMPORTANCE_DEFAULT);
                              service.createNotificationChannel(channel);
                          }
                          build = new NotificationCompat.Builder(this, "10")
                                  .setAutoCancel(true)
                                  .setContentTitle("通知")
                                  .setContentText("进入详情")
                                  .setContentIntent(activities)
                                  .setSmallIcon(R.mipmap.ic_launcher_round)
                                  .setDefaults(Notification.DEFAULT_ALL)
                                  .build();
                          i++;
                          service.notify(i,build);
    }

    private void initTab() {
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setIcon(R.drawable.tab1).setText("首页");
        mTab.getTabAt(1).setIcon(R.drawable.tab2).setText("数据");
        mTab.getTabAt(2).setIcon(R.drawable.tab3).setText("文件");
        mTab.getTabAt(3).setIcon(R.drawable.tab4).setText("收藏");
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
                mTvName.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initVape() {
        fm = new ArrayList<>();
        fm.add(new AFragment());
        fm.add(new BFragment());
        fm.add(new CFragment());
        fm.add(new DFragment());
        myVpAdapter = new MyVpAdapter(getSupportFragmentManager(), fm);
        mVp.setAdapter(myVpAdapter);
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        mNa = (NavigationView) findViewById(R.id.na);
        mDraw = (DrawerLayout) findViewById(R.id.draw);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mTu = (ImageView) findViewById(R.id.tu);
        mTool.setTitle("");
        Glide.with(this).load(R.mipmap.ic_launcher)
                .apply(new RequestOptions().circleCrop())
                .into(mTu);
        setSupportActionBar(mTool);

        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, mDraw, mTool, R.string.app_name, R.string.app_name);
        mDraw.addDrawerListener(abdt);
        abdt.syncState();


        View view = mNa.getHeaderView(0);
        final ImageView img = view.findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
