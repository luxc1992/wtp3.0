package com.wantupai.app.model.http;


import com.wantupai.app.constants.Constant;
import com.wantupai.app.model.api.HomeApi;
import com.wantupai.app.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * http数据请求封装
 */
public class HttpManager {

    private static HomeApi newApis;

    //创建Retrofit对象
    private static Retrofit getRetrofit(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getOkhttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    /**
     * 创建带缓存的HttpClient对象
     * @return
     */
    private static OkHttpClient getOkhttpClient() {
        //本地缓存文件
        File file = new File(Constant.PATH_CACHE);
        //设置缓存文件的大小100M
        Cache cache = new Cache(file, 1024 * 1024 * 100);
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new Myintercepter())
                .addNetworkInterceptor(new Myintercepter())
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    //获取相关的网络接口
    private static synchronized <T> T getServerApis(String baseUrl,Class<T> tCla){
        return getRetrofit(baseUrl).create(tCla);
    }


    //获取新闻接口api
    public static HomeApi getNewsApis(){
        synchronized (HttpManager.class){
            if(newApis == null){
                synchronized (HttpManager.class){
                    newApis = getServerApis(Constant.BASE_URL,HomeApi.class);
                }
            }
        }
        return newApis;
    }


    //拦截器的实现类
    private static class Myintercepter implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if(!SystemUtils.checkNetWork()){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if(!SystemUtils.checkNetWork()){
                int maxAge = 0;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public ,max-age="+maxAge).build();
            }else{
                int maxStale = 60*60*24*28; //设置缓存数据的保存时间
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public, onlyif-cached, max-stale="+maxStale).build();
            }
        }
    }
}
