package com.bobrusha.android.yandex.english.model;

import android.databinding.ObservableField;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Dictionary;
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
            value.first = wordStore.getRandomWord();
            value.second = wordStore.getRandomWord();
            value.third = randomWord;
            value.forth = wordStore.getRandomWord();
            chooseTranslationOneSlice.set(value);
        }
    }

    public void checkCurrentWord(Word word) {
        Word translation = wordStore.getTraslation(chooseTranslationOneSlice.get().word);

        if (translation.equals(word)) {
            userResults.put(word, true);
        }
        else
        {
            userResults.put(word, false);
        }
    }

    public ArrayList<Word> getUsedWords() {
        return usedWords;
    }

    public boolean isEnd() {
        return count.get() == max;
    }
}
