package com.blued.android.module.yy_china.model;

import $r8;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPackGiftInfoMode.class */
public final class YYPackGiftInfoMode {
    private final long count_down;
    private final ArrayList<YYPackGiftInfoItemMode> item;
    private final String remark1;
    private final String remark2;

    public YYPackGiftInfoMode(String remark1, String remark2, long j, ArrayList<YYPackGiftInfoItemMode> item) {
        Intrinsics.e(remark1, "remark1");
        Intrinsics.e(remark2, "remark2");
        Intrinsics.e(item, "item");
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.count_down = j;
        this.item = item;
    }

    public static /* synthetic */ YYPackGiftInfoMode copy$default(YYPackGiftInfoMode yYPackGiftInfoMode, String str, String str2, long j, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYPackGiftInfoMode.remark1;
        }
        if ((i & 2) != 0) {
            str2 = yYPackGiftInfoMode.remark2;
        }
        if ((i & 4) != 0) {
            j = yYPackGiftInfoMode.count_down;
        }
        if ((i & 8) != 0) {
            arrayList = yYPackGiftInfoMode.item;
        }
        return yYPackGiftInfoMode.copy(str, str2, j, arrayList);
    }

    public final String component1() {
        return this.remark1;
    }

    public final String component2() {
        return this.remark2;
    }

    public final long component3() {
        return this.count_down;
    }

    public final ArrayList<YYPackGiftInfoItemMode> component4() {
        return this.item;
    }

    public final YYPackGiftInfoMode copy(String remark1, String remark2, long j, ArrayList<YYPackGiftInfoItemMode> item) {
        Intrinsics.e(remark1, "remark1");
        Intrinsics.e(remark2, "remark2");
        Intrinsics.e(item, "item");
        return new YYPackGiftInfoMode(remark1, remark2, j, item);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYPackGiftInfoMode) {
            YYPackGiftInfoMode yYPackGiftInfoMode = (YYPackGiftInfoMode) obj;
            return Intrinsics.a((Object) this.remark1, (Object) yYPackGiftInfoMode.remark1) && Intrinsics.a((Object) this.remark2, (Object) yYPackGiftInfoMode.remark2) && this.count_down == yYPackGiftInfoMode.count_down && Intrinsics.a(this.item, yYPackGiftInfoMode.item);
        }
        return false;
    }

    public final long getCount_down() {
        return this.count_down;
    }

    public final ArrayList<YYPackGiftInfoItemMode> getItem() {
        return this.item;
    }

    public final String getRemark1() {
        return this.remark1;
    }

    public final String getRemark2() {
        return this.remark2;
    }

    public int hashCode() {
        return (((((this.remark1.hashCode() * 31) + this.remark2.hashCode()) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.count_down)) * 31) + this.item.hashCode();
    }

    public String toString() {
        return "YYPackGiftInfoMode(remark1=" + this.remark1 + ", remark2=" + this.remark2 + ", count_down=" + this.count_down + ", item=" + this.item + ')';
    }
}
