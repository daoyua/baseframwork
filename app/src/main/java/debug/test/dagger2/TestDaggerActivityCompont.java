package debug.test.dagger2;

import dagger.Component;
import debug.test.TestDaggerActivity;

@Component(modules = BaseActivityModuleDagger.class)
public interface TestDaggerActivityCompont {

    void inject(TestDaggerActivity testDaggerActivity);
}
