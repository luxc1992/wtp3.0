package com.wantupai.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 获取当前的时间
     * @return
     */
    public static String getCurrentDefaultDate(){
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        return dateformat.format(new Date());
    }

    /**
     * 获取当前的系统时间
     * @return yyyy年MM月dd日
     */
    public static String getCurrentDateString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return dateFormat.format(new Date());
    }

}
