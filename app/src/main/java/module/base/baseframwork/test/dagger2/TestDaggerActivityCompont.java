package module.base.baseframwork.test.dagger2;

import dagger.Component;
import module.base.baseframwork.test.TestDaggerActivity;

@Component(modules = BaseActivityModuleDagger.class)
public interface TestDaggerActivityCompont {

    void inject(TestDaggerActivity testDaggerActivity);
}
