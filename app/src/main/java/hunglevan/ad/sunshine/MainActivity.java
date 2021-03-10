package hunglevan.ad.sunshine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapIdToView();
        setToolbar();
        setFragment();

    }

    private void mapIdToView() {
        toolbar = findViewById(R.id.toolbar);
    }


    private void setToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.customToolbar);
    }

    private void setFragment() {
        FragmentManager fm = getSupportFragmentManager();
        mainFragment = new MainFragment();
        fm.beginTransaction().add(R.id.frRecycle, mainFragment).commitNow();
    }
}

