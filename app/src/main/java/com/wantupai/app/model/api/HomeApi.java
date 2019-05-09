package com.wantupai.app.model.api;

import com.wantupai.app.model.bean.TabBean;

import io.reactivex.Flowable;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface HomeApi {

    @Headers({"XX-Device-Type:android","XX-Api-Version:v1"})
    @POST("label")
    Flowable<TabBean> getTabList();
}
