package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/UserCardCarInfoMode.class */
public final class UserCardCarInfoMode {
    private final String received_count;

    public UserCardCarInfoMode(String received_count) {
        Intrinsics.e(received_count, "received_count");
        this.received_count = received_count;
    }

    public static /* synthetic */ UserCardCarInfoMode copy$default(UserCardCarInfoMode userCardCarInfoMode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userCardCarInfoMode.received_count;
        }
        return userCardCarInfoMode.copy(str);
    }

    public final String component1() {
        return this.received_count;
    }

    public final UserCardCarInfoMode copy(String received_count) {
        Intrinsics.e(received_count, "received_count");
        return new UserCardCarInfoMode(received_count);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserCardCarInfoMode) && Intrinsics.a((Object) this.received_count, (Object) ((UserCardCarInfoMode) obj).received_count);
    }

    public final String getReceived_count() {
        return this.received_count;
    }

    public int hashCode() {
        return this.received_count.hashCode();
    }

    public String toString() {
        return "UserCardCarInfoMode(received_count=" + this.received_count + ')';
    }
}
