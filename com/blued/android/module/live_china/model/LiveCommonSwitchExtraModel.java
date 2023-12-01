package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveCommonSwitchExtraModel.class */
public final class LiveCommonSwitchExtraModel {
    private final String other;

    public LiveCommonSwitchExtraModel(String other) {
        Intrinsics.e(other, "other");
        this.other = other;
    }

    public static /* synthetic */ LiveCommonSwitchExtraModel copy$default(LiveCommonSwitchExtraModel liveCommonSwitchExtraModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveCommonSwitchExtraModel.other;
        }
        return liveCommonSwitchExtraModel.copy(str);
    }

    public final String component1() {
        return this.other;
    }

    public final LiveCommonSwitchExtraModel copy(String other) {
        Intrinsics.e(other, "other");
        return new LiveCommonSwitchExtraModel(other);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveCommonSwitchExtraModel) && Intrinsics.a((Object) this.other, (Object) ((LiveCommonSwitchExtraModel) obj).other);
    }

    public final String getOther() {
        return this.other;
    }

    public int hashCode() {
        return this.other.hashCode();
    }

    public String toString() {
        return "LiveCommonSwitchExtraModel(other=" + this.other + ')';
    }
}
