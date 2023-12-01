package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LuckyBagLuckyComeModel.class */
public final class LuckyBagLuckyComeModel implements Serializable {
    private int current;
    private String desc = "";
    private boolean is_enable;
    private int max;

    public final int getCurrent() {
        return this.current;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getMax() {
        return this.max;
    }

    public final boolean is_enable() {
        return this.is_enable;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setMax(int i) {
        this.max = i;
    }

    public final void set_enable(boolean z) {
        this.is_enable = z;
    }
}
