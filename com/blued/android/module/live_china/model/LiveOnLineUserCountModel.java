package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveOnLineUserCountModel.class */
public final class LiveOnLineUserCountModel {
    private final String onLineNobleUserCount;
    private final String onLineUserCount;

    public LiveOnLineUserCountModel(String onLineUserCount, String onLineNobleUserCount) {
        Intrinsics.e(onLineUserCount, "onLineUserCount");
        Intrinsics.e(onLineNobleUserCount, "onLineNobleUserCount");
        this.onLineUserCount = onLineUserCount;
        this.onLineNobleUserCount = onLineNobleUserCount;
    }

    public static /* synthetic */ LiveOnLineUserCountModel copy$default(LiveOnLineUserCountModel liveOnLineUserCountModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveOnLineUserCountModel.onLineUserCount;
        }
        if ((i & 2) != 0) {
            str2 = liveOnLineUserCountModel.onLineNobleUserCount;
        }
        return liveOnLineUserCountModel.copy(str, str2);
    }

    public final String component1() {
        return this.onLineUserCount;
    }

    public final String component2() {
        return this.onLineNobleUserCount;
    }

    public final LiveOnLineUserCountModel copy(String onLineUserCount, String onLineNobleUserCount) {
        Intrinsics.e(onLineUserCount, "onLineUserCount");
        Intrinsics.e(onLineNobleUserCount, "onLineNobleUserCount");
        return new LiveOnLineUserCountModel(onLineUserCount, onLineNobleUserCount);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveOnLineUserCountModel) {
            LiveOnLineUserCountModel liveOnLineUserCountModel = (LiveOnLineUserCountModel) obj;
            return Intrinsics.a((Object) this.onLineUserCount, (Object) liveOnLineUserCountModel.onLineUserCount) && Intrinsics.a((Object) this.onLineNobleUserCount, (Object) liveOnLineUserCountModel.onLineNobleUserCount);
        }
        return false;
    }

    public final String getOnLineNobleUserCount() {
        return this.onLineNobleUserCount;
    }

    public final String getOnLineUserCount() {
        return this.onLineUserCount;
    }

    public int hashCode() {
        return (this.onLineUserCount.hashCode() * 31) + this.onLineNobleUserCount.hashCode();
    }

    public String toString() {
        return "LiveOnLineUserCountModel(onLineUserCount=" + this.onLineUserCount + ", onLineNobleUserCount=" + this.onLineNobleUserCount + ')';
    }
}
