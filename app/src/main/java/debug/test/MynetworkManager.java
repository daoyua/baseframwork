package debug.test;

import debug.test.mvp.module.GetUser;
import debug.test.mvp.module.UserResponse;
import io.reactivex.Observable;
import module.base.baseframwork.base.retrofit.MyNetWorkObsrvable;
import module.base.baseframwork.base.retrofit.network.BaseNetworkManager;

public  class MynetworkManager extends BaseNetworkManager {
//    public static Retrofit retrofit = RetrofitFactory.getRetrofit();
//    private static GetUser getUser = retrofit.create(GetUser.class);

    public static Observable<UserResponse> getData(String address) {
        GetUser getUser = retrofit.create(GetUser.class);

        Observable<UserResponse> aaa = new MyNetWorkObsrvable().compose(getUser.getUserPostRxandroid(address));
        return aaa;
    }


}
