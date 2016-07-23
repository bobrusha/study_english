package com.bobrusha.android.yandex.english.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bobrusha.android.yandex.english.R;
import com.bobrusha.android.yandex.english.model.WordStore;
import com.google.android.flexbox.FlexboxLayout;

import ru.yandex.speechkit.Error;
import ru.yandex.speechkit.SpeechKit;
import ru.yandex.speechkit.Synthesis;
import ru.yandex.speechkit.Vocalizer;
import ru.yandex.speechkit.VocalizerListener;

/**
 * Created by Aleksandra on 23/07/16.
 */
public class ListenWordTrainingFragment extends Fragment implements VocalizerListener {
    private String API_KEY = "b11774cd-2d45-4391-927e-84740d49961f";

    private TextView answerField;
    private Vocalizer vocalizer;
    private WordStore wordStore;
    private String word;
    private StringBuilder letters = new StringBuilder();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SpeechKit.getInstance().configure(getContext(), API_KEY);
        wordStore = new WordStore();
        word = wordStore.getRandomEnWord().getText();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_hear_word, container, false);
        v.findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vocalizer = Vocalizer.createVocalizer(Vocalizer.Language.ENGLISH, word, true, Vocalizer.Voice.JANE);
                vocalizer.setListener(ListenWordTrainingFragment.this);
                vocalizer.start();
            }
        });

        answerField = (TextView) v.findViewById(R.id.answer_field);
        FlexboxLayout flexbox = (FlexboxLayout) v.findViewById(R.id.flexbox_letters);
        addViews(flexbox, word);

        return v;
    }

    private void addViews(FlexboxLayout flexboxLayout, String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            View letterView = LayoutInflater.from(getActivity()).inflate(R.layout.view_one_letter, flexboxLayout, false);
            TextView tv = (TextView) letterView.findViewById(R.id.letter_text_view);
            String c = "" + s.charAt(i);
            tv.setText(c);
            flexboxLayout.addView(letterView);

            letterView.setOnClickListener(new MyClickListener(c));
        }

    }

    @Override
    public void onSynthesisBegin(Vocalizer vocalizer) {

    }

    @Override
    public void onSynthesisDone(Vocalizer vocalizer, Synthesis synthesis) {

    }

    @Override
    public void onPlayingBegin(Vocalizer vocalizer) {

    }

    @Override
    public void onPlayingDone(Vocalizer vocalizer) {

    }

    @Override
    public void onVocalizerError(Vocalizer vocalizer, Error error) {

    }

    public class MyClickListener implements View.OnClickListener {
        private String letter;

        public MyClickListener(String letter) {
            this.letter = letter;
        }

        @Override
        public void onClick(View view) {
            letters.append(letter);
            if (!word.startsWith(letters.toString())) {
                letters.deleteCharAt(letters.length() - 1);
            } else {
                answerField.setText(letters.toString());
                answerField.invalidate();
            }

        }
    }
}
