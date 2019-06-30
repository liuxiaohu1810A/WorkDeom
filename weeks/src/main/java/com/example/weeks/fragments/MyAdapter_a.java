package com.example.weeks.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weeks.R;
import com.example.weeks.bean.ZhihuBean;

import java.util.List;

public class MyAdapter_a extends RecyclerView.Adapter<MyAdapter_a.ViewHolder> {
    private Context content;
    private List<ZhihuBean.StoriesBean> list;

    public MyAdapter_a(Context content, List<ZhihuBean.StoriesBean> list) {
        this.content = content;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(content, R.layout.fragmenthotitem, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(list.get(i).getTitle());
        Glide.with(content).load(list.get(i).getImages().get(0)).into(viewHolder.tu);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView tu;
        private final TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tu = itemView.findViewById(R.id.iv_tu);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
