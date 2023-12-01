package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRelationModel.class */
public final class LiveRelationModel {
    private String relationship = "";
    private String secretly_followed_status = "";

    public final String getRelationship() {
        return this.relationship;
    }

    public final String getSecretly_followed_status() {
        return this.secretly_followed_status;
    }

    public final void setRelationship(String str) {
        Intrinsics.e(str, "<set-?>");
        this.relationship = str;
    }

    public final void setSecretly_followed_status(String str) {
        Intrinsics.e(str, "<set-?>");
        this.secretly_followed_status = str;
    }
}
