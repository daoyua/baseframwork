package module.base.baseframwork.test.test_dagger2;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import dagger.Component;
import module.base.baseframwork.base.activity.BaseActivityMVP;

@Component(modules={WorkProvides.class,AcitivityMoudle.class})
public interface PeoplePlatForm {
   people getWork();

  void zhuru(people peop);
    void inject(AppCompatActivity mainActivity);
}

