package com.example.workdeom.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.workdeom.Fuwu;
import com.example.workdeom.Main2Activity;
import com.example.workdeom.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 上传文件
     */
    private Button mBtShangChuang;
    /**
     * 上传
     */
    private TextView mTvShangChuang;
    private ImageView mIvTp;
    /**
     * 下载文件
     */
    private Button mBtXiaZai;
    private ProgressBar mPb;
    /**
     * 下载
     */
    private TextView mTvXiaZai;
    private ImageView mIvTt;

    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        // Inflate the layout for this fragment
        initView(view);
        //注册
        EventBus.getDefault().register(this);
        return view;
    }

    private void initView(View view) {
        mBtShangChuang = (Button) view.findViewById(R.id.bt_ShangChuang);
        mBtShangChuang.setOnClickListener(this);
        mTvShangChuang = (TextView) view.findViewById(R.id.tv_ShangChuang);
        mIvTp = (ImageView) view.findViewById(R.id.iv_tp);
        mBtXiaZai = (Button) view.findViewById(R.id.bt_XiaZai);
        mBtXiaZai.setOnClickListener(this);
        mPb = (ProgressBar) view.findViewById(R.id.pb);
        mTvXiaZai = (TextView) view.findViewById(R.id.tv_XiaZai);
        mIvTt = (ImageView) view.findViewById(R.id.iv_tt);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_ShangChuang:
                initData();
                break;
            case R.id.bt_XiaZai:
                initData2();
                break;
        }
    }
    private static final String TAG = "Main2Activity";

    @Subscribe( threadMode = ThreadMode.MAIN)
    public void onMyEventBus(String eventBus) {
//        final int a = eventBus.a;

        mPb.setProgress(Integer.parseInt(eventBus));
        mTvXiaZai.setText("下载进度:" + eventBus + "%");
        Log.d(TAG, "run: " + "下载进度:" + eventBus + "%");
        if (mPb.getProgress()==mPb.getMax()){
            File file = new File("/sdcard/Pictures/0858c600-1b34-41c1-a2ff-f67cdc376558.png");
            Glide.with(this).load(file).into(mIvTt);
        }

    }

    private void initData2() {
        getActivity().startService(new Intent(getContext(), Fuwu.class));
        //动态权限
        startData();

    }
    private void startData() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){
            getActivity().startService(new Intent(getContext(), Fuwu.class));
        }else{
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100&&grantResults!=null&&grantResults[0]== PackageManager.PERMISSION_DENIED){
            getActivity().startService(new Intent(getContext(), Fuwu.class));
        }
    }


    //上传

        private void initData() {
            File file = new File("/sdcard/Pictures/0858c600-1b34-41c1-a2ff-f67cdc376558.png");
            if (file.exists()){
                Log.d(TAG, "initData: 已存在");
            }
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
            MultipartBody multipartBody = new MultipartBody.Builder()
                    .addFormDataPart("key", "1810A")
                    .addFormDataPart("file", file.getName(),requestBody )
                    .setType(MultipartBody.FORM)
                    .build();
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .post(multipartBody)
                    .url("http://yun918.cn/study/public/file_upload.php")
                    .build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d(TAG, "onFailure: "+e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String result = response.body().string();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTvShangChuang.setText(result);
                            Log.d(TAG, "run: "+result);
                            try {
                                JSONObject jsonObject = new JSONObject(result);
                                JSONObject data = jsonObject.getJSONObject("data");
                                String url = data.optString("url");
                                Glide.with(getActivity()).load(url).into(mIvTp);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }

    @Override
    public void onStop() {
        super.onStop();
        //解除EventBus
        EventBus.getDefault().unregister(this);
    }
}
