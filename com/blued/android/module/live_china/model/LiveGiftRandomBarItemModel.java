package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftRandomBarItemModel.class */
public final class LiveGiftRandomBarItemModel implements Serializable {
    private String goods_icon = "";
    private int light;

    public final String getGoods_icon() {
        return this.goods_icon;
    }

    public final int getLight() {
        return this.light;
    }

    public final void setGoods_icon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_icon = str;
    }

    public final void setLight(int i) {
        this.light = i;
    }
}
