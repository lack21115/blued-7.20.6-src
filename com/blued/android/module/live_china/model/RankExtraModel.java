package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RankExtraModel.class */
public final class RankExtraModel extends BluedEntityBaseExtra {
    private String desc_image = "";

    public final String getDesc_image() {
        return this.desc_image;
    }

    public final void setDesc_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc_image = str;
    }
}
