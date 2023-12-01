package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBackpackModel.class */
public final class LiveGiftBackpackModel implements Serializable {
    private final LiveGiftBackpackEquips equips;
    private final ArrayList<LiveGiftFragmentModel> fragment;
    private final ArrayList<LiveGiftModel> gifts;
    private final LiveGiftBackpackProps props;
    private final ArrayList<LiveGiftBackpackTabsModel> tabs;

    public LiveGiftBackpackModel(ArrayList<LiveGiftBackpackTabsModel> tabs, ArrayList<LiveGiftModel> gifts, LiveGiftBackpackProps props, LiveGiftBackpackEquips equips, ArrayList<LiveGiftFragmentModel> fragment) {
        Intrinsics.e(tabs, "tabs");
        Intrinsics.e(gifts, "gifts");
        Intrinsics.e(props, "props");
        Intrinsics.e(equips, "equips");
        Intrinsics.e(fragment, "fragment");
        this.tabs = tabs;
        this.gifts = gifts;
        this.props = props;
        this.equips = equips;
        this.fragment = fragment;
    }

    public static /* synthetic */ LiveGiftBackpackModel copy$default(LiveGiftBackpackModel liveGiftBackpackModel, ArrayList arrayList, ArrayList arrayList2, LiveGiftBackpackProps liveGiftBackpackProps, LiveGiftBackpackEquips liveGiftBackpackEquips, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = liveGiftBackpackModel.tabs;
        }
        if ((i & 2) != 0) {
            arrayList2 = liveGiftBackpackModel.gifts;
        }
        if ((i & 4) != 0) {
            liveGiftBackpackProps = liveGiftBackpackModel.props;
        }
        if ((i & 8) != 0) {
            liveGiftBackpackEquips = liveGiftBackpackModel.equips;
        }
        if ((i & 16) != 0) {
            arrayList3 = liveGiftBackpackModel.fragment;
        }
        return liveGiftBackpackModel.copy(arrayList, arrayList2, liveGiftBackpackProps, liveGiftBackpackEquips, arrayList3);
    }

    public final ArrayList<LiveGiftBackpackTabsModel> component1() {
        return this.tabs;
    }

    public final ArrayList<LiveGiftModel> component2() {
        return this.gifts;
    }

    public final LiveGiftBackpackProps component3() {
        return this.props;
    }

    public final LiveGiftBackpackEquips component4() {
        return this.equips;
    }

    public final ArrayList<LiveGiftFragmentModel> component5() {
        return this.fragment;
    }

    public final LiveGiftBackpackModel copy(ArrayList<LiveGiftBackpackTabsModel> tabs, ArrayList<LiveGiftModel> gifts, LiveGiftBackpackProps props, LiveGiftBackpackEquips equips, ArrayList<LiveGiftFragmentModel> fragment) {
        Intrinsics.e(tabs, "tabs");
        Intrinsics.e(gifts, "gifts");
        Intrinsics.e(props, "props");
        Intrinsics.e(equips, "equips");
        Intrinsics.e(fragment, "fragment");
        return new LiveGiftBackpackModel(tabs, gifts, props, equips, fragment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftBackpackModel) {
            LiveGiftBackpackModel liveGiftBackpackModel = (LiveGiftBackpackModel) obj;
            return Intrinsics.a(this.tabs, liveGiftBackpackModel.tabs) && Intrinsics.a(this.gifts, liveGiftBackpackModel.gifts) && Intrinsics.a(this.props, liveGiftBackpackModel.props) && Intrinsics.a(this.equips, liveGiftBackpackModel.equips) && Intrinsics.a(this.fragment, liveGiftBackpackModel.fragment);
        }
        return false;
    }

    public final LiveGiftBackpackEquips getEquips() {
        return this.equips;
    }

    public final ArrayList<LiveGiftFragmentModel> getFragment() {
        return this.fragment;
    }

    public final ArrayList<LiveGiftModel> getGifts() {
        return this.gifts;
    }

    public final LiveGiftBackpackProps getProps() {
        return this.props;
    }

    public final ArrayList<LiveGiftBackpackTabsModel> getTabs() {
        return this.tabs;
    }

    public int hashCode() {
        return (((((((this.tabs.hashCode() * 31) + this.gifts.hashCode()) * 31) + this.props.hashCode()) * 31) + this.equips.hashCode()) * 31) + this.fragment.hashCode();
    }

    public String toString() {
        return "LiveGiftBackpackModel(tabs=" + this.tabs + ", gifts=" + this.gifts + ", props=" + this.props + ", equips=" + this.equips + ", fragment=" + this.fragment + ')';
    }
}
