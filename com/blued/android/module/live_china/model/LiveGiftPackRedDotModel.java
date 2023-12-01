package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftPackRedDotModel.class */
public final class LiveGiftPackRedDotModel {
    private int red_point;
    private int red_point_cancel;
    private String red_point_word;

    public LiveGiftPackRedDotModel(int i, String red_point_word, int i2) {
        Intrinsics.e(red_point_word, "red_point_word");
        this.red_point = i;
        this.red_point_word = red_point_word;
        this.red_point_cancel = i2;
    }

    public static /* synthetic */ LiveGiftPackRedDotModel copy$default(LiveGiftPackRedDotModel liveGiftPackRedDotModel, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = liveGiftPackRedDotModel.red_point;
        }
        if ((i3 & 2) != 0) {
            str = liveGiftPackRedDotModel.red_point_word;
        }
        if ((i3 & 4) != 0) {
            i2 = liveGiftPackRedDotModel.red_point_cancel;
        }
        return liveGiftPackRedDotModel.copy(i, str, i2);
    }

    public final int component1() {
        return this.red_point;
    }

    public final String component2() {
        return this.red_point_word;
    }

    public final int component3() {
        return this.red_point_cancel;
    }

    public final LiveGiftPackRedDotModel copy(int i, String red_point_word, int i2) {
        Intrinsics.e(red_point_word, "red_point_word");
        return new LiveGiftPackRedDotModel(i, red_point_word, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftPackRedDotModel) {
            LiveGiftPackRedDotModel liveGiftPackRedDotModel = (LiveGiftPackRedDotModel) obj;
            return this.red_point == liveGiftPackRedDotModel.red_point && Intrinsics.a((Object) this.red_point_word, (Object) liveGiftPackRedDotModel.red_point_word) && this.red_point_cancel == liveGiftPackRedDotModel.red_point_cancel;
        }
        return false;
    }

    public final int getRed_point() {
        return this.red_point;
    }

    public final int getRed_point_cancel() {
        return this.red_point_cancel;
    }

    public final String getRed_point_word() {
        return this.red_point_word;
    }

    public int hashCode() {
        return (((this.red_point * 31) + this.red_point_word.hashCode()) * 31) + this.red_point_cancel;
    }

    public final void setRed_point(int i) {
        this.red_point = i;
    }

    public final void setRed_point_cancel(int i) {
        this.red_point_cancel = i;
    }

    public final void setRed_point_word(String str) {
        Intrinsics.e(str, "<set-?>");
        this.red_point_word = str;
    }

    public String toString() {
        return "LiveGiftPackRedDotModel(red_point=" + this.red_point + ", red_point_word=" + this.red_point_word + ", red_point_cancel=" + this.red_point_cancel + ')';
    }
}
