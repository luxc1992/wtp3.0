package com.wantupai.app.base.interfaces.contrenct;



import com.wantupai.app.base.interfaces.IBaseView;
import com.wantupai.app.base.interfaces.IPersenter;
import com.wantupai.app.model.bean.HomeBean;
import com.wantupai.app.model.bean.TabBean;

import java.util.List;


public interface HomeContract {

    //新闻的View层接口定义
    interface View extends IBaseView {
        //新闻内容
        void showHomeChannel(List<TabBean.DataBean> list);
    }

    //新闻的Presenter层接口定义
    interface Presenter extends IPersenter<View> {
        //获取新闻频道数据
        void HomeList();
    }
}