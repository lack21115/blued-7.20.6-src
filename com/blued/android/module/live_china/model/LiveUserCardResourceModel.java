package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveUserCardResourceModel.class */
public final class LiveUserCardResourceModel implements Serializable {
    private String avatar_decorate;
    private String background;
    private String streamer;

    public final String getAvatar_decorate() {
        return this.avatar_decorate;
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getStreamer() {
        return this.streamer;
    }

    public final void setAvatar_decorate(String str) {
        this.avatar_decorate = str;
    }

    public final void setBackground(String str) {
        this.background = str;
    }

    public final void setStreamer(String str) {
        this.streamer = str;
    }
}
