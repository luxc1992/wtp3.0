package com.wantupai.app.presenter;


import android.util.Log;

import com.wantupai.app.base.BasePresenter;
import com.wantupai.app.base.interfaces.contrenct.HomeContract;
import com.wantupai.app.component.CommonSubscriber;
import com.wantupai.app.model.bean.HomeBean;
import com.wantupai.app.model.bean.TabBean;
import com.wantupai.app.model.http.HttpManager;
import com.wantupai.app.utils.RxUtils;


public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void attachView(HomeContract.View view) {
        super.attachView(view);
    }


    //刷新新闻列表数据
    @Override
    public void HomeList() {
        addSubscribe(HttpManager.getNewsApis().getTabList()
                .compose(RxUtils.<TabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TabBean>(mView) {
                    @Override
                    public void onNext(TabBean homeBean) {
                        Log.e("sss", "onNext: "+homeBean.toString() );
                    }
                })
        );
    }
}
