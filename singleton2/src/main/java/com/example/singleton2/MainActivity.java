package com.example.singleton2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//刘小虎1811A
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 懒汉式
     */
    private Button mBtSingle1;
    /**
     * 恶汉式
     */
    private Button mBtSingle2;
    /**
     * 双重锁
     */
    private Button mBtSingle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtSingle1 = (Button) findViewById(R.id.bt_Single1);
        mBtSingle1.setOnClickListener(this);
        mBtSingle2 = (Button) findViewById(R.id.bt_Single2);
        mBtSingle2.setOnClickListener(this);
        mBtSingle3 = (Button) findViewById(R.id.bt_Single3);
        mBtSingle3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_Single1:
                Singleton1();
                break;
            case R.id.bt_Single2:
                Singleton2();
                break;
            case R.id.bt_Single3:
                Singleton3();
                break;
        }
    }

    private void Singleton1() {
          Singleton.getInstance().Lxn();
    }
    private void Singleton2() {
        Singleton2.getInstance().Lxn2();
    }
    private void Singleton3() {
          Singleton3.getInstance().Lxn3();
    }
}
