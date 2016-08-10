package com.bobrusha.android.yandex.english.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bobrusha.android.yandex.english.R;
import com.bobrusha.android.yandex.english.databinding.FragmentChooseTranslationBinding;
import com.bobrusha.android.yandex.english.model.ChooseTranslationOneSlice;
import com.bobrusha.android.yandex.english.model.ChooseTranslationViewModel;
import com.bobrusha.android.yandex.english.model.Word;
import com.bobrusha.android.yandex.english.model.WordStore;

/**
 * Created by Andrey on 23.07.2016.
 */
public class ChooseTranslationFragment extends Fragment {

    // Переменные в snake_case не пишутся. Рекомендую поглядеть и запомнить https://google.github.io/styleguide/javaguide.html
    private RelativeLayout rel_layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Запоминать view при retain instance флаге - грубая ошибка. Фрагмент вообще не имеет права удерживать вьюхи после
        // вызова onDestroyView. В данному же случае фрагмент будет удерживать view, а следовательно и context/activity.
        // При изменении конфигурации старая активити должна будет уничтожиться, но не сможет, так как существует ссылка на нее.
        // Если фрагмент тут же вернется (так как FragmentManager восстановил состояние), вызовется onCreateView, и ссылка
        // перезатрется - только тогда старая активити отпустится. На это вы не можете полагаться.
        setRetainInstance(true);
    }

    // При AppCompat активити она сама подменяет ряд стандартных виджетов на совместимые версии, так что
    // совершенно необязательно в layout и в коде явно на них подвязываться.
    // Если интересно, как он это делает, рекомендую ознакомиться https://medium.com/@chrisbanes/appcompat-v23-2-age-of-the-vectors-91cbafa87c88#.f86ef5pit
    // а потом лезть в исходник :)
    private AppCompatButton firstVariantButton;
    private AppCompatButton secondVariantButton;
    private AppCompatButton thVariantButton;
    private AppCompatButton forthVariantButton;
    private AppCompatButton skip_btn;
    private AppCompatButton close_btn;

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
        skip_btn = (AppCompatButton) root.findViewById(R.id.skip_btn);
        close_btn = (AppCompatButton) root.findViewById(R.id.close_btn);
        rel_layout = (RelativeLayout) root.findViewById(R.id.rel_layout);

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
                boolean right = chooseTranslationViewModel.checkCurrentWord(choosedWord);
                if (chooseTranslationViewModel.isEnd()) {
                    backToMainFragment();
                }
                chooseTranslationViewModel.createSlice();

            }


        };

        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseTranslationViewModel.createSlice();
            }
        });

        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMainFragment();
            }
        });


        firstVariantButton.setOnClickListener(buttonListener);
        secondVariantButton.setOnClickListener(buttonListener);
        thVariantButton.setOnClickListener(buttonListener);
        forthVariantButton.setOnClickListener(buttonListener);
        return root;
    }
    private void backToMainFragment() {
        FragmentManager fm = getActivity()
                .getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentByTag(MainFragment.class.getName());
        fm.beginTransaction().replace(R.id.fragment_content, mainFragment).commit();
    }

}
