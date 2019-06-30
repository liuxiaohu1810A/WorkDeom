package com.example.workdeom.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.workdeom.R;
import com.example.workdeom.bean.DataBean;
import com.example.workdeom.bean.ResultsBean;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {
    private Context context;

    private List<ResultsBean> list;


    public MyAdapter2(Context context, List<ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.fragmenta_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.ViewHolder viewHolder, final int i) {

        viewHolder.time.setText(list.get(i).getDesc());
        viewHolder.title.setText(list.get(i).getType());
        Glide.with(context).load(list.get(i).getUrl()).apply(new RequestOptions().circleCrop()).into(viewHolder.tt);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.onClick(v,i);
            }
        });
      viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              a.onLongClick(v,i);
              return false;
          }
      });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView tt;
        private final TextView title;
        private final TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tt = itemView.findViewById(R.id.iv_tt);
            title = itemView.findViewById(R.id.tv_title);
            time = itemView.findViewById(R.id.tv_time);
        }
    }
    private Lxh a;

    public void setA(Lxh a) {
        this.a = a;
    }

    public interface Lxh{
        void onClick(View v, int position);
        void onLongClick(View v, int position);
    }
}
