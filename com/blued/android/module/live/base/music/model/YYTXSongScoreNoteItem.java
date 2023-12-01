package com.blued.android.module.live.base.music.model;

import java.util.ArrayList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/model/YYTXSongScoreNoteItem.class */
public class YYTXSongScoreNoteItem {
    public int a;
    public int b;
    public int c;
    public int d;
    public ArrayList<YYUserSongScoreNoteItem> e = new ArrayList<>();

    public String toString() {
        return String.format("startTime = %d ; endTime = %d ; duration = %d ; height = %d;", Integer.valueOf(this.a), Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(this.d));
    }
}
