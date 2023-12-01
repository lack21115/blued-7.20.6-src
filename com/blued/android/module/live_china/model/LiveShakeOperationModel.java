package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveShakeOperationModel.class */
public final class LiveShakeOperationModel implements Serializable {
    private int status;
    private String desc = "";
    private String title = "";

    public final String getDesc() {
        return this.desc;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
