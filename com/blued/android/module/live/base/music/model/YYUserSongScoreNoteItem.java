package com.blued.android.module.live.base.music.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/model/YYUserSongScoreNoteItem.class */
public class YYUserSongScoreNoteItem {

    /* renamed from: a  reason: collision with root package name */
    float f11449a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    int f11450c;
    private boolean d;

    public YYUserSongScoreNoteItem(boolean z, float f, float f2, int i) {
        this.d = z;
        this.f11449a = f;
        this.b = f2;
        this.f11450c = i;
    }

    public boolean a() {
        return this.d;
    }

    public float b() {
        return this.f11449a;
    }

    public int c() {
        return this.f11450c;
    }

    public String toString() {
        return "{isHit=" + this.d + ", timeStamp=" + this.f11449a + ", pitch=" + this.b + ", viewValue=" + this.f11450c + '}';
    }
}
