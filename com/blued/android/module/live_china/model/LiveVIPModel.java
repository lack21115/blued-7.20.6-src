package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveVIPModel.class */
public final class LiveVIPModel implements Serializable {
    private boolean is_enable;
    private int link_type = 3;
    private String link = "";

    public final String getLink() {
        return this.link;
    }

    public final int getLink_type() {
        return this.link_type;
    }

    public final boolean is_enable() {
        return this.is_enable;
    }

    public final void setLink(String str) {
        Intrinsics.e(str, "<set-?>");
        this.link = str;
    }

    public final void setLink_type(int i) {
        this.link_type = i;
    }

    public final void set_enable(boolean z) {
        this.is_enable = z;
    }
}
