package com.bobrusha.android.yandex.english.model;

import android.net.LinkAddress;

/**
 * Created by Andrey on 23.07.2016.
 */
public class Word {

    public static Word unknownWord = new Word("Unknown", Lang.En);
    private Lang lang;
    private String text;

    public Word(String text, Lang lang) {
        this.text = text;
        this.lang = lang;
    }

    public Lang getLang() {
        return lang;
    }
    public String getText() {
        return text;
    }
}
