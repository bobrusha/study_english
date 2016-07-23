package com.bobrusha.android.yandex.english.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bobrusha.android.yandex.english.R;
import com.bobrusha.android.yandex.english.ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_content, new MainFragment())
                    .commit();
        }
    }
}
