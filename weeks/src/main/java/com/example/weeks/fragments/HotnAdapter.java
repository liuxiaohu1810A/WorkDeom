package com.example.weeks.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weeks.R;
import com.example.weeks.bean.HotBean;


import java.util.List;

public class HotnAdapter extends RecyclerView.Adapter<HotnAdapter.ViewHolder> {
    private Context context;
    private List<HotBean.RecentBean> hotbean;

    public HotnAdapter(Context context, List<HotBean.RecentBean> hotbean) {
        this.context = context;
        this.hotbean = hotbean;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragmenthotitem, viewGroup,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        HotBean.RecentBean bean = hotbean.get(i);
        viewHolder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getThumbnail()).into(viewHolder.miv);
    }

    @Override
    public int getItemCount() {
            return hotbean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView miv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            miv = itemView.findViewById(R.id.iv_tu);
            title = itemView.findViewById(R.id.tv_title);

        }
    }
}
