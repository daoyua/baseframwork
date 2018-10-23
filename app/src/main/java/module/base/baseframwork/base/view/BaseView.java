package module.base.baseframwork.base.view;

import android.app.Activity;

public interface BaseView {
    /**
     * 切换夜间模式
     * @param isNight 是否切换为夜间模式
     */
    void isNightMode(boolean isNight);

    /**
     * 获取activity
     * @param
     */
     Activity getContext( );
}
