package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBagChatBadgeModel.class */
public final class LiveGiftBagChatBadgeModel implements Serializable {
    private final String chat_badge_expire_time;
    private final int chat_badge_height;
    private final String chat_badge_id;
    private final int chat_badge_length;
    private final String chat_badge_name;
    private final String chat_badge_package_url;
    private final String chat_badge_url;
    private final int is_hide_expire_time;
    private final int is_wear;

    public LiveGiftBagChatBadgeModel(String chat_badge_id, String chat_badge_url, String chat_badge_name, int i, int i2, String chat_badge_expire_time, int i3, String chat_badge_package_url, int i4) {
        Intrinsics.e(chat_badge_id, "chat_badge_id");
        Intrinsics.e(chat_badge_url, "chat_badge_url");
        Intrinsics.e(chat_badge_name, "chat_badge_name");
        Intrinsics.e(chat_badge_expire_time, "chat_badge_expire_time");
        Intrinsics.e(chat_badge_package_url, "chat_badge_package_url");
        this.chat_badge_id = chat_badge_id;
        this.chat_badge_url = chat_badge_url;
        this.chat_badge_name = chat_badge_name;
        this.chat_badge_height = i;
        this.chat_badge_length = i2;
        this.chat_badge_expire_time = chat_badge_expire_time;
        this.is_hide_expire_time = i3;
        this.chat_badge_package_url = chat_badge_package_url;
        this.is_wear = i4;
    }

    public /* synthetic */ LiveGiftBagChatBadgeModel(String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, i2, str4, (i5 & 64) != 0 ? 0 : i3, str5, i4);
    }

    public static /* synthetic */ LiveGiftBagChatBadgeModel copy$default(LiveGiftBagChatBadgeModel liveGiftBagChatBadgeModel, String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = liveGiftBagChatBadgeModel.chat_badge_id;
        }
        if ((i5 & 2) != 0) {
            str2 = liveGiftBagChatBadgeModel.chat_badge_url;
        }
        if ((i5 & 4) != 0) {
            str3 = liveGiftBagChatBadgeModel.chat_badge_name;
        }
        if ((i5 & 8) != 0) {
            i = liveGiftBagChatBadgeModel.chat_badge_height;
        }
        if ((i5 & 16) != 0) {
            i2 = liveGiftBagChatBadgeModel.chat_badge_length;
        }
        if ((i5 & 32) != 0) {
            str4 = liveGiftBagChatBadgeModel.chat_badge_expire_time;
        }
        if ((i5 & 64) != 0) {
            i3 = liveGiftBagChatBadgeModel.is_hide_expire_time;
        }
        if ((i5 & 128) != 0) {
            str5 = liveGiftBagChatBadgeModel.chat_badge_package_url;
        }
        if ((i5 & 256) != 0) {
            i4 = liveGiftBagChatBadgeModel.is_wear;
        }
        return liveGiftBagChatBadgeModel.copy(str, str2, str3, i, i2, str4, i3, str5, i4);
    }

    public final String component1() {
        return this.chat_badge_id;
    }

    public final String component2() {
        return this.chat_badge_url;
    }

    public final String component3() {
        return this.chat_badge_name;
    }

    public final int component4() {
        return this.chat_badge_height;
    }

    public final int component5() {
        return this.chat_badge_length;
    }

    public final String component6() {
        return this.chat_badge_expire_time;
    }

    public final int component7() {
        return this.is_hide_expire_time;
    }

    public final String component8() {
        return this.chat_badge_package_url;
    }

    public final int component9() {
        return this.is_wear;
    }

    public final LiveGiftBagChatBadgeModel copy(String chat_badge_id, String chat_badge_url, String chat_badge_name, int i, int i2, String chat_badge_expire_time, int i3, String chat_badge_package_url, int i4) {
        Intrinsics.e(chat_badge_id, "chat_badge_id");
        Intrinsics.e(chat_badge_url, "chat_badge_url");
        Intrinsics.e(chat_badge_name, "chat_badge_name");
        Intrinsics.e(chat_badge_expire_time, "chat_badge_expire_time");
        Intrinsics.e(chat_badge_package_url, "chat_badge_package_url");
        return new LiveGiftBagChatBadgeModel(chat_badge_id, chat_badge_url, chat_badge_name, i, i2, chat_badge_expire_time, i3, chat_badge_package_url, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftBagChatBadgeModel) {
            LiveGiftBagChatBadgeModel liveGiftBagChatBadgeModel = (LiveGiftBagChatBadgeModel) obj;
            return Intrinsics.a((Object) this.chat_badge_id, (Object) liveGiftBagChatBadgeModel.chat_badge_id) && Intrinsics.a((Object) this.chat_badge_url, (Object) liveGiftBagChatBadgeModel.chat_badge_url) && Intrinsics.a((Object) this.chat_badge_name, (Object) liveGiftBagChatBadgeModel.chat_badge_name) && this.chat_badge_height == liveGiftBagChatBadgeModel.chat_badge_height && this.chat_badge_length == liveGiftBagChatBadgeModel.chat_badge_length && Intrinsics.a((Object) this.chat_badge_expire_time, (Object) liveGiftBagChatBadgeModel.chat_badge_expire_time) && this.is_hide_expire_time == liveGiftBagChatBadgeModel.is_hide_expire_time && Intrinsics.a((Object) this.chat_badge_package_url, (Object) liveGiftBagChatBadgeModel.chat_badge_package_url) && this.is_wear == liveGiftBagChatBadgeModel.is_wear;
        }
        return false;
    }

    public final String getChat_badge_expire_time() {
        return this.chat_badge_expire_time;
    }

    public final int getChat_badge_height() {
        return this.chat_badge_height;
    }

    public final String getChat_badge_id() {
        return this.chat_badge_id;
    }

    public final int getChat_badge_length() {
        return this.chat_badge_length;
    }

    public final String getChat_badge_name() {
        return this.chat_badge_name;
    }

    public final String getChat_badge_package_url() {
        return this.chat_badge_package_url;
    }

    public final String getChat_badge_url() {
        return this.chat_badge_url;
    }

    public int hashCode() {
        return (((((((((((((((this.chat_badge_id.hashCode() * 31) + this.chat_badge_url.hashCode()) * 31) + this.chat_badge_name.hashCode()) * 31) + this.chat_badge_height) * 31) + this.chat_badge_length) * 31) + this.chat_badge_expire_time.hashCode()) * 31) + this.is_hide_expire_time) * 31) + this.chat_badge_package_url.hashCode()) * 31) + this.is_wear;
    }

    public final int is_hide_expire_time() {
        return this.is_hide_expire_time;
    }

    public final int is_wear() {
        return this.is_wear;
    }

    public String toString() {
        return "LiveGiftBagChatBadgeModel(chat_badge_id=" + this.chat_badge_id + ", chat_badge_url=" + this.chat_badge_url + ", chat_badge_name=" + this.chat_badge_name + ", chat_badge_height=" + this.chat_badge_height + ", chat_badge_length=" + this.chat_badge_length + ", chat_badge_expire_time=" + this.chat_badge_expire_time + ", is_hide_expire_time=" + this.is_hide_expire_time + ", chat_badge_package_url=" + this.chat_badge_package_url + ", is_wear=" + this.is_wear + ')';
    }
}
