package module.base.baseframwork.test;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import module.base.baseframwork.R;
import module.base.baseframwork.base.activity.BaseActivity;
import module.base.baseframwork.base.activity.BaseActivityDagger2;
import module.base.baseframwork.base.rxbus.Event;
import module.base.baseframwork.base.rxbus.RxBus;
import module.base.baseframwork.test.mvp.presenter.TestPresenter;
import module.base.baseframwork.test.testdagger.DaggerBaseCompone;
import module.base.baseframwork.untils.LogUtils;

//public class TestDaggerActivity extends BaseActivityMVP<TestPresenter> {
public class TestDaggerActivity extends BaseActivityDagger2<TestPresenter> {

//    @Override
//    protected TestPresenter initPresenter() {
//        return new TestPresenter();
//    }


    @Override
    protected void initPresenter() {
//           return new TestPresenter();
        DaggerBaseCompone.builder().build().inject(this);
//           return mPresenter;
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
//        people work = DaggerPeoplePlatForm.builder().build().getWork();
//        people people=new people();
//        PeopleComponent peoplePlatForm = DaggerPeoplePlatForm.builder().build();
//        peoplePlatForm.zhuru(people);
//        people.doWork();
//        people.doItWork();
//        people.work.notWork();
//        peoplePlatForm.inject(this);
//        LogUtils.e(abc+"");
        mPresenter.getdata();
        mPresenter.openRxbus();
        RxBus.getDefault().post(new Event(10001, LogUtils.getThreadName()+"aaaaaaaaaaaaaaa"));
        RxBus.getDefault().post(new Event(1000,LogUtils.getThreadName()+"bbbbb"));

    }
    public void getPermissions(FragmentActivity activity){
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
