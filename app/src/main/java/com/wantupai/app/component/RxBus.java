package com.wantupai.app.component;


import com.wantupai.app.utils.RxUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * 消息管理
 */
public class RxBus {

    //消息管理类
    private final FlowableProcessor<Object> bus;

    private static List<Object> list = new ArrayList<>();

    private RxBus(){
        //通过线程安全创建消息管理类
        bus = PublishProcessor.create().toSerialized();
    }

    //获取RxBus类
    public static RxBus getDefault(){
        return RxBusHelper.instance;
    }

    //创建静态的内部类
    private static class RxBusHelper{
        private static final RxBus instance = new RxBus();
    }

    //提供一个发送时间的post方法
    public void post(Object object){
        bus.onNext(object);
    }

    //根据传入的eventType获取特定的被观察者
    public <T> Flowable<T> toFlowable(Class<T> eventType){
        return bus.ofType(eventType);
    }

    //默认的订阅观察者和被观察者
    public <T> Disposable toDefaultFlowable(Class<T> eventType, Consumer<T> consumer){
        return bus.ofType(eventType).compose(RxUtils.<T>rxScheduler()).subscribe(consumer);
    }

}
