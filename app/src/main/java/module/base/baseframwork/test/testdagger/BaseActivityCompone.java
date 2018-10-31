package module.base.baseframwork.test.testdagger;

import dagger.Component;
import module.base.baseframwork.base.presenter.BasePresenterDagger2;

@Component(modules = BasePresenterModule.class)
public interface BaseActivityCompone {

   void inject(BasePresenterDagger2 basePresenterDagger2);
}
