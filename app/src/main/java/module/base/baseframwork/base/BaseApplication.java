package module.base.baseframwork.base;

import android.app.Application;
import android.content.Context;

import module.base.baseframwork.base.retrofit.RetrofitFactory;
import module.base.baseframwork.untils.CrashHandler;
import module.base.baseframwork.untils.MyConfig;


public abstract class BaseApplication extends Application {
    public static Context mContext;
    CrashHandler crashHandler;
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化抓去异常
         * */
         crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());


        mContext = this;
        MyConfig.HOST_URL=initHostUrl();
        RetrofitFactory.setHostUrl(MyConfig.HOST_URL);


    }
    public abstract String initHostUrl();
}
