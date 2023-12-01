package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RankTopDataModel.class */
public final class RankTopDataModel implements Serializable {
    private String avatar = "";
    private String avatar_frame = "";
    private int is_hide;
    private int lid;
    private long uid;

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final int getLid() {
        return this.lid;
    }

    public final long getUid() {
        return this.uid;
    }

    public final int is_hide() {
        return this.is_hide;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatar_frame(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar_frame = str;
    }

    public final void setLid(int i) {
        this.lid = i;
    }

    public final void setUid(long j) {
        this.uid = j;
    }

    public final void set_hide(int i) {
        this.is_hide = i;
    }
}
