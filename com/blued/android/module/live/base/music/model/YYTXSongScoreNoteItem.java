package com.blued.android.module.live.base.music.model;

import java.util.ArrayList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/model/YYTXSongScoreNoteItem.class */
public class YYTXSongScoreNoteItem {

    /* renamed from: a  reason: collision with root package name */
    public int f11447a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f11448c;
    public int d;
    public ArrayList<YYUserSongScoreNoteItem> e = new ArrayList<>();

    public String toString() {
        return String.format("startTime = %d ; endTime = %d ; duration = %d ; height = %d;", Integer.valueOf(this.f11447a), Integer.valueOf(this.f11448c), Integer.valueOf(this.b), Integer.valueOf(this.d));
    }
}
