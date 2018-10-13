package module.base.baseframwork;

import android.os.Bundle;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import module.base.baseframwork.base.activity.BaseActivity;
import module.base.baseframwork.base.activity.BaseActivityMVP;
import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.retrofit.CompositeDisposableInter;
import module.base.baseframwork.base.retrofit.RetrofitFactory;
import module.base.baseframwork.base.retrofit.SimpleSubscriber;
import module.base.baseframwork.base.view.BaseView;
import retrofit2.Retrofit;

public class TestActivity extends BaseActivityMVP<BasePresenter<BaseView>> {
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseActivity getActivity() {
        return null;
    }

    @Override
    public int intiLayout() {
        return 0;
    }

    @Override
    public int initData() {
        return 0;
    }

    @Override
    protected BasePresenter<BaseView> initPresenter() {
        return new BasePresenter<BaseView>() {
            @Override
            public void onCreate() {

            }

            @Override
            public void onSaveInstanceState(Bundle outState) {

            }


        };
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

    }


    public void getdata() {
        retrofit = RetrofitFactory.getRetrofit();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable disposable;
        // 3 创建接口的代理对象
//        MyRetrofitFactory.compose(RetrofitFactory.getRetrofit().create(GetUser.class).getUserPostRxandroid()).subscribe();
        GetUser getUser = retrofit.create(GetUser.class);
        getUser.getUserPostRxandroid("绵阳市aa")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleSubscriber<UserResponse>() {


                    @Override
                    public CompositeDisposableInter initCompositeDisposableInter() {
                        return new CompositeDisposableInter() {
                            @Override
                            public void setDidposable(Disposable disposable) {

                            }
                        };
                    }

                    @Override
                    public void call(UserResponse userResponse) {

                    }
                });

    }

    @Override
    public void isNightMode(boolean isNight) {

    }
}
