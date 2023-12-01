package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGoodsBehalfExtra.class */
public final class LiveGoodsBehalfExtra {
    private String popover_desc;
    private String popover_title;
    private int status;
    private String switch_disable_name;
    private String switch_enable_name;
    private String target_avatar;
    private String target_uid;
    private String target_username;

    public LiveGoodsBehalfExtra(int i, String target_username, String target_avatar, String target_uid, String switch_enable_name, String switch_disable_name, String popover_title, String popover_desc) {
        Intrinsics.e(target_username, "target_username");
        Intrinsics.e(target_avatar, "target_avatar");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(switch_enable_name, "switch_enable_name");
        Intrinsics.e(switch_disable_name, "switch_disable_name");
        Intrinsics.e(popover_title, "popover_title");
        Intrinsics.e(popover_desc, "popover_desc");
        this.status = i;
        this.target_username = target_username;
        this.target_avatar = target_avatar;
        this.target_uid = target_uid;
        this.switch_enable_name = switch_enable_name;
        this.switch_disable_name = switch_disable_name;
        this.popover_title = popover_title;
        this.popover_desc = popover_desc;
    }

    public static /* synthetic */ LiveGoodsBehalfExtra copy$default(LiveGoodsBehalfExtra liveGoodsBehalfExtra, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = liveGoodsBehalfExtra.status;
        }
        if ((i2 & 2) != 0) {
            str = liveGoodsBehalfExtra.target_username;
        }
        if ((i2 & 4) != 0) {
            str2 = liveGoodsBehalfExtra.target_avatar;
        }
        if ((i2 & 8) != 0) {
            str3 = liveGoodsBehalfExtra.target_uid;
        }
        if ((i2 & 16) != 0) {
            str4 = liveGoodsBehalfExtra.switch_enable_name;
        }
        if ((i2 & 32) != 0) {
            str5 = liveGoodsBehalfExtra.switch_disable_name;
        }
        if ((i2 & 64) != 0) {
            str6 = liveGoodsBehalfExtra.popover_title;
        }
        if ((i2 & 128) != 0) {
            str7 = liveGoodsBehalfExtra.popover_desc;
        }
        return liveGoodsBehalfExtra.copy(i, str, str2, str3, str4, str5, str6, str7);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.target_username;
    }

    public final String component3() {
        return this.target_avatar;
    }

    public final String component4() {
        return this.target_uid;
    }

    public final String component5() {
        return this.switch_enable_name;
    }

    public final String component6() {
        return this.switch_disable_name;
    }

    public final String component7() {
        return this.popover_title;
    }

    public final String component8() {
        return this.popover_desc;
    }

    public final LiveGoodsBehalfExtra copy(int i, String target_username, String target_avatar, String target_uid, String switch_enable_name, String switch_disable_name, String popover_title, String popover_desc) {
        Intrinsics.e(target_username, "target_username");
        Intrinsics.e(target_avatar, "target_avatar");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(switch_enable_name, "switch_enable_name");
        Intrinsics.e(switch_disable_name, "switch_disable_name");
        Intrinsics.e(popover_title, "popover_title");
        Intrinsics.e(popover_desc, "popover_desc");
        return new LiveGoodsBehalfExtra(i, target_username, target_avatar, target_uid, switch_enable_name, switch_disable_name, popover_title, popover_desc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGoodsBehalfExtra) {
            LiveGoodsBehalfExtra liveGoodsBehalfExtra = (LiveGoodsBehalfExtra) obj;
            return this.status == liveGoodsBehalfExtra.status && Intrinsics.a((Object) this.target_username, (Object) liveGoodsBehalfExtra.target_username) && Intrinsics.a((Object) this.target_avatar, (Object) liveGoodsBehalfExtra.target_avatar) && Intrinsics.a((Object) this.target_uid, (Object) liveGoodsBehalfExtra.target_uid) && Intrinsics.a((Object) this.switch_enable_name, (Object) liveGoodsBehalfExtra.switch_enable_name) && Intrinsics.a((Object) this.switch_disable_name, (Object) liveGoodsBehalfExtra.switch_disable_name) && Intrinsics.a((Object) this.popover_title, (Object) liveGoodsBehalfExtra.popover_title) && Intrinsics.a((Object) this.popover_desc, (Object) liveGoodsBehalfExtra.popover_desc);
        }
        return false;
    }

    public final String getPopover_desc() {
        return this.popover_desc;
    }

    public final String getPopover_title() {
        return this.popover_title;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSwitch_disable_name() {
        return this.switch_disable_name;
    }

    public final String getSwitch_enable_name() {
        return this.switch_enable_name;
    }

    public final String getTarget_avatar() {
        return this.target_avatar;
    }

    public final String getTarget_uid() {
        return this.target_uid;
    }

    public final String getTarget_username() {
        return this.target_username;
    }

    public int hashCode() {
        return (((((((((((((this.status * 31) + this.target_username.hashCode()) * 31) + this.target_avatar.hashCode()) * 31) + this.target_uid.hashCode()) * 31) + this.switch_enable_name.hashCode()) * 31) + this.switch_disable_name.hashCode()) * 31) + this.popover_title.hashCode()) * 31) + this.popover_desc.hashCode();
    }

    public final void setPopover_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.popover_desc = str;
    }

    public final void setPopover_title(String str) {
        Intrinsics.e(str, "<set-?>");
        this.popover_title = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setSwitch_disable_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.switch_disable_name = str;
    }

    public final void setSwitch_enable_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.switch_enable_name = str;
    }

    public final void setTarget_avatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.target_avatar = str;
    }

    public final void setTarget_uid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.target_uid = str;
    }

    public final void setTarget_username(String str) {
        Intrinsics.e(str, "<set-?>");
        this.target_username = str;
    }

    public String toString() {
        return "LiveGoodsBehalfExtra(status=" + this.status + ", target_username=" + this.target_username + ", target_avatar=" + this.target_avatar + ", target_uid=" + this.target_uid + ", switch_enable_name=" + this.switch_enable_name + ", switch_disable_name=" + this.switch_disable_name + ", popover_title=" + this.popover_title + ", popover_desc=" + this.popover_desc + ')';
    }
}
