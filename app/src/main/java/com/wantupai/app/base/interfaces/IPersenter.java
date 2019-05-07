package com.wantupai.app.base.interfaces;

public interface IPersenter<V extends IBaseView> {

    //关联view
    void attachView(V view);
    //取消关联
    void detachView();

}
