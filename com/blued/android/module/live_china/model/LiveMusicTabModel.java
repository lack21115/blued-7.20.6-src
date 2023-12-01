package com.blued.android.module.live_china.model;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveMusicTabModel.class */
public class LiveMusicTabModel {
    public String id;
    public String name;
    public boolean selected;

    public LiveMusicTabModel() {
    }

    public LiveMusicTabModel(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public String toString() {
        return "LiveMusicTabModel{id='" + this.id + "', name='" + this.name + '}';
    }
}
