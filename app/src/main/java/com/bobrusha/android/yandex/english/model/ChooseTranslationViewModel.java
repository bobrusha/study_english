package com.bobrusha.android.yandex.english.model;

import android.databinding.ObservableField;
import android.support.annotation.Nullable;
import android.transition.Visibility;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Andrey on 23.07.2016.
 */
public class ChooseTranslationViewModel {

    private static final int max = 10;
    private WordStore wordStore;
    public final ObservableField<ChooseTranslationOneSlice> chooseTranslationOneSlice = new ObservableField<>();

    public final ObservableField<Integer> count = new ObservableField<>(0);

    public ChooseTranslationViewModel(WordStore wordStore) {
        this.wordStore = wordStore;
    }
    private ArrayList<Word> usedWords = new ArrayList<>();
    private HashMap<Word, Boolean> userResults = new HashMap<>();
    @Nullable
    public void createSlice() {
        if (count.get() < max) {
            count.set(count.get() + 1);
            ChooseTranslationOneSlice value = new ChooseTranslationOneSlice();
            Word randomWord = wordStore.getRandomWord();
            value.word = randomWord;
            usedWords.add(randomWord);
            value.translation = wordStore.getTraslation(randomWord);
            if (randomWord.getLang() == Lang.En) {
                value.first = wordStore.getRandomRusWord();
                value.second = wordStore.getRandomRusWord();
                value.third = value.translation;
                value.forth = wordStore.getRandomRusWord();
            }
            else {
                value.first = wordStore.getRandomEnWord();
                value.second = wordStore.getRandomEnWord();
                value.third = value.translation;
                value.forth = wordStore.getRandomEnWord();
            }
            chooseTranslationOneSlice.set(value);
        }
    }

    public ObservableField<Integer> rightVisability = new ObservableField<>(View.GONE);
    public ObservableField<Integer> nonRightVisability = new ObservableField<>(View.GONE);

    public boolean checkCurrentWord(Word word) {
        Word currentWord = chooseTranslationOneSlice.get().word;
        Word translation = wordStore.getTraslation(currentWord);
        final boolean equals = translation.getText().equals(word.getText());
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (equals) {
                    rightVisability.set(View.VISIBLE);
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        rightVisability.set(View.GONE);
                    }
                }
                else {
                    nonRightVisability.set(View.VISIBLE);
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        nonRightVisability.set(View.GONE);
                    }
                }
            }
        }).start();

        userResults.put(currentWord, equals);
        return equals;
    }

    public ArrayList<Word> getUsedWords() {
        return usedWords;
    }

    public boolean isEnd() {
        return count.get() == max;
    }
}
