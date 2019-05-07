package com.wantupai.app.base.interfaces;

public interface IBaseView {

    //显示数据加载错误
    void showDataError(String tips);

    //显示无网络状态
    void showNetWorkErorr();

    //显示界面加载loading
    void showLoading();

}
