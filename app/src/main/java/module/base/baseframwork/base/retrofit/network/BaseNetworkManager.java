package module.base.baseframwork.base.retrofit.network;

import android.text.TextUtils;

import io.reactivex.Observable;
import module.base.baseframwork.base.response.BaseResponse;
import module.base.baseframwork.base.retrofit.MyNetWorkObsrvable;
import module.base.baseframwork.base.retrofit.RetrofitFactory;
import module.base.baseframwork.untils.MyConfig;
import retrofit2.Retrofit;

public abstract class BaseNetworkManager<T extends BaseInterface>  {

//    public abstract  Class<T> setServerClass();
//    public abstract void setServer(T t);

    public static Retrofit retrofit = RetrofitFactory.getRetrofit();
//    private  Class <T> entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    public  T dataServer=retrofit.create(entityClass);



    public Observable<BaseResponse> TestConnect(String address) {
        BaseNetworkInterface baseNetworkInterface = retrofit.create(BaseNetworkInterface.class);
        if (TextUtils.isEmpty(address)) {
            address = MyConfig.HOST_URL;
        }
        Observable<BaseResponse> aaa = MyNetWorkObsrvable.compose(baseNetworkInterface.getHost(address));
        return aaa;
    }

}
