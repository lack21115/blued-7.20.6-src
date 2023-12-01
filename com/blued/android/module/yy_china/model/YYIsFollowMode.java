package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYIsFollowMode.class */
public final class YYIsFollowMode {
    private final String status;

    public YYIsFollowMode(String status) {
        Intrinsics.e(status, "status");
        this.status = status;
    }

    public static /* synthetic */ YYIsFollowMode copy$default(YYIsFollowMode yYIsFollowMode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYIsFollowMode.status;
        }
        return yYIsFollowMode.copy(str);
    }

    public final String component1() {
        return this.status;
    }

    public final YYIsFollowMode copy(String status) {
        Intrinsics.e(status, "status");
        return new YYIsFollowMode(status);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYIsFollowMode) && Intrinsics.a((Object) this.status, (Object) ((YYIsFollowMode) obj).status);
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    public String toString() {
        return "YYIsFollowMode(status=" + this.status + ')';
    }
}
