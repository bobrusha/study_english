package com.bobrusha.android.yandex.english.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bobrusha.android.yandex.english.R;
import com.bobrusha.android.yandex.english.ui.activity.MainActivity;

/**
 * Created by Aleksandra on 23/07/16.
 */
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_main, container, false);

        v.findViewById(R.id.option_choose_translation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).openNewFragment(new ChooseTranslationFragment());
            }
        });
        return v;
    }


}
