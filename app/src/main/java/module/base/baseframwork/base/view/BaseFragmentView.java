package module.base.baseframwork.base.view;

import android.os.Bundle;

import module.base.baseframwork.base.fragment.BaseFragment;

public interface BaseFragmentView extends BaseView {
   public Bundle getBundle();
    public BaseFragment getFragment();
}
