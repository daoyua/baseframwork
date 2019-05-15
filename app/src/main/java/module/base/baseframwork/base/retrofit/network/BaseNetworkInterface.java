package module.base.baseframwork.base.retrofit.network;

import io.reactivex.Observable;
import module.base.baseframwork.base.response.BaseResponse;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface BaseNetworkInterface extends BaseInterface{
    @GET
    Observable<BaseResponse> getHost(@Url String url);
}
