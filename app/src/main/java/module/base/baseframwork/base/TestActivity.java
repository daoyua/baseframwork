package module.base.baseframwork.base;

import androidx.appcompat.app.AppCompatActivity;
import module.base.baseframwork.R;

import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
