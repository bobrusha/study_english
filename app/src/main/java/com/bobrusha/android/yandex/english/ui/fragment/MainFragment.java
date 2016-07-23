package com.bobrusha.android.yandex.english.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bobrusha.android.yandex.english.R;
import com.bobrusha.android.yandex.english.TrainingAdapter;

import java.util.Arrays;

/**
 * Created by Aleksandra on 23/07/16.
 */
public class MainFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_main, container, false);

        String[] menu = getResources().getStringArray(R.array.main_menu);

        recyclerView = (RecyclerView) v.findViewById(R.id.rw_trainings);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TrainingAdapter(Arrays.asList(menu)));



        return v;
    }
}
