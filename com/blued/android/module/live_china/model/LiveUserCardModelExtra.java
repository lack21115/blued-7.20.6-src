package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveUserCardModelExtra.class */
public final class LiveUserCardModelExtra extends BluedEntityBaseExtra implements Serializable {
    private BehalfExtra behalf;

    public LiveUserCardModelExtra(BehalfExtra behalf) {
        Intrinsics.e(behalf, "behalf");
        this.behalf = behalf;
    }

    public static /* synthetic */ LiveUserCardModelExtra copy$default(LiveUserCardModelExtra liveUserCardModelExtra, BehalfExtra behalfExtra, int i, Object obj) {
        if ((i & 1) != 0) {
            behalfExtra = liveUserCardModelExtra.behalf;
        }
        return liveUserCardModelExtra.copy(behalfExtra);
    }

    public final BehalfExtra component1() {
        return this.behalf;
    }

    public final LiveUserCardModelExtra copy(BehalfExtra behalf) {
        Intrinsics.e(behalf, "behalf");
        return new LiveUserCardModelExtra(behalf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveUserCardModelExtra) && Intrinsics.a(this.behalf, ((LiveUserCardModelExtra) obj).behalf);
    }

    public final BehalfExtra getBehalf() {
        return this.behalf;
    }

    public int hashCode() {
        return this.behalf.hashCode();
    }

    public final void setBehalf(BehalfExtra behalfExtra) {
        Intrinsics.e(behalfExtra, "<set-?>");
        this.behalf = behalfExtra;
    }

    public String toString() {
        return "LiveUserCardModelExtra(behalf=" + this.behalf + ')';
    }
}
