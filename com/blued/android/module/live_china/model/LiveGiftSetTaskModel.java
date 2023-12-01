package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSetTaskModel.class */
public final class LiveGiftSetTaskModel implements Serializable {
    private String text = "";
    private String icon = "";
    private String total = "";
    private String count = "";

    public final String getCount() {
        return this.count;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTotal() {
        return this.total;
    }

    public final void setCount(String str) {
        Intrinsics.e(str, "<set-?>");
        this.count = str;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }

    public final void setTotal(String str) {
        Intrinsics.e(str, "<set-?>");
        this.total = str;
    }
}
