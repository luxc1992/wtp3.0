package com.wantupai.app.model.api;

import com.wantupai.app.model.bean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;


public interface HomeApi {

    //新闻列表内容
    @GET("T1348647909107/0-20.html")
    Flowable<HomeBean> getHome();
}
