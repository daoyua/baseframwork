package module.base.baseframwork.test.dagger2;

import dagger.Module;
import dagger.Provides;
import module.base.baseframwork.test.mvp.presenter.TestPresenter;

@Module
public class BaseActivityModuleDagger {


    @Provides
    public TestPresenter getPresenter() {
        return new TestPresenter();
    }
}
