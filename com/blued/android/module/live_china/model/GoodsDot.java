package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsDot.class */
public final class GoodsDot implements Serializable {
    private int red_point;
    private int red_point_cancel;
    private String red_point_word;

    public GoodsDot(int i, String red_point_word, int i2) {
        Intrinsics.e(red_point_word, "red_point_word");
        this.red_point = i;
        this.red_point_word = red_point_word;
        this.red_point_cancel = i2;
    }

    public static /* synthetic */ GoodsDot copy$default(GoodsDot goodsDot, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = goodsDot.red_point;
        }
        if ((i3 & 2) != 0) {
            str = goodsDot.red_point_word;
        }
        if ((i3 & 4) != 0) {
            i2 = goodsDot.red_point_cancel;
        }
        return goodsDot.copy(i, str, i2);
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

    public final GoodsDot copy(int i, String red_point_word, int i2) {
        Intrinsics.e(red_point_word, "red_point_word");
        return new GoodsDot(i, red_point_word, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsDot) {
            GoodsDot goodsDot = (GoodsDot) obj;
            return this.red_point == goodsDot.red_point && Intrinsics.a((Object) this.red_point_word, (Object) goodsDot.red_point_word) && this.red_point_cancel == goodsDot.red_point_cancel;
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
        return "GoodsDot(red_point=" + this.red_point + ", red_point_word=" + this.red_point_word + ", red_point_cancel=" + this.red_point_cancel + ')';
    }
}
