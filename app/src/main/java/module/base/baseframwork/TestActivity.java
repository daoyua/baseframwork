package module.base.baseframwork;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import module.base.baseframwork.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }
}