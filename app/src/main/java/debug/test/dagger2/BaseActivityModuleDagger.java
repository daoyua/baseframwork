package debug.test.dagger2;

import dagger.Module;
import dagger.Provides;
import debug.test.mvp.presenter.TestPresenter;

@Module
public class BaseActivityModuleDagger {


    @Provides
    public TestPresenter getPresenter() {
        return new TestPresenter();
    }
}
