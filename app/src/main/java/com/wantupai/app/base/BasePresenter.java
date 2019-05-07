package com.wantupai.app.base;

import com.wantupai.app.base.interfaces.IBaseView;
import com.wantupai.app.base.interfaces.IPersenter;
import com.wantupai.app.component.RxBus;

import java.lang.ref.WeakReference;
import java.util.function.Consumer;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class BasePresenter<V extends IBaseView> implements IPersenter<V> {

    //当前的View
    protected V mView;
    private WeakReference<V> weakReference;

    //rxjava数据加载相关 (处理rxjava背压式产生的内存泄漏)m层
    protected CompositeDisposable compositeDisposable;


    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
        this.mView = weakReference.get();
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    //解绑观察者和被观察者
    protected void unSubscribe(){
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }

    //添加观察者和被观察者的操作类
    protected void addSubscribe(Disposable disposable){
        if(compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }

    //添加带事件类型的观察者和被观察者
    protected <E> void addRxBusSubsribe(Class<E> eventType, Consumer<E> consumer){
        if(compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxBus.getDefault().toDefaultFlowable(eventType, (io.reactivex.functions.Consumer<E>) consumer));
    }

}
