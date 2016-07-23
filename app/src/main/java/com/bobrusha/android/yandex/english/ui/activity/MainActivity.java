package com.bobrusha.android.yandex.english.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bobrusha.android.yandex.english.R;
import com.bobrusha.android.yandex.english.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_content, new MainFragment())
                    .commit();
            ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.main_title);
            ((ImageView) findViewById(R.id.settings)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // openFragment(new SettingsFragment());
                }
            });
        }
    }


    public void openNewFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();

    }
}
