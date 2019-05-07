package com.wantupai.app.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.wantupai.app.base.interfaces.IBaseView;
import com.wantupai.app.base.interfaces.IPersenter;
import com.wantupai.app.utils.SystemUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends IPersenter> extends Fragment implements IBaseView {

    protected Context context;

    protected P presenter;

    private Unbinder unbinder;

    private Dialog mLoading;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(presenter != null && isVisibleToUser){
            initData();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        unbinder = ButterKnife.bind(this,view);
        if(!SystemUtils.checkNetWork()){
            showNetWorkErorr();
        }else{
            initView(view);
            presenter = createPresenter();
            presenter.attachView(this);
            initData();
        }
    }

    protected abstract int getLayout();

    protected abstract P createPresenter();

    protected abstract void initView(View v);

    protected abstract void initData();

    @Override
    public void showDataError(String tips) {

    }

    @Override
    public void showNetWorkErorr() {

    }

    @Override
    public void showLoading() {
        if (mLoading != null && !mLoading.isShowing())mLoading.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(presenter != null){
            presenter.attachView(this);
        }
    }
}
