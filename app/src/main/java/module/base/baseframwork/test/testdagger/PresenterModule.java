package module.base.baseframwork.test.testdagger;

import dagger.Module;
import dagger.Provides;
import module.base.baseframwork.test.mvp.presenter.TestPresenter;

@Module
public class PresenterModule {

    @Provides
   public TestPresenter getPresenter(){
       TestPresenter presenter=new TestPresenter();
       return presenter;
   }
}
