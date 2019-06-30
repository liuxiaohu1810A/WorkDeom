package com.example.singleton;
//刘小虎1811A

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 懒汉式
     */
    private Button mSingleton1;
    /**
     * 恶汉式
     */
    private Button mSingleton2;
    /**
     * 双层锁
     */
    private Button mSingleton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSingleton1 = (Button) findViewById(R.id.Singleton1);
        mSingleton1.setOnClickListener(this);
        mSingleton2 = (Button) findViewById(R.id.Singleton2);
        mSingleton2.setOnClickListener(this);
        mSingleton3 = (Button) findViewById(R.id.Singleton3);
        mSingleton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.Singleton1:
                initSingleton1();
                break;
            case R.id.Singleton2:
                initSingleton2();
                break;
            case R.id.Singleton3:
                initSingleton3();
                break;
        }
    }

    private void initSingleton1() {
          Singleton.getInstance().Lxh();
    }
    private void initSingleton2() {
          Singleton2.getInstance().Lxh2();
    }
    private void initSingleton3() {
          Singleton3.getInstance().Lxh3();
    }
}
