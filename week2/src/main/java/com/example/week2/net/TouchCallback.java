package com.example.week2.net;

public interface TouchCallback {
    //上下移动  (开始索引   到达索引)
    void onItemMove(int fromPosition, int toPosition);

    //左右删除  (删除当前索引)
    void onItemDelete(int position);
}
