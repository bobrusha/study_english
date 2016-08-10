package com.bobrusha.android.yandex.english.model;

/**
 * Created by Andrey on 23.07.2016.
 */
public class ChooseTranslationOneSlice {
    // Лучше сразу делать все private final да еще и immutable >:)
    // Это не сильно дольше, геттеры/сеттеры очень быстро генерируются Android Studio.
    public Word word;
    public Word translation;
    public Word first;
    public Word second;
    public Word third;
    public Word forth;
}
