package com.example.workdeom.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.workdeom.DBUtils.DBUtils;
import com.example.workdeom.R;
import com.example.workdeom.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends Fragment {


    private View view;
    private RecyclerView mRlv;
    private ArrayList<DataBean> list;
    private MyAdapter adapter;
    private int mposition;

    public DFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);
        // Inflate the layout for this fragment
        initView(view);
        initData();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&adapter!=null){
            list.clear();
            initData();
        }
    }

    private void initData() {
        List<DataBean> select = DBUtils.select();
        list.addAll(select);
        adapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mRlv = (RecyclerView) view.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new MyAdapter(getContext(), list);
        mRlv.setAdapter(adapter);
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
        menu.add(1,1,1,"删除");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                DataBean bean = list.get(mposition);
                DBUtils.delete(bean);
                list.remove(bean);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "删除成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
