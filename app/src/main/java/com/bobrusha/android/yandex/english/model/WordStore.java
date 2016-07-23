package com.bobrusha.android.yandex.english.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Andrey on 23.07.2016.
 */
//Repository
public class WordStore {

    private ArrayList<Word> allWords;
    private final Random random = new Random();

    public WordStore() {
        ArrayList<Word> words = new ArrayList<>();
        for (String text : Consts.getEnWords()) {
            words.add(new Word(text, Lang.En));
        }
        for (String text : Consts.getRusWords()) {
            words.add(new Word(text, Lang.Rus));
        }
        allWords = words;
    }


    @NonNull
    public Word getRandomWord() {
        int index = random.nextInt(allWords.size());
        return allWords.get(index);
    }

    @NonNull
    public Word getTraslation(Word word) {
        return allWords.get(0);
    }
}
