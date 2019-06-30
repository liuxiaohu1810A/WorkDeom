package com.example.workdeom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvTu;
    /**
     * asd
     */
    private TextView mTv;
    /**
     * 跳转
     */
    private Button mBt;
    private ObjectAnimator rotation;
    private ObjectAnimator translationY;
    private ObjectAnimator scaleX;
    private ObjectAnimator alpha;
    private CountDownTimer start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        alpha = ObjectAnimator.ofFloat(mIvTu, "alpha", 0f, 1.0f);
        scaleX = ObjectAnimator.ofFloat(mIvTu, "scaleX", 1.5f, 0, 1.5f);
        translationY = ObjectAnimator.ofFloat(mIvTu, "translationY", 0f, 200, 0f);
        rotation = ObjectAnimator.ofFloat(mIvTu, "rotation", 0f, 360.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alpha).with(scaleX).with(translationY).after(rotation);
        animatorSet.setDuration(3000);
        animatorSet.start();
        start = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTv.setText("倒计时:" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                finish();
            }
        }.start();
    }

    private void initView() {
        mIvTu = (ImageView) findViewById(R.id.iv_tu);
        mTv = (TextView) findViewById(R.id.tv);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                start.cancel();
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                finish();
                break;
        }
    }
}
