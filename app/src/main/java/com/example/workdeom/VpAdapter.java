package com.example.workdeom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class VpAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> list;

    public VpAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.main3_vp, null);
        ImageView tu = view.findViewById(R.id.iv_tu);
        Button bt = view.findViewById(R.id.bt);
        tu.setImageResource(list.get(position));
        bt.setVisibility(View.GONE);
        if (position==2){
            bt.setVisibility(View.VISIBLE);
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,Main4Activity.class));
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }
}
