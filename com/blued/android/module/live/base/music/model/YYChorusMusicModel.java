package com.blued.android.module.live.base.music.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/model/YYChorusMusicModel.class */
public final class YYChorusMusicModel extends YYKtvMusicModel {
    private final int is_singing;

    public YYChorusMusicModel(int i) {
        this.is_singing = i;
    }

    public static /* synthetic */ YYChorusMusicModel copy$default(YYChorusMusicModel yYChorusMusicModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYChorusMusicModel.is_singing;
        }
        return yYChorusMusicModel.copy(i);
    }

    public final int component1() {
        return this.is_singing;
    }

    public final YYChorusMusicModel copy(int i) {
        return new YYChorusMusicModel(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYChorusMusicModel) && this.is_singing == ((YYChorusMusicModel) obj).is_singing;
    }

    public int hashCode() {
        return this.is_singing;
    }

    public final int is_singing() {
        return this.is_singing;
    }

    public String toString() {
        return "YYChorusMusicModel(is_singing=" + this.is_singing + ')';
    }
}
