package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftWallFloatModel.class */
public final class LiveGiftWallFloatModel implements Serializable {
    private int count;
    private int progress;
    private int show;
    private String title = "";
    private String icon = "";

    public final int getCount() {
        return this.count;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getShow() {
        return this.show;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final void setShow(int i) {
        this.show = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
