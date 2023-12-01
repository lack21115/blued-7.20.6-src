package com.blued.android.module.live_china.model;

import android.widget.ImageView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveBunchLightViewModel.class */
public final class LiveBunchLightViewModel implements Serializable {
    private int delay;
    private String url = "";
    private ImageView view;
    private int x;
    private int y;

    public final int getDelay() {
        return this.delay;
    }

    public final String getUrl() {
        return this.url;
    }

    public final ImageView getView() {
        return this.view;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final void setDelay(int i) {
        this.delay = i;
    }

    public final void setUrl(String str) {
        Intrinsics.e(str, "<set-?>");
        this.url = str;
    }

    public final void setView(ImageView imageView) {
        this.view = imageView;
    }

    public final void setX(int i) {
        this.x = i;
    }

    public final void setY(int i) {
        this.y = i;
    }
}
