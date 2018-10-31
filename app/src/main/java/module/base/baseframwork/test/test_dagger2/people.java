package module.base.baseframwork.test.test_dagger2;

import javax.inject.Inject;

public class people {
    @Inject
    Work work;

    @Inject
    ItWork itwork;

    @Inject
    public people() {

    }

    public void doWork() {
        work.doWork();

    }

    public void doItWork() {
        itwork.doWork();
    }
}
