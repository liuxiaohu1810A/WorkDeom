package com.example.week2.net;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleItemTouchHelpCallback extends ItemTouchHelper.Callback {

    private TouchCallback touchCallback;

    public SimpleItemTouchHelpCallback(TouchCallback touchCallback) {
        this.touchCallback = touchCallback;
    }

    //确定可以滑动的方向
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        int swipeFlags = ItemTouchHelper.LEFT;

        return makeMovementFlags(dragFlags,swipeFlags);
    }

    //上下移动
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        //调用touchcallback里面的两个方法
        touchCallback.onItemMove(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        return true;
    }

    //左右滑动
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        touchCallback.onItemDelete(viewHolder.getAdapterPosition());
    }
}
