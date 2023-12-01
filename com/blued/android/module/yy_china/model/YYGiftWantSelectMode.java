package com.blued.android.module.yy_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGiftWantSelectMode.class */
public final class YYGiftWantSelectMode implements Serializable {
    private final ArrayList<YYSeatMemberModel> wantSelect;

    public YYGiftWantSelectMode(ArrayList<YYSeatMemberModel> wantSelect) {
        Intrinsics.e(wantSelect, "wantSelect");
        this.wantSelect = wantSelect;
    }

    public static /* synthetic */ YYGiftWantSelectMode copy$default(YYGiftWantSelectMode yYGiftWantSelectMode, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = yYGiftWantSelectMode.wantSelect;
        }
        return yYGiftWantSelectMode.copy(arrayList);
    }

    public final ArrayList<YYSeatMemberModel> component1() {
        return this.wantSelect;
    }

    public final YYGiftWantSelectMode copy(ArrayList<YYSeatMemberModel> wantSelect) {
        Intrinsics.e(wantSelect, "wantSelect");
        return new YYGiftWantSelectMode(wantSelect);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYGiftWantSelectMode) && Intrinsics.a(this.wantSelect, ((YYGiftWantSelectMode) obj).wantSelect);
    }

    public final ArrayList<YYSeatMemberModel> getWantSelect() {
        return this.wantSelect;
    }

    public int hashCode() {
        return this.wantSelect.hashCode();
    }

    public String toString() {
        return "YYGiftWantSelectMode(wantSelect=" + this.wantSelect + ')';
    }
}
