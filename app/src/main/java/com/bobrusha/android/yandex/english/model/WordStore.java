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
    private ArrayList<Word> enWords = new ArrayList<>();
    private ArrayList<Word> rusWords = new ArrayList<>();
    private final Random random = new Random();

    public WordStore() {
        ArrayList<Word> words = new ArrayList<>();
        for (String text : Consts.getEnWords()) {
            Word e = new Word(text, Lang.En);
            words.add(e);
            enWords.add(e);
        }
        for (String text : Consts.getRusWords()) {
            Word e = new Word(text, Lang.Rus);
            words.add(e);
            rusWords.add(e);
        }
        allWords = words;
    }


    @NonNull
    public Word getRandomEnWord() {
        int index = random.nextInt(enWords.size());
        return enWords.get(index);
    }

    @NonNull
    public Word getRandomRusWord() {
        int index = random.nextInt(rusWords.size());
        return rusWords.get(index);
    }

    public Word getRandomWord() {
        int index = random.nextInt(allWords.size());
        return allWords.get(index);
    }

    @NonNull
    public Word getTraslation(Word word) {
        return allWords.get(0);
    }
}
