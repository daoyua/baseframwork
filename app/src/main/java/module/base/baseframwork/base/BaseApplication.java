package module.base.baseframwork.base;

import android.app.Application;
import android.content.Context;

import module.base.baseframwork.untils.CrashHandler;
import module.base.baseframwork.base.retrofit.RetrofitFactory;


public abstract class BaseApplication extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化抓去异常
         * */
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        mContext = this;
        RetrofitFactory.setHostUrl(initHostUrl());

    }
    public abstract String initHostUrl();
}
