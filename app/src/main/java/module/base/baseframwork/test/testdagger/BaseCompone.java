package module.base.baseframwork.test.testdagger;

import dagger.Component;
import module.base.baseframwork.test.TestDaggerActivity;

@Component(modules = PresenterModule.class)
public interface BaseCompone {

   void inject(TestDaggerActivity testDaggerActivity);
}
