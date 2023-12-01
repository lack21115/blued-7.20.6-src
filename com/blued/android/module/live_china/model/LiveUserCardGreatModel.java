package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveUserCardGreatModel.class */
public final class LiveUserCardGreatModel implements Serializable {
    private String avatar;
    private String avatar_frame;
    private int avatar_frame_type;
    private String name;
    private String uid;

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final int getAvatar_frame_type() {
        return this.avatar_frame_type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setAvatar_frame(String str) {
        this.avatar_frame = str;
    }

    public final void setAvatar_frame_type(int i) {
        this.avatar_frame_type = i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }
}
