package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallBrandAwardTaskModel.class */
public final class GoodsWallBrandAwardTaskModel implements Serializable {
    private String title = "";
    private int finish = -1;

    public final int getFinish() {
        return this.finish;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setFinish(int i) {
        this.finish = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
