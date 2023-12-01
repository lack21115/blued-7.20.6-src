package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/FullServiceSquareResourcesMode.class */
public final class FullServiceSquareResourcesMode {
    private final String badge;
    private final String gift_name;
    private final String gift_pic;
    private final int is_voice_online;
    private final String level;
    private final String room_id;
    private final String target_avatar;
    private final String target_name;
    private final String target_uid;
    private final int type;

    public FullServiceSquareResourcesMode(int i, String target_uid, String gift_name, String target_name, String gift_pic, String target_avatar, String badge, String level, int i2, String room_id) {
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(gift_name, "gift_name");
        Intrinsics.e(target_name, "target_name");
        Intrinsics.e(gift_pic, "gift_pic");
        Intrinsics.e(target_avatar, "target_avatar");
        Intrinsics.e(badge, "badge");
        Intrinsics.e(level, "level");
        Intrinsics.e(room_id, "room_id");
        this.type = i;
        this.target_uid = target_uid;
        this.gift_name = gift_name;
        this.target_name = target_name;
        this.gift_pic = gift_pic;
        this.target_avatar = target_avatar;
        this.badge = badge;
        this.level = level;
        this.is_voice_online = i2;
        this.room_id = room_id;
    }

    public static /* synthetic */ FullServiceSquareResourcesMode copy$default(FullServiceSquareResourcesMode fullServiceSquareResourcesMode, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = fullServiceSquareResourcesMode.type;
        }
        if ((i3 & 2) != 0) {
            str = fullServiceSquareResourcesMode.target_uid;
        }
        if ((i3 & 4) != 0) {
            str2 = fullServiceSquareResourcesMode.gift_name;
        }
        if ((i3 & 8) != 0) {
            str3 = fullServiceSquareResourcesMode.target_name;
        }
        if ((i3 & 16) != 0) {
            str4 = fullServiceSquareResourcesMode.gift_pic;
        }
        if ((i3 & 32) != 0) {
            str5 = fullServiceSquareResourcesMode.target_avatar;
        }
        if ((i3 & 64) != 0) {
            str6 = fullServiceSquareResourcesMode.badge;
        }
        if ((i3 & 128) != 0) {
            str7 = fullServiceSquareResourcesMode.level;
        }
        if ((i3 & 256) != 0) {
            i2 = fullServiceSquareResourcesMode.is_voice_online;
        }
        if ((i3 & 512) != 0) {
            str8 = fullServiceSquareResourcesMode.room_id;
        }
        return fullServiceSquareResourcesMode.copy(i, str, str2, str3, str4, str5, str6, str7, i2, str8);
    }

    public final int component1() {
        return this.type;
    }

    public final String component10() {
        return this.room_id;
    }

    public final String component2() {
        return this.target_uid;
    }

    public final String component3() {
        return this.gift_name;
    }

    public final String component4() {
        return this.target_name;
    }

    public final String component5() {
        return this.gift_pic;
    }

    public final String component6() {
        return this.target_avatar;
    }

    public final String component7() {
        return this.badge;
    }

    public final String component8() {
        return this.level;
    }

    public final int component9() {
        return this.is_voice_online;
    }

    public final FullServiceSquareResourcesMode copy(int i, String target_uid, String gift_name, String target_name, String gift_pic, String target_avatar, String badge, String level, int i2, String room_id) {
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(gift_name, "gift_name");
        Intrinsics.e(target_name, "target_name");
        Intrinsics.e(gift_pic, "gift_pic");
        Intrinsics.e(target_avatar, "target_avatar");
        Intrinsics.e(badge, "badge");
        Intrinsics.e(level, "level");
        Intrinsics.e(room_id, "room_id");
        return new FullServiceSquareResourcesMode(i, target_uid, gift_name, target_name, gift_pic, target_avatar, badge, level, i2, room_id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FullServiceSquareResourcesMode) {
            FullServiceSquareResourcesMode fullServiceSquareResourcesMode = (FullServiceSquareResourcesMode) obj;
            return this.type == fullServiceSquareResourcesMode.type && Intrinsics.a((Object) this.target_uid, (Object) fullServiceSquareResourcesMode.target_uid) && Intrinsics.a((Object) this.gift_name, (Object) fullServiceSquareResourcesMode.gift_name) && Intrinsics.a((Object) this.target_name, (Object) fullServiceSquareResourcesMode.target_name) && Intrinsics.a((Object) this.gift_pic, (Object) fullServiceSquareResourcesMode.gift_pic) && Intrinsics.a((Object) this.target_avatar, (Object) fullServiceSquareResourcesMode.target_avatar) && Intrinsics.a((Object) this.badge, (Object) fullServiceSquareResourcesMode.badge) && Intrinsics.a((Object) this.level, (Object) fullServiceSquareResourcesMode.level) && this.is_voice_online == fullServiceSquareResourcesMode.is_voice_online && Intrinsics.a((Object) this.room_id, (Object) fullServiceSquareResourcesMode.room_id);
        }
        return false;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final String getGift_name() {
        return this.gift_name;
    }

    public final String getGift_pic() {
        return this.gift_pic;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final String getTarget_avatar() {
        return this.target_avatar;
    }

    public final String getTarget_name() {
        return this.target_name;
    }

    public final String getTarget_uid() {
        return this.target_uid;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((((((this.type * 31) + this.target_uid.hashCode()) * 31) + this.gift_name.hashCode()) * 31) + this.target_name.hashCode()) * 31) + this.gift_pic.hashCode()) * 31) + this.target_avatar.hashCode()) * 31) + this.badge.hashCode()) * 31) + this.level.hashCode()) * 31) + this.is_voice_online) * 31) + this.room_id.hashCode();
    }

    public final int is_voice_online() {
        return this.is_voice_online;
    }

    public String toString() {
        return "FullServiceSquareResourcesMode(type=" + this.type + ", target_uid=" + this.target_uid + ", gift_name=" + this.gift_name + ", target_name=" + this.target_name + ", gift_pic=" + this.gift_pic + ", target_avatar=" + this.target_avatar + ", badge=" + this.badge + ", level=" + this.level + ", is_voice_online=" + this.is_voice_online + ", room_id=" + this.room_id + ')';
    }
}
