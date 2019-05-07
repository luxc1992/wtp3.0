package com.wantupai.app.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.wantupai.app.apps.MyApp;


public class SystemUtils {

    /**
     * 检查是否有网络
     * @return
     */
    public static boolean checkNetWork(){
        ConnectivityManager manager = (ConnectivityManager) MyApp.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo() != null;
    }

    /**
     * 当前是否是wifi链接
     * @return
     */
    public static boolean isWifiConnected(){
        ConnectivityManager manager = (ConnectivityManager) MyApp.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return info != null;
    }

    /**
     * 检查手机（4,3,2）G是否链接
     */
    public static boolean isMobileNetworkConnected(){
        ConnectivityManager manager = (ConnectivityManager) MyApp.app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return info != null;
    }



}
