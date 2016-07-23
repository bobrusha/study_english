package com.bobrusha.android.yandex.english.ui.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bobrusha.android.yandex.english.R;
import com.bobrusha.android.yandex.english.databinding.FragmentChooseTranslationBinding;
import com.bobrusha.android.yandex.english.model.ChooseTranslationOneSlice;
import com.bobrusha.android.yandex.english.model.ChooseTranslationViewModel;
import com.bobrusha.android.yandex.english.model.Word;
import com.bobrusha.android.yandex.english.model.WordStore;

/**
 * Created by Andrey on 23.07.2016.
 */
public class ChooseTranslationFragment extends Fragment
{

    private AppCompatButton firstVariantButton;
    private AppCompatButton secondVariantButton;
    private AppCompatButton thVariantButton;
    private AppCompatButton forthVariantButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentChooseTranslationBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_translation,container, false);
        final ChooseTranslationViewModel chooseTranslationViewModel = new ChooseTranslationViewModel(new WordStore());
        chooseTranslationViewModel.createSlice();

        binding.setChooseTranslationViewModel(chooseTranslationViewModel);
        View root = binding.getRoot();
        firstVariantButton = (AppCompatButton) root.findViewById(R.id.firstVariantButton);
        secondVariantButton = (AppCompatButton) root.findViewById(R.id.secondVariantButton);
        thVariantButton = (AppCompatButton) root.findViewById(R.id.thVariantButton);
        forthVariantButton = (AppCompatButton) root.findViewById(R.id.forthVariantButton);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseTranslationOneSlice chooseTranslationOneSlice = chooseTranslationViewModel.chooseTranslationOneSlice.get();
                Word choosedWord = null;

                if (firstVariantButton == view) {
                    choosedWord = chooseTranslationOneSlice.first;
                } else if (secondVariantButton == view) {
                    choosedWord =  chooseTranslationOneSlice.second;
                } else if (thVariantButton == view) {
                    choosedWord =  chooseTranslationOneSlice.third;
                } else if (forthVariantButton == view) {
                    choosedWord =  chooseTranslationOneSlice.forth;
                }
                chooseTranslationViewModel.checkCurrentWord(choosedWord);
                chooseTranslationViewModel.createSlice();
            }
        };
        firstVariantButton.setOnClickListener(buttonListener);
        secondVariantButton.setOnClickListener(buttonListener);
        thVariantButton.setOnClickListener(buttonListener);
        forthVariantButton.setOnClickListener(buttonListener);
        return root;
    }


}
