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
import com.example.weeks.bean.ZhuanBean;


import java.util.List;

public class ZhuanAdapter extends RecyclerView.Adapter<ZhuanAdapter.ViewHolder> {
    private Context context;
    private List<ZhuanBean.DataBean> zhuanbean;

    public ZhuanAdapter(Context context, List<ZhuanBean.DataBean> zhuanbean) {
        this.context = context;
        this.zhuanbean = zhuanbean;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragmentsettingitem, viewGroup,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZhuanBean.DataBean bean = zhuanbean.get(i);
        viewHolder.title.setText(bean.getDescription());
        viewHolder.name.setText(bean.getName());
        Glide.with(context).load(bean.getThumbnail()).into(viewHolder.miv);
    }

    @Override
    public int getItemCount() {
            return zhuanbean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView name;
        private final ImageView miv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            miv = itemView.findViewById(R.id.iv_tu);
            title = itemView.findViewById(R.id.tv_title);
            name = itemView.findViewById(R.id.tv_name);

        }
    }
}
