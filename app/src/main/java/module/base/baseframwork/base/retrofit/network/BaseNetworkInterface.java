package module.base.baseframwork.base.retrofit.network;

import io.reactivex.Observable;
import module.base.baseframwork.base.response.BaseResponse;
import retrofit2.http.Url;

public interface BaseNetworkInterface {

    Observable<BaseResponse> getHost(@Url String url);
}
