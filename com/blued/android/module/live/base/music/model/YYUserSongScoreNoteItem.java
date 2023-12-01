package com.blued.android.module.live.base.music.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/model/YYUserSongScoreNoteItem.class */
public class YYUserSongScoreNoteItem {
    float a;
    float b;
    int c;
    private boolean d;

    public YYUserSongScoreNoteItem(boolean z, float f, float f2, int i) {
        this.d = z;
        this.a = f;
        this.b = f2;
        this.c = i;
    }

    public boolean a() {
        return this.d;
    }

    public float b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public String toString() {
        return "{isHit=" + this.d + ", timeStamp=" + this.a + ", pitch=" + this.b + ", viewValue=" + this.c + '}';
    }
}
