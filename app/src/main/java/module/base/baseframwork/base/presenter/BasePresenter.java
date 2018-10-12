package module.base.baseframwork.base.presenter;

import android.os.Bundle;

import io.reactivex.disposables.CompositeDisposable;
import module.base.baseframwork.base.view.BaseView;

public abstract class BasePresenter <T extends BaseView>{

    protected T mView;
    protected CompositeDisposable myCompositeDisposable;
    /**
     * 绑定View
     */
    public void onAttch(T view) {
        this.mView = view;
        myCompositeDisposable=new CompositeDisposable();
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
    public abstract void addObservableToCompositeDisposable(Bundle outState);
}
