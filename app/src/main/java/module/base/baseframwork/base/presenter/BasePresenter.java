package module.base.baseframwork.base.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import module.base.baseframwork.base.rxbus.Event;
import module.base.baseframwork.base.rxbus.RxBus;
import module.base.baseframwork.base.view.BaseView;
import module.base.baseframwork.untils.LogUtils;

public abstract class BasePresenter< T extends BaseView>  {

    protected T mView;
    protected Context mActivity;

    protected CompositeDisposable myCompositeDisposable;
    /**
     * 绑定View
     */
    public void onAttch(T view) {
        this.mView = view;
        myCompositeDisposable=new CompositeDisposable();
        mActivity=this.mView.getContext();
    } /**
     * 添加ob到compo
     */
    public void addDispos(Disposable d) {
        if(d!=null&&myCompositeDisposable!=null){
            myCompositeDisposable.add(d);
        }
//        myCompositeDisposable.add(d)
    }


    /**
     * 做初始化的操作,需要在view的视图初始化完成之后才能调用
     */
    public abstract void onCreate();
    /**
     * 默认在view销毁的时候调用,解除绑定
     *在view销毁前释放presenter中的对象,资源.
     */
    public void onDestroy() {
        mView = null;

        myCompositeDisposable.dispose();
//        compositeDisposable.clear();
    }

    /**
     * 容易被回收掉时保存数据
     */
    public abstract void onSaveInstanceState(Bundle outState);


    public void openRxbus( ){

            //注册eventbus
            Disposable disposable = RxBus.getDefault().register(Event.class, new Consumer<Event>() {
                @Override
                public void accept(Event event) {
                    int eventCode = event.getCode();
                    Log.e("RxBus", event.toString());
                    switch (eventCode) {
                        case Event.EVENT_CLOSE_ALL_ACTIVITY:
                            LogUtils.e("1000:");
                            break;
                        default:
//                            LogUtils.e("no!!!!!!!!wrong");
                            Log.e("RxBus", event.toString());
                            onEvent(event);
                            break;
                    }
                }
            });
            addDispos(disposable);
            LogUtils.e("Rxbus is opened");

    }

    /**
     * 重写rxbus会传递信息
     * @param event
     */
    public abstract void onEvent(Event event);
}
