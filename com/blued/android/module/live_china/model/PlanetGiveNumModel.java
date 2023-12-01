package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/PlanetGiveNumModel.class */
public final class PlanetGiveNumModel implements Serializable {
    private int count;
    private String text = "";

    public final int getCount() {
        return this.count;
    }

    public final String getText() {
        return this.text;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }
}
