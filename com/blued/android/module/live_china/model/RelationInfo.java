package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RelationInfo.class */
public final class RelationInfo implements Serializable {
    private String uid = "";
    private String relation = "";

    public final String getRelation() {
        return this.relation;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setRelation(String str) {
        Intrinsics.e(str, "<set-?>");
        this.relation = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }
}
