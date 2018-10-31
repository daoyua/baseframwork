package module.base.baseframwork.test.testdagger;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @Inject
protected T mView;
 @Inject
 protected Context mActivity;
 @Inject
 protected CompositeDisposable myCompositeDisposable;
 */
@Module
public class BasePresenterModule {

    @Provides
   public CompositeDisposable getPresenter(){
//        presenter=new TestPresenter();
       return new CompositeDisposable();
   }

}
