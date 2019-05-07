package com.wantupai.app.constants;

import android.os.Environment;

import com.wantupai.app.apps.MyApp;

import java.io.File;

/**
 * 常量类,全局变量
 */
public class Constant {

    //网络接口基础地址
    public static final String BASE_URL = "http://c.m.163.com/nc/article/headline/";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "fristth";

    public static final String FILE_PROVIDER_AUTHORITY="com.codeest.geeknews.fileprovider";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";


}
