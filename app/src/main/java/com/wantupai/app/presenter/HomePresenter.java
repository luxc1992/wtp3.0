package com.wantupai.app.presenter;


import com.wantupai.app.base.BasePresenter;
import com.wantupai.app.base.interfaces.contrenct.HomeContract;
import com.wantupai.app.component.CommonSubscriber;
import com.wantupai.app.model.bean.HomeBean;
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
        addSubscribe(HttpManager.getNewsApis().getHome()
                .compose(RxUtils.<HomeBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBean>(mView) {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        mView.showHomeChannel(homeBean.getT1348647909107());
                    }
                })
        );
    }
}
