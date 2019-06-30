package com.example.workdeom.fragments;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.workdeom.DBUtils.DBUtils;
import com.example.workdeom.R;
import com.example.workdeom.WebActivity;
import com.example.workdeom.bean.ResultsBean;
import com.example.workdeom.bean.User2;
import com.example.workdeom.presenter.Presenter;
import com.example.workdeom.view.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements IView<User2> {


    private View view;
    private RecyclerView mRlv;
    private SmartRefreshLayout mSmart;
    private ArrayList<ResultsBean> list;
    private int mpage=1;
    private MyAdapter2 adapter;
    private PopupWindow popupWindow;
    private int i=1;
    private Notification build;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_b, container, false);
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Presenter presenter = new Presenter(this);
        presenter.getDataP2();
    }

    private void initView(final View view) {
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new MyAdapter2(getContext(), list);
        mRlv.setAdapter(adapter);
        mSmart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mpage=1;
                list.clear();
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mpage++;
                initData();
            }
        });
        adapter.setA(new MyAdapter2.Lxh() {
            @Override
            public void onClick(View v, final int position) {
                View view1 = View.inflate(getContext(), R.layout.popupwindow, null);
                                Button delete = view1.findViewById(R.id.bt_delete);

                                popupWindow = new PopupWindow(view1,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                                popupWindow.showAtLocation(view1, Gravity.CENTER,0,0);
                                Lxn(0.5f);
                                delete.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ResultsBean resultsBean = list.get(position);
                                        list.remove(resultsBean);
                                        adapter.notifyDataSetChanged();
                                        popupWindow.dismiss();
                                        Lxn(1);
                                    }
                                });
            }
            public void Lxn(float bgAlpha){
                WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
                attributes.alpha=bgAlpha;
                getActivity().getWindow().setAttributes(attributes);
            }
            @Override
            public void onLongClick(View v, int position) {
                NotificationManager service = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                Intent in = new Intent(getContext(), WebActivity.class);
                PendingIntent activities = PendingIntent.getActivity(getContext(), 10,in,PendingIntent.FLAG_CANCEL_CURRENT);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("10", "ss", NotificationManager.IMPORTANCE_DEFAULT);
                    service.createNotificationChannel(channel);
                }
                build = new NotificationCompat.Builder(getContext(), "10")
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
        });
    }

    private static final String TAG = "BFragment";
    @Override
    public void onSuccess(User2 success) {
        List<ResultsBean> results = success.getResults();
        list.addAll(results);
        mSmart.finishRefresh();
        mSmart.finishLoadMore();
        adapter.notifyDataSetChanged();
        Log.d(TAG, "onSuccess: "+results);
    }

    @Override
    public void onFail(String fail) {
        Log.d(TAG, "onFail: "+fail);
    }

    @Override
    public void onPage(int page) {
       mpage=page;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item:
                mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
                break;
            case R.id.item2:
                mRlv.setLayoutManager(new GridLayoutManager(getContext(),2));
                break;
            case R.id.item3:
                mRlv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
