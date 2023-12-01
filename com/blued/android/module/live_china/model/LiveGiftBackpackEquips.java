package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBackpackEquips.class */
public final class LiveGiftBackpackEquips implements Serializable {
    private final ArrayList<LiveAvatarFrameModel> avatar_frame;
    private final ArrayList<LiveGiftCardFrameModel> card_frame;
    private final ArrayList<LiveGiftBagChatBadgeModel> chat_badge;
    private final ArrayList<LiveBubbleBgModel> chat_frame;
    private final ArrayList<LiveGiftModel> effect;
    private final ArrayList<LiveGiftBackpackTabsModel> tabs;

    public LiveGiftBackpackEquips(ArrayList<LiveGiftBackpackTabsModel> tabs, ArrayList<LiveBubbleBgModel> chat_frame, ArrayList<LiveAvatarFrameModel> avatar_frame, ArrayList<LiveGiftModel> effect, ArrayList<LiveGiftBagChatBadgeModel> chat_badge, ArrayList<LiveGiftCardFrameModel> card_frame) {
        Intrinsics.e(tabs, "tabs");
        Intrinsics.e(chat_frame, "chat_frame");
        Intrinsics.e(avatar_frame, "avatar_frame");
        Intrinsics.e(effect, "effect");
        Intrinsics.e(chat_badge, "chat_badge");
        Intrinsics.e(card_frame, "card_frame");
        this.tabs = tabs;
        this.chat_frame = chat_frame;
        this.avatar_frame = avatar_frame;
        this.effect = effect;
        this.chat_badge = chat_badge;
        this.card_frame = card_frame;
    }

    public static /* synthetic */ LiveGiftBackpackEquips copy$default(LiveGiftBackpackEquips liveGiftBackpackEquips, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = liveGiftBackpackEquips.tabs;
        }
        if ((i & 2) != 0) {
            arrayList2 = liveGiftBackpackEquips.chat_frame;
        }
        if ((i & 4) != 0) {
            arrayList3 = liveGiftBackpackEquips.avatar_frame;
        }
        if ((i & 8) != 0) {
            arrayList4 = liveGiftBackpackEquips.effect;
        }
        if ((i & 16) != 0) {
            arrayList5 = liveGiftBackpackEquips.chat_badge;
        }
        if ((i & 32) != 0) {
            arrayList6 = liveGiftBackpackEquips.card_frame;
        }
        return liveGiftBackpackEquips.copy(arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6);
    }

    public final ArrayList<LiveGiftBackpackTabsModel> component1() {
        return this.tabs;
    }

    public final ArrayList<LiveBubbleBgModel> component2() {
        return this.chat_frame;
    }

    public final ArrayList<LiveAvatarFrameModel> component3() {
        return this.avatar_frame;
    }

    public final ArrayList<LiveGiftModel> component4() {
        return this.effect;
    }

    public final ArrayList<LiveGiftBagChatBadgeModel> component5() {
        return this.chat_badge;
    }

    public final ArrayList<LiveGiftCardFrameModel> component6() {
        return this.card_frame;
    }

    public final LiveGiftBackpackEquips copy(ArrayList<LiveGiftBackpackTabsModel> tabs, ArrayList<LiveBubbleBgModel> chat_frame, ArrayList<LiveAvatarFrameModel> avatar_frame, ArrayList<LiveGiftModel> effect, ArrayList<LiveGiftBagChatBadgeModel> chat_badge, ArrayList<LiveGiftCardFrameModel> card_frame) {
        Intrinsics.e(tabs, "tabs");
        Intrinsics.e(chat_frame, "chat_frame");
        Intrinsics.e(avatar_frame, "avatar_frame");
        Intrinsics.e(effect, "effect");
        Intrinsics.e(chat_badge, "chat_badge");
        Intrinsics.e(card_frame, "card_frame");
        return new LiveGiftBackpackEquips(tabs, chat_frame, avatar_frame, effect, chat_badge, card_frame);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftBackpackEquips) {
            LiveGiftBackpackEquips liveGiftBackpackEquips = (LiveGiftBackpackEquips) obj;
            return Intrinsics.a(this.tabs, liveGiftBackpackEquips.tabs) && Intrinsics.a(this.chat_frame, liveGiftBackpackEquips.chat_frame) && Intrinsics.a(this.avatar_frame, liveGiftBackpackEquips.avatar_frame) && Intrinsics.a(this.effect, liveGiftBackpackEquips.effect) && Intrinsics.a(this.chat_badge, liveGiftBackpackEquips.chat_badge) && Intrinsics.a(this.card_frame, liveGiftBackpackEquips.card_frame);
        }
        return false;
    }

    public final ArrayList<LiveAvatarFrameModel> getAvatar_frame() {
        return this.avatar_frame;
    }

    public final ArrayList<LiveGiftCardFrameModel> getCard_frame() {
        return this.card_frame;
    }

    public final ArrayList<LiveGiftBagChatBadgeModel> getChat_badge() {
        return this.chat_badge;
    }

    public final ArrayList<LiveBubbleBgModel> getChat_frame() {
        return this.chat_frame;
    }

    public final ArrayList<LiveGiftModel> getEffect() {
        return this.effect;
    }

    public final ArrayList<LiveGiftBackpackTabsModel> getTabs() {
        return this.tabs;
    }

    public int hashCode() {
        return (((((((((this.tabs.hashCode() * 31) + this.chat_frame.hashCode()) * 31) + this.avatar_frame.hashCode()) * 31) + this.effect.hashCode()) * 31) + this.chat_badge.hashCode()) * 31) + this.card_frame.hashCode();
    }

    public String toString() {
        return "LiveGiftBackpackEquips(tabs=" + this.tabs + ", chat_frame=" + this.chat_frame + ", avatar_frame=" + this.avatar_frame + ", effect=" + this.effect + ", chat_badge=" + this.chat_badge + ", card_frame=" + this.card_frame + ')';
    }
}
