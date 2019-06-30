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


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<DataBean> list;

    public MyAdapter(Context context, List<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.fragmenta_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.time.setText(list.get(i).getFood_str());
        viewHolder.title.setText(list.get(i).getTitle());
      if (i%2==0){
          Glide.with(context).load(list.get(i).getPic()).apply(new RequestOptions().circleCrop()).into(viewHolder.tt);
      }else {
          RoundedCorners roundedCorners = new RoundedCorners(15);
          RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
          Glide.with(context).load(list.get(i).getPic()).apply(requestOptions).into(viewHolder.tt);
      }
      viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
          @Override
          public boolean onLongClick(View v) {
              a.onClick(v,i);
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
        void onClick(View v,int position);
    }
}
