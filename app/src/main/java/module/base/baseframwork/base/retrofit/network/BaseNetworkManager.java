package module.base.baseframwork.base.retrofit.network;

import android.text.TextUtils;

import io.reactivex.Observable;
import module.base.baseframwork.base.response.BaseResponse;
import module.base.baseframwork.base.retrofit.MyNetWorkObsrvable;
import module.base.baseframwork.base.retrofit.RetrofitFactory;
import module.base.baseframwork.untils.MyConfig;
import retrofit2.Retrofit;

public class BaseNetworkManager {

        public static Retrofit retrofit= RetrofitFactory.getRetrofit();

        public static Observable<BaseResponse> TestConnect(String address){
            BaseNetworkInterface baseNetworkInterface = retrofit.create(BaseNetworkInterface.class);
            if(TextUtils.isEmpty(address)){
                address= MyConfig.HOST_URL;
            }
            Observable<BaseResponse> aaa = MyNetWorkObsrvable.compose(baseNetworkInterface.getHost(address));
            return  aaa;
        }

}
