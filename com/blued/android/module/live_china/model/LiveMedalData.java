package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveMedalData.class */
public final class LiveMedalData extends BluedEntityBaseExtra {
    private final ArrayList<LiveMedalItemData> anchor;
    private ArrayList<String> desc;
    private final ArrayList<LiveMedalItemData> user;

    public LiveMedalData(ArrayList<LiveMedalItemData> anchor, ArrayList<LiveMedalItemData> user, ArrayList<String> desc) {
        Intrinsics.e(anchor, "anchor");
        Intrinsics.e(user, "user");
        Intrinsics.e(desc, "desc");
        this.anchor = anchor;
        this.user = user;
        this.desc = desc;
    }

    public static /* synthetic */ LiveMedalData copy$default(LiveMedalData liveMedalData, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = liveMedalData.anchor;
        }
        if ((i & 2) != 0) {
            arrayList2 = liveMedalData.user;
        }
        if ((i & 4) != 0) {
            arrayList3 = liveMedalData.desc;
        }
        return liveMedalData.copy(arrayList, arrayList2, arrayList3);
    }

    public final ArrayList<LiveMedalItemData> component1() {
        return this.anchor;
    }

    public final ArrayList<LiveMedalItemData> component2() {
        return this.user;
    }

    public final ArrayList<String> component3() {
        return this.desc;
    }

    public final LiveMedalData copy(ArrayList<LiveMedalItemData> anchor, ArrayList<LiveMedalItemData> user, ArrayList<String> desc) {
        Intrinsics.e(anchor, "anchor");
        Intrinsics.e(user, "user");
        Intrinsics.e(desc, "desc");
        return new LiveMedalData(anchor, user, desc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveMedalData) {
            LiveMedalData liveMedalData = (LiveMedalData) obj;
            return Intrinsics.a(this.anchor, liveMedalData.anchor) && Intrinsics.a(this.user, liveMedalData.user) && Intrinsics.a(this.desc, liveMedalData.desc);
        }
        return false;
    }

    public final ArrayList<LiveMedalItemData> getAnchor() {
        return this.anchor;
    }

    public final ArrayList<String> getDesc() {
        return this.desc;
    }

    public final ArrayList<LiveMedalItemData> getUser() {
        return this.user;
    }

    public int hashCode() {
        return (((this.anchor.hashCode() * 31) + this.user.hashCode()) * 31) + this.desc.hashCode();
    }

    public final void setDesc(ArrayList<String> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.desc = arrayList;
    }

    public String toString() {
        return "LiveMedalData(anchor=" + this.anchor + ", user=" + this.user + ", desc=" + this.desc + ')';
    }
}
