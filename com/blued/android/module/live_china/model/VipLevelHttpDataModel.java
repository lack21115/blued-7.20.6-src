package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/VipLevelHttpDataModel.class */
public final class VipLevelHttpDataModel implements Serializable {
    private int level;
    private String name = "";
    private float score;

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final float getScore() {
        return this.score;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setScore(float f) {
        this.score = f;
    }
}
