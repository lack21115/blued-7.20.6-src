package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/PlanetBroadcastModel.class */
public final class PlanetBroadcastModel implements Serializable {
    private String name = "";
    private String text = "";
    private int uid;

    public final String getName() {
        return this.name;
    }

    public final String getText() {
        return this.text;
    }

    public final int getUid() {
        return this.uid;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }

    public final void setUid(int i) {
        this.uid = i;
    }
}
