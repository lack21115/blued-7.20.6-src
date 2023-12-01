package com.soft.blued.ui.msg_group.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/GroupCommandDetailResp.class */
public final class GroupCommandDetailResp implements Serializable {
    private long uid;
    private String name = "";
    private String avatar = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getName() {
        return this.name;
    }

    public final long getUid() {
        return this.uid;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setUid(long j) {
        this.uid = j;
    }
}
