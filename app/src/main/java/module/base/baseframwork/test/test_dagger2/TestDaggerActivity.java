package module.base.baseframwork.test.test_dagger2;

import module.base.baseframwork.R;
import module.base.baseframwork.base.activity.BaseActivity;
import module.base.baseframwork.base.activity.BaseActivityMVP;
import module.base.baseframwork.untils.LogUtils;

import android.os.Bundle;

import javax.inject.Inject;

public class TestDaggerActivity extends BaseActivityMVP<TestPresenter> {

    @Inject
    int abc;
    @Override
    protected TestPresenter initPresenter() {
        return new TestPresenter();
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
//        people work = DaggerPeoplePlatForm.builder().build().getWork();
        people people=new people();
        PeoplePlatForm peoplePlatForm = DaggerPeoplePlatForm.builder().build();
        peoplePlatForm.zhuru(people);
        people.doWork();
        people.doItWork();
        people.work.notWork();
        peoplePlatForm.inject(this);
        LogUtils.e(abc+"");
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
