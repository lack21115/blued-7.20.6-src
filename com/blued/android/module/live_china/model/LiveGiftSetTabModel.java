package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSetTabModel.class */
public final class LiveGiftSetTabModel implements Serializable {
    private String id = "";
    private String name = "";

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setId(String str) {
        Intrinsics.e(str, "<set-?>");
        this.id = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }
}
