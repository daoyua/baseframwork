package module.base.baseframwork.test;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import module.base.baseframwork.R;
import module.base.baseframwork.base.activity.BaseActivityMVP;
import module.base.baseframwork.test.mvp.presenter.TestPresenter;

public class TestDaggerActivity extends BaseActivityMVP<TestPresenter> {
//public class TestDaggerActivity extends BaseActivityDagger<TestPresenter> {

    @Override
    protected TestPresenter initPresenter() {

        return new TestPresenter();
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        mPresenter.getdata();
//        mPresenter.openRxbus();
//        RxBus.getDefault().post(new Event(10001, LogUtils.getThreadName()+"aaaaaaaaaaaaaaa"));
//        RxBus.getDefault().post(new Event(1000,LogUtils.getThreadName()+"bbbbb"));

    }

    public void getPermissions(FragmentActivity activity) {
//        RxPermissions rxPermissions=new RxPermissions(activity);
//        RxView.clicks(findViewById(R.id.floading_button))
//                .compose(rxPermissions.ensure(Manifest.permission.CAMERA,Manifest.permission.READ_PHONE_STATE))
//                .subscribe(granted -> {
//                    // R.id.enableCamera has been clicked
//                    LogUtils.e(LogUtils.getThreadName()+"权限申请");
//                });
    }

    @Override
    protected void initView() {

    }


    @Override
    public int intiLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void isNightMode(boolean isNight) {

    }
}
