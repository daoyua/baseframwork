package module.base.baseframwork.test.test_dagger2;

import javax.inject.Inject;

import module.base.baseframwork.untils.LogUtils;

public class Work {
    WorkResponse workModule;

    //    @Inject
//    public Work( ) {
//    }
//
//
//    public void doWork() {
//            LogUtils.e("开始工作：");
//
//
//
//    }
    @Inject
    public Work(WorkResponse workModule) {
        this.workModule = workModule;
    }

    public void doWork() {
        if (workModule != null) {
            LogUtils.e("开始工作：");
        } else {
            LogUtils.e("还没有工作");
        }

    }
    public void notWork(){
        LogUtils.e("放假不上班了");
    }

}
