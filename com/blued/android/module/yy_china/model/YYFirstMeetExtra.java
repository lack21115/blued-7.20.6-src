package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFirstMeetExtra.class */
public final class YYFirstMeetExtra extends BluedEntityBaseExtra {
    private final YYFirstUserInfoMode anchor_info;

    public YYFirstMeetExtra(YYFirstUserInfoMode anchor_info) {
        Intrinsics.e(anchor_info, "anchor_info");
        this.anchor_info = anchor_info;
    }

    public static /* synthetic */ YYFirstMeetExtra copy$default(YYFirstMeetExtra yYFirstMeetExtra, YYFirstUserInfoMode yYFirstUserInfoMode, int i, Object obj) {
        if ((i & 1) != 0) {
            yYFirstUserInfoMode = yYFirstMeetExtra.anchor_info;
        }
        return yYFirstMeetExtra.copy(yYFirstUserInfoMode);
    }

    public final YYFirstUserInfoMode component1() {
        return this.anchor_info;
    }

    public final YYFirstMeetExtra copy(YYFirstUserInfoMode anchor_info) {
        Intrinsics.e(anchor_info, "anchor_info");
        return new YYFirstMeetExtra(anchor_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYFirstMeetExtra) && Intrinsics.a(this.anchor_info, ((YYFirstMeetExtra) obj).anchor_info);
    }

    public final YYFirstUserInfoMode getAnchor_info() {
        return this.anchor_info;
    }

    public int hashCode() {
        return this.anchor_info.hashCode();
    }

    public String toString() {
        return "YYFirstMeetExtra(anchor_info=" + this.anchor_info + ')';
    }
}
