package module.base.baseframwork.test;

import module.base.baseframwork.base.BaseApplication;

public  class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
//        RetrofitFactory.setHostUrl("http://gc.ditu.aliyun.com");


    }

    @Override
    public String initHostUrl() {
        return "http://gc.ditu.aliyun.com";
    }
}
