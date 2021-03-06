package debug.test.mvp.presenter;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import debug.test.MynetworkManager;
import debug.test.mvp.module.UserResponse;
import debug.test.mvp.view.TestView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import module.base.baseframwork.base.presenter.BasePresenter;
import module.base.baseframwork.base.retrofit.CompositeDisposableInter;
import module.base.baseframwork.base.retrofit.SimpleSubscriber;
import module.base.baseframwork.base.rxbus.Event;
import module.base.baseframwork.untils.LogUtils;

public class TestPresenter extends BasePresenter<TestView> {
    @Override
    public void onCreate() {
//        getdata();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onEvent(Event event) {
        LogUtils.e("data: " + event.getData().toString());
    }
    public void getdata() {

        // 3 创建接口的代理对象
        MynetworkManager.getData("绵阳市").filter(new Predicate<UserResponse>() {
            @Override
            public boolean test(UserResponse userResponse) throws Exception {
                return userResponse.getCityName().length() > 2;//过滤长度大于2的才通过
            }
        }).throttleFirst(2, TimeUnit.SECONDS)//只有第一次点击有效
                .debounce(1000, TimeUnit.SECONDS)
                .subscribe(new SimpleSubscriber<UserResponse>() {
                    @Override
                    public CompositeDisposableInter initCompositeDisposableInter() {
                        return new CompositeDisposableInter() {
                            @Override
                            public void setDidposable(Disposable disposable) {
                                myCompositeDisposable.add(disposable);

                            }
                        };
                    }

                    @Override
                    public void call(UserResponse userResponse) {
                        LogUtils.e(userResponse.toString());
                    }
                });

    }
/**
 * 两种body的形式都可以
 */
//    public void getServerData(){
//        PartsModle partsModle = new PartsModle();
//        partsModle.setId(1);
//        Gson gson = new Gson();
//        String jsons = gson.toJson(partsModle);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsons.toString());
//        retrofit.create(GetServer.class).getUserPost(partsModle).subscribe(new SimpleSubscriber<PartsModle>() {
//            @Override
//            public CompositeDisposableInter initCompositeDisposableInter() {
//                return new CompositeDisposableInter() {
//                    @Override
//                    public void setDidposable(Disposable disposable) {
////                        disposable.dispose();
//                    }
//                };
//            }
//
//            @Override
//            public void call(PartsModle partsModle) {
//                LogUtils.e("返回结果",partsModle.toString());
//            }
//
//
//        });
//    }
//    public void getServerDataJson(){
//        PartsModle partsModle = new PartsModle();
//        partsModle.setId(1);
//        Gson gson = new Gson();
//        String jsons = gson.toJson(partsModle);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsons.toString());
//        retrofit.create(GetServer.class).getUserPost(requestBody).subscribe(new SimpleSubscriber<PartsModle>() {
//            @Override
//            public CompositeDisposableInter initCompositeDisposableInter() {
//                return new CompositeDisposableInter() {
//                    @Override
//                    public void setDidposable(Disposable disposable) {
////                        disposable.dispose();
//                    }
//                };
//            }
//
//            @Override
//            public void call(PartsModle partsModle) {
//                LogUtils.e("返回结果",partsModle.toString());
//            }
//
//
//        });
//    }
}
