package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallBrandAwardModel.class */
public final class GoodsWallBrandAwardModel implements Serializable {
    private String date = "";
    private String bonus = "";

    public final String getBonus() {
        return this.bonus;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setBonus(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bonus = str;
    }

    public final void setDate(String str) {
        Intrinsics.e(str, "<set-?>");
        this.date = str;
    }
}
