package module.base.baseframwork.base;

import android.app.Application;

import module.base.baseframwork.base.retrofit.RetrofitFactory;


public abstract class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitFactory.setHostUrl(initHostUrl());
    }
    public abstract String initHostUrl();
}
