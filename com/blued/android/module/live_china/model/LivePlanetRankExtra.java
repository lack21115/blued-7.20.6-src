package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePlanetRankExtra.class */
public final class LivePlanetRankExtra extends BluedEntityBaseExtra implements Serializable {
    private String text = "";
    private String play_text = "";

    public final String getPlay_text() {
        return this.play_text;
    }

    public final String getText() {
        return this.text;
    }

    public final void setPlay_text(String str) {
        Intrinsics.e(str, "<set-?>");
        this.play_text = str;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }
}
