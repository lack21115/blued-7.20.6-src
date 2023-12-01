package com.blued.android.module.yy_china.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYTrueLovePackGiftMode.class */
public final class YYTrueLovePackGiftMode {
    private final long round_end_time;

    public YYTrueLovePackGiftMode(long j) {
        this.round_end_time = j;
    }

    public static /* synthetic */ YYTrueLovePackGiftMode copy$default(YYTrueLovePackGiftMode yYTrueLovePackGiftMode, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = yYTrueLovePackGiftMode.round_end_time;
        }
        return yYTrueLovePackGiftMode.copy(j);
    }

    public final long component1() {
        return this.round_end_time;
    }

    public final YYTrueLovePackGiftMode copy(long j) {
        return new YYTrueLovePackGiftMode(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYTrueLovePackGiftMode) && this.round_end_time == ((YYTrueLovePackGiftMode) obj).round_end_time;
    }

    public final long getRound_end_time() {
        return this.round_end_time;
    }

    public int hashCode() {
        return C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.round_end_time);
    }

    public String toString() {
        return "YYTrueLovePackGiftMode(round_end_time=" + this.round_end_time + ')';
    }
}
