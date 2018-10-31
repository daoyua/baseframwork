package module.base.baseframwork.test.test_dagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class AcitivityMoudle {
    @Provides
    public int provideActivityTest() {
        return 1234567890;
    }
}
