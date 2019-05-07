package com.wantupai.app.component;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 图片加载类
 */
public class ImageLoader {

    //加载图片
    public static void load(Context context, String url, ImageView iv){
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.RESULT).into(iv);
    }

    //加载图片，activity移除以后停止图片加载
    public static void load(Activity activity,String url,ImageView iv){
        if(!activity.isDestroyed()){
            Glide.with(activity).load(url).diskCacheStrategy(DiskCacheStrategy.RESULT).into(iv);
        }
    }

    //加载网络图片 不缓存
    public static void loadAll(Context context,String url,ImageView iv){
        Glide.with(context).load(url).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(iv);
    }

    //加载网络图片 不缓存
    public static void loadAll(Activity activity,String url,ImageView iv){
        if(!activity.isDestroyed()){
            Glide.with(activity).load(url).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(iv);
        }
    }
}
