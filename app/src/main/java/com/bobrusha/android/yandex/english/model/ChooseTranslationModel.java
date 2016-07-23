package com.bobrusha.android.yandex.english.model;

import android.support.annotation.Nullable;

/**
 * Created by Andrey on 23.07.2016.
 */
public class ChooseTranslationModel {
    private int count = 0;
    private static final int max = 10;
    private WordStore wordStore;

    public ChooseTranslationModel(WordStore wordStore) {
        this.wordStore = wordStore;
    }

    @Nullable
    public ChooseTranslationViewModel getNextTask() {
        while (count < max) {
            count++;
            ChooseTranslationViewModel chooseTranslationViewModel = new ChooseTranslationViewModel();
            Word randomWord = wordStore.getRandomWord();
            chooseTranslationViewModel.word = randomWord;
            chooseTranslationViewModel.translation = wordStore.getTraslation(randomWord);
            chooseTranslationViewModel.variants = new Word[] {
                    wordStore.getRandomWord(),
                    wordStore.getRandomWord(),
                    randomWord,
                    wordStore.getRandomWord(),
            };

            return chooseTranslationViewModel;
        }
        return null;
    }

    public boolean isEnd() {
        return count == max;
    }
}
