package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveFootPrintModel.class */
public final class LiveFootPrintModel {
    private long leave_time;
    private String anchor = "";
    private String name = "";
    private String avatar = "";
    private String lid = "";

    public final String getAnchor() {
        return this.anchor;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final long getLeave_time() {
        return this.leave_time;
    }

    public final String getLid() {
        return this.lid;
    }

    public final String getName() {
        return this.name;
    }

    public final void setAnchor(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor = str;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setLeave_time(long j) {
        this.leave_time = j;
    }

    public final void setLid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.lid = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }
}
