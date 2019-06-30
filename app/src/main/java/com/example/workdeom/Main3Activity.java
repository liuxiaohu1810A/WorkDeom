package com.example.workdeom;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<Integer> list;
    private VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        list = new ArrayList<>();
        list.add(R.mipmap.dl);
        list.add(R.mipmap.ka);
        list.add(R.mipmap.th);
        vpAdapter = new VpAdapter(this, list);
        mVp.setAdapter(vpAdapter);
    }
}
