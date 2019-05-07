package com.wantupai.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wantupai.app.base.interfaces.IBaseView;
import com.wantupai.app.base.interfaces.IPersenter;
import com.wantupai.app.utils.SystemUtils;


public abstract class BaseActivity<V extends IBaseView,P extends IPersenter> extends AppCompatActivity implements IBaseView {

    protected AppCompatActivity activityCompat;
    protected Context context;

    //对应的P层
    protected P presenter;

    //butterknife引用类
    //private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        activityCompat = this;
        context = this;
        if(!SystemUtils.checkNetWork()){
            showNetWorkErorr();
        }else{
            //unbinder = ButterKnife.bind(this);
            initView();
            presenter = createPresenter();
            presenter.attachView(this);
            initData();
        }
    }

    //获取布局的ID
    protected abstract int getLayout();

    //创建P层
    protected abstract P createPresenter();

    //初始化界面
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter != null){
            presenter.attachView(this);
        }
    }

    @Override
    public void showDataError(String tips) {

    }

    @Override
    public void showNetWorkErorr() {

    }

    @Override
    public void showLoading() {

    }

    //释放界面
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            presenter.detachView();
        }
    }
}
