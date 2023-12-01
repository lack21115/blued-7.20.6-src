package com.blued.android.module.live_china.model;

import com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveFinishTabData.class */
public final class LiveFinishTabData {
    private final String count;
    private final String name;
    private final LiveHostFinishDetailViewModel.ApiState state;

    public LiveFinishTabData(String name, String count, LiveHostFinishDetailViewModel.ApiState state) {
        Intrinsics.e(name, "name");
        Intrinsics.e(count, "count");
        Intrinsics.e(state, "state");
        this.name = name;
        this.count = count;
        this.state = state;
    }

    public /* synthetic */ LiveFinishTabData(String str, String str2, LiveHostFinishDetailViewModel.ApiState apiState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, apiState);
    }

    public static /* synthetic */ LiveFinishTabData copy$default(LiveFinishTabData liveFinishTabData, String str, String str2, LiveHostFinishDetailViewModel.ApiState apiState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveFinishTabData.name;
        }
        if ((i & 2) != 0) {
            str2 = liveFinishTabData.count;
        }
        if ((i & 4) != 0) {
            apiState = liveFinishTabData.state;
        }
        return liveFinishTabData.copy(str, str2, apiState);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.count;
    }

    public final LiveHostFinishDetailViewModel.ApiState component3() {
        return this.state;
    }

    public final LiveFinishTabData copy(String name, String count, LiveHostFinishDetailViewModel.ApiState state) {
        Intrinsics.e(name, "name");
        Intrinsics.e(count, "count");
        Intrinsics.e(state, "state");
        return new LiveFinishTabData(name, count, state);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveFinishTabData) {
            LiveFinishTabData liveFinishTabData = (LiveFinishTabData) obj;
            return Intrinsics.a((Object) this.name, (Object) liveFinishTabData.name) && Intrinsics.a((Object) this.count, (Object) liveFinishTabData.count) && Intrinsics.a(this.state, liveFinishTabData.state);
        }
        return false;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getName() {
        return this.name;
    }

    public final LiveHostFinishDetailViewModel.ApiState getState() {
        return this.state;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.count.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "LiveFinishTabData(name=" + this.name + ", count=" + this.count + ", state=" + this.state + ')';
    }
}
