package com.example.week2.net;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;


import com.example.week2.app.AppConstants;
import com.example.week2.base.BaseApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by $lzj on 2019/5/5.
 */
public class SystemUtil {

    /**
     * 检查WIFI是否连接
     */
    @SuppressLint("MissingPermission")
    public static boolean isWifiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo;
        wifiInfo = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return wifiInfo != null;
    }
    /**
     * 检查手机网络(4G/3G/2G)是否连接
     */
    public static boolean isMobileNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo mobileNetworkInfo = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return mobileNetworkInfo != null;
    }
    /**
     * 检查是否有可用网络
     */
    @SuppressLint("MissingPermission")
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * 保存文字到剪贴板
     * @param context
     * @param text
     */
    public static void copyToClipBoard(Context context, String text) {
        ClipData clipData = ClipData.newPlainText("url", text);
        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        manager.setPrimaryClip(clipData);
        Toast.makeText(context,"已复制到剪贴板",Toast.LENGTH_SHORT).show();
    }

    /**
     * 保存图片到本地
     * @param context
     * @param url
     * @param bitmap
     */
    public static Uri saveBitmapToFile(Context context, String url, Bitmap bitmap,
                                       View container, boolean isShare){
        String fileName = url.substring(url.lastIndexOf("/"),url.lastIndexOf(".")) + ".png";
        File fileDir = new File(AppConstants.PATH_SDCARD);
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        File imageFile = new File(fileDir,fileName);
        Uri uri = Uri.fromFile(imageFile);
        if (isShare && imageFile.exists()) {
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(context.getApplicationContext(),
                        AppConstants.FILE_PROVIDER_AUTHORITY, imageFile);
            }
            return uri;
        }
        try {
            FileOutputStream fos = new FileOutputStream(imageFile);
            boolean isCompress = bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            if (isCompress) {
                ToastUtil.showShort("保存成功n(*≧▽≦*)n");
            } else {
                ToastUtil.showShort("保存失败ヽ(≧Д≦)ノ");
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            ToastUtil.showShort("保存失败ヽ(≧Д≦)ノ");
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), imageFile.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,uri));
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context.getApplicationContext(),
                    AppConstants.FILE_PROVIDER_AUTHORITY, imageFile);
        }
        return uri;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int dp2px(float dpValue) {
        final float scale = BaseApplication.getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = BaseApplication.getApplication().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}


