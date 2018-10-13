package module.base.baseframwork.base.retrofit;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyNetWorkObsrvable {
    private final static ObservableTransformer transformer = new SimpleTransformer();

    /**
     * 将Observable<BaseResponse<T>>转化Observable<T>,并处理BaseResponse
     *
     * @return 返回过滤后的Observable.
     */
    @SuppressWarnings("unchecked")
    public static <T> Observable<T> compose(Observable<T> observable) {
        return observable.compose(transformer);
    }

    private static class SimpleTransformer<T> implements ObservableTransformer<T, T> {
        //这里对Observable,进行一般的通用设置.不用每次用Observable都去设置线程以及重连设置

        @Override
        public ObservableSource<T> apply(Observable<T> observable) {
            return observable.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .timeout(5, TimeUnit.SECONDS)
                    .retry(3)
//                    .subscribe()
                    ;
//                    .flatMap(new Function<BaseResponse<T>, ObservableSource<T>>() {
//                        @Override
//                        public ObservableSource<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
//                            return flatResponse(tBaseResponse);
//                        }
//                    });
        }

        /**
         * /** 处理请求结果,BaseResponse
         *
         * @param response 请求结果
         * @return 过滤处理, 返回只有data数据的Observable
         */
//        private Observable<BaseResponse<T>> flatResponse(final BaseResponse<T> response) {
//            return Observable.create(new ObservableOnSubscribe<T>() {
//                @Override
//                public void subscribe(ObservableEmitter<T> emitter) throws Exception {
////                    emitter.onNext(response.data);
//                }
//            });


//        }
    }
}





