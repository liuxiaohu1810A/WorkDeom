package com.example.workdeom.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.workdeom.DBUtils.DBUtils;
import com.example.workdeom.Main4Activity;
import com.example.workdeom.R;
import com.example.workdeom.bean.DataBean;
import com.example.workdeom.bean.User;
import com.example.workdeom.presenter.Presenter;
import com.example.workdeom.view.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements IView<User> {


    private View view;
    private Banner mBann;
    private RecyclerView mRlv;
    private ArrayList<DataBean> list;
    private MyAdapter adapter;
    private SmartRefreshLayout mSmart;
    private int mpage=1;
    private Presenter presenter;
    private int mposition;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_a, container, false);

        initView(view);
        initData();
        return view;
    }

    private void initData() {
        presenter = new Presenter(this);
        presenter.getDataP();
    }

    private void initView(View view) {
        mBann = (Banner) view.findViewById(R.id.bann);
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mSmart = (SmartRefreshLayout) view.findViewById(R.id.smart);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new MyAdapter(getContext(), list);
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
        adapter.setA(new MyAdapter.Lxh() {
            @Override
            public void onClick(View v, int position) {
                mposition=position;
            }
        });
        registerForContextMenu(mRlv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1,1,1,"收藏");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                DataBean bean = list.get(mposition);
                DBUtils.insert(bean);
                Toast.makeText(getContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private static final String TAG = "AFragment";
    @Override
    public void onSuccess(User success) {
        List<DataBean> data = success.getData();
        list.addAll(data);
        mSmart.finishRefresh();
        mSmart.finishLoadMore();
        adapter.notifyDataSetChanged();
        mBann.setImages(data).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                DataBean path1 = (DataBean) path;
                Glide.with(context).load(path1.getPic()).into(imageView);
            }
        }).start();


    }

    @Override
    public void onFail(String fail) {
        Log.d(TAG, "onFail: "+fail);
    }

    @Override
    public void onPage(int page) {
        mpage=page;
    }



}
