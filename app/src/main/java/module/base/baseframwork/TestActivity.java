package module.base.baseframwork;

import androidx.appcompat.app.AppCompatActivity;
import module.base.baseframwork.base.activity.BaseActivity;
import module.base.baseframwork.base.activity.BaseActivityMVP;
import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.rxbus.Event;

import android.os.Bundle;

public class TestActivity extends BaseActivityMVP<BasePresenter> {


    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new BasePresenter() {
            @Override
            public void onCreate() {

            }

            @Override
            public void onSaveInstanceState(Bundle outState) {

            }

            @Override
            public void onEvent(Event event) {

            }
        };
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseActivity getActivity() {
        return this;
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void isNightMode(boolean isNight) {

    }
}
