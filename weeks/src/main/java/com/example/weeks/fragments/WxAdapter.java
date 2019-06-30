package com.example.weeks.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weeks.R;
import com.example.weeks.bean.NewslistBean;

import java.util.List;

public class WxAdapter extends RecyclerView.Adapter<WxAdapter.ViewHolder> {
    private Context context;
    private List<NewslistBean> wxbean;

    public WxAdapter(Context context, List<NewslistBean> wxbean) {
        this.context = context;
        this.wxbean = wxbean;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragmentwechatitem, viewGroup,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        NewslistBean bean = wxbean.get(i);
        viewHolder.title.setText(bean.getTitle());
        viewHolder.name.setText(bean.getDescription());
        viewHolder.time.setText(bean.getCtime());
        Glide.with(context).load(bean.getPicUrl()).into(viewHolder.miv);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("10");
                intent.putExtra("data",i);
                context.sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
            return wxbean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView name;
        private final TextView time;
        private final ImageView miv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            miv = itemView.findViewById(R.id.iv_tu);
            title = itemView.findViewById(R.id.tv_title);
            name = itemView.findViewById(R.id.tv_name);
            time = itemView.findViewById(R.id.tv_time);

        }
    }
}
