package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBackpackTabsModel.class */
public final class LiveGiftBackpackTabsModel implements Serializable {
    private final String key;
    private final String name;
    private int red_point;
    private int red_point_cancel;
    private String red_point_word;

    public LiveGiftBackpackTabsModel(String name, String key, int i, String red_point_word, int i2) {
        Intrinsics.e(name, "name");
        Intrinsics.e(key, "key");
        Intrinsics.e(red_point_word, "red_point_word");
        this.name = name;
        this.key = key;
        this.red_point = i;
        this.red_point_word = red_point_word;
        this.red_point_cancel = i2;
    }

    public static /* synthetic */ LiveGiftBackpackTabsModel copy$default(LiveGiftBackpackTabsModel liveGiftBackpackTabsModel, String str, String str2, int i, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = liveGiftBackpackTabsModel.name;
        }
        if ((i3 & 2) != 0) {
            str2 = liveGiftBackpackTabsModel.key;
        }
        if ((i3 & 4) != 0) {
            i = liveGiftBackpackTabsModel.red_point;
        }
        if ((i3 & 8) != 0) {
            str3 = liveGiftBackpackTabsModel.red_point_word;
        }
        if ((i3 & 16) != 0) {
            i2 = liveGiftBackpackTabsModel.red_point_cancel;
        }
        return liveGiftBackpackTabsModel.copy(str, str2, i, str3, i2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.key;
    }

    public final int component3() {
        return this.red_point;
    }

    public final String component4() {
        return this.red_point_word;
    }

    public final int component5() {
        return this.red_point_cancel;
    }

    public final LiveGiftBackpackTabsModel copy(String name, String key, int i, String red_point_word, int i2) {
        Intrinsics.e(name, "name");
        Intrinsics.e(key, "key");
        Intrinsics.e(red_point_word, "red_point_word");
        return new LiveGiftBackpackTabsModel(name, key, i, red_point_word, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftBackpackTabsModel) {
            LiveGiftBackpackTabsModel liveGiftBackpackTabsModel = (LiveGiftBackpackTabsModel) obj;
            return Intrinsics.a((Object) this.name, (Object) liveGiftBackpackTabsModel.name) && Intrinsics.a((Object) this.key, (Object) liveGiftBackpackTabsModel.key) && this.red_point == liveGiftBackpackTabsModel.red_point && Intrinsics.a((Object) this.red_point_word, (Object) liveGiftBackpackTabsModel.red_point_word) && this.red_point_cancel == liveGiftBackpackTabsModel.red_point_cancel;
        }
        return false;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
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
        return (((((((this.name.hashCode() * 31) + this.key.hashCode()) * 31) + this.red_point) * 31) + this.red_point_word.hashCode()) * 31) + this.red_point_cancel;
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
        return "LiveGiftBackpackTabsModel(name=" + this.name + ", key=" + this.key + ", red_point=" + this.red_point + ", red_point_word=" + this.red_point_word + ", red_point_cancel=" + this.red_point_cancel + ')';
    }
}
