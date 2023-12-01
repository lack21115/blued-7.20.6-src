package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPackGiftTrueGiftInfoMode.class */
public final class YYPackGiftTrueGiftInfoMode {
    private final YYGiftModel info;
    private int sent_num;

    public YYPackGiftTrueGiftInfoMode(int i, YYGiftModel info) {
        Intrinsics.e(info, "info");
        this.sent_num = i;
        this.info = info;
    }

    public static /* synthetic */ YYPackGiftTrueGiftInfoMode copy$default(YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode, int i, YYGiftModel yYGiftModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYPackGiftTrueGiftInfoMode.sent_num;
        }
        if ((i2 & 2) != 0) {
            yYGiftModel = yYPackGiftTrueGiftInfoMode.info;
        }
        return yYPackGiftTrueGiftInfoMode.copy(i, yYGiftModel);
    }

    public final int component1() {
        return this.sent_num;
    }

    public final YYGiftModel component2() {
        return this.info;
    }

    public final YYPackGiftTrueGiftInfoMode copy(int i, YYGiftModel info) {
        Intrinsics.e(info, "info");
        return new YYPackGiftTrueGiftInfoMode(i, info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYPackGiftTrueGiftInfoMode) {
            YYPackGiftTrueGiftInfoMode yYPackGiftTrueGiftInfoMode = (YYPackGiftTrueGiftInfoMode) obj;
            return this.sent_num == yYPackGiftTrueGiftInfoMode.sent_num && Intrinsics.a(this.info, yYPackGiftTrueGiftInfoMode.info);
        }
        return false;
    }

    public final YYGiftModel getInfo() {
        return this.info;
    }

    public final int getSent_num() {
        return this.sent_num;
    }

    public int hashCode() {
        return (this.sent_num * 31) + this.info.hashCode();
    }

    public final void setSent_num(int i) {
        this.sent_num = i;
    }

    public String toString() {
        return "YYPackGiftTrueGiftInfoMode(sent_num=" + this.sent_num + ", info=" + this.info + ')';
    }
}
