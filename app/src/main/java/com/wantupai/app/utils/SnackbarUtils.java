package com.wantupai.app.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

public class SnackbarUtils {

    //显示长时间提示信息
    void showLongTips(View view,String tips){
        Snackbar.make(view,tips,Snackbar.LENGTH_LONG).show();
    }

    //显示短时间提示信息
    void showShortTips(View view,String tips){
        Snackbar.make(view,tips,Snackbar.LENGTH_SHORT).show();

    }
}
