package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveMedalExtraData.class */
public final class LiveMedalExtraData extends BluedEntityBaseExtra implements Serializable {
    private final ArrayList<String> desc;

    public LiveMedalExtraData(ArrayList<String> desc) {
        Intrinsics.e(desc, "desc");
        this.desc = desc;
    }

    public static /* synthetic */ LiveMedalExtraData copy$default(LiveMedalExtraData liveMedalExtraData, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = liveMedalExtraData.desc;
        }
        return liveMedalExtraData.copy(arrayList);
    }

    public final ArrayList<String> component1() {
        return this.desc;
    }

    public final LiveMedalExtraData copy(ArrayList<String> desc) {
        Intrinsics.e(desc, "desc");
        return new LiveMedalExtraData(desc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveMedalExtraData) && Intrinsics.a(this.desc, ((LiveMedalExtraData) obj).desc);
    }

    public final ArrayList<String> getDesc() {
        return this.desc;
    }

    public int hashCode() {
        return this.desc.hashCode();
    }

    public String toString() {
        return "LiveMedalExtraData(desc=" + this.desc + ')';
    }
}
