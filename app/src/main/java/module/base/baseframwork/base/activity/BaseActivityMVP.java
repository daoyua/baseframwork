package module.base.baseframwork.base.activity;

import android.os.Bundle;

import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.view.BaseView;

public abstract class BaseActivityMVP <T extends BasePresenter> extends BaseActivity implements BaseView {

    /***基础的presenter**/
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建Presenter
        mPresenter = initPresenter();
        //类似fragment的与view进行绑定.拿到引用
        mPresenter.onAttch(this);
        //初始化acitivity,
        onCreateActivity(savedInstanceState);
        //初始化Presenter
        mPresenter.onCreate();
        initData();
    }
    public abstract void initData();
    protected abstract T initPresenter();
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }



    /**
     * 子类必须实现,并初始化Activity,比如setContentView()
     */
    protected abstract void onCreateActivity(Bundle savedInstanceState);


}
