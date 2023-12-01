package com.blued.android.module.live_china.model;

import com.blued.android.module.common.model.LiveChargeCouponModel;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBackpackProps.class */
public final class LiveGiftBackpackProps implements Serializable {
    private final ArrayList<LiveChargeCouponModel> in_use;
    private final ArrayList<LiveChargeCouponModel> not_use;
    private final ArrayList<LiveGiftBackpackTabsModel> tabs;

    public LiveGiftBackpackProps(ArrayList<LiveGiftBackpackTabsModel> tabs, ArrayList<LiveChargeCouponModel> not_use, ArrayList<LiveChargeCouponModel> in_use) {
        Intrinsics.e(tabs, "tabs");
        Intrinsics.e(not_use, "not_use");
        Intrinsics.e(in_use, "in_use");
        this.tabs = tabs;
        this.not_use = not_use;
        this.in_use = in_use;
    }

    public static /* synthetic */ LiveGiftBackpackProps copy$default(LiveGiftBackpackProps liveGiftBackpackProps, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = liveGiftBackpackProps.tabs;
        }
        if ((i & 2) != 0) {
            arrayList2 = liveGiftBackpackProps.not_use;
        }
        if ((i & 4) != 0) {
            arrayList3 = liveGiftBackpackProps.in_use;
        }
        return liveGiftBackpackProps.copy(arrayList, arrayList2, arrayList3);
    }

    public final ArrayList<LiveGiftBackpackTabsModel> component1() {
        return this.tabs;
    }

    public final ArrayList<LiveChargeCouponModel> component2() {
        return this.not_use;
    }

    public final ArrayList<LiveChargeCouponModel> component3() {
        return this.in_use;
    }

    public final LiveGiftBackpackProps copy(ArrayList<LiveGiftBackpackTabsModel> tabs, ArrayList<LiveChargeCouponModel> not_use, ArrayList<LiveChargeCouponModel> in_use) {
        Intrinsics.e(tabs, "tabs");
        Intrinsics.e(not_use, "not_use");
        Intrinsics.e(in_use, "in_use");
        return new LiveGiftBackpackProps(tabs, not_use, in_use);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftBackpackProps) {
            LiveGiftBackpackProps liveGiftBackpackProps = (LiveGiftBackpackProps) obj;
            return Intrinsics.a(this.tabs, liveGiftBackpackProps.tabs) && Intrinsics.a(this.not_use, liveGiftBackpackProps.not_use) && Intrinsics.a(this.in_use, liveGiftBackpackProps.in_use);
        }
        return false;
    }

    public final ArrayList<LiveChargeCouponModel> getIn_use() {
        return this.in_use;
    }

    public final ArrayList<LiveChargeCouponModel> getNot_use() {
        return this.not_use;
    }

    public final ArrayList<LiveGiftBackpackTabsModel> getTabs() {
        return this.tabs;
    }

    public int hashCode() {
        return (((this.tabs.hashCode() * 31) + this.not_use.hashCode()) * 31) + this.in_use.hashCode();
    }

    public String toString() {
        return "LiveGiftBackpackProps(tabs=" + this.tabs + ", not_use=" + this.not_use + ", in_use=" + this.in_use + ')';
    }
}
