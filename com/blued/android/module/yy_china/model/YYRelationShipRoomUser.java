package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomUser.class */
public final class YYRelationShipRoomUser implements MultiItemEntity {
    private int anchor_level;
    private String avatar;
    private String avatar_frame;
    private int honor_level;
    private String is_follow;
    private int itemTypes;
    private String name;
    private String online_time;
    private String uid;

    public YYRelationShipRoomUser(int i, String uid, String online_time, int i2, int i3, String is_follow, String avatar, String name, String avatar_frame) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(online_time, "online_time");
        Intrinsics.e(is_follow, "is_follow");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar_frame, "avatar_frame");
        this.itemTypes = i;
        this.uid = uid;
        this.online_time = online_time;
        this.anchor_level = i2;
        this.honor_level = i3;
        this.is_follow = is_follow;
        this.avatar = avatar;
        this.name = name;
        this.avatar_frame = avatar_frame;
    }

    public /* synthetic */ YYRelationShipRoomUser(int i, String str, String str2, int i2, int i3, String str3, String str4, String str5, String str6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, str, str2, i2, i3, str3, str4, str5, str6);
    }

    public static /* synthetic */ YYRelationShipRoomUser copy$default(YYRelationShipRoomUser yYRelationShipRoomUser, int i, String str, String str2, int i2, int i3, String str3, String str4, String str5, String str6, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = yYRelationShipRoomUser.itemTypes;
        }
        if ((i4 & 2) != 0) {
            str = yYRelationShipRoomUser.uid;
        }
        if ((i4 & 4) != 0) {
            str2 = yYRelationShipRoomUser.online_time;
        }
        if ((i4 & 8) != 0) {
            i2 = yYRelationShipRoomUser.anchor_level;
        }
        if ((i4 & 16) != 0) {
            i3 = yYRelationShipRoomUser.honor_level;
        }
        if ((i4 & 32) != 0) {
            str3 = yYRelationShipRoomUser.is_follow;
        }
        if ((i4 & 64) != 0) {
            str4 = yYRelationShipRoomUser.avatar;
        }
        if ((i4 & 128) != 0) {
            str5 = yYRelationShipRoomUser.name;
        }
        if ((i4 & 256) != 0) {
            str6 = yYRelationShipRoomUser.avatar_frame;
        }
        return yYRelationShipRoomUser.copy(i, str, str2, i2, i3, str3, str4, str5, str6);
    }

    public final int component1() {
        return this.itemTypes;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.online_time;
    }

    public final int component4() {
        return this.anchor_level;
    }

    public final int component5() {
        return this.honor_level;
    }

    public final String component6() {
        return this.is_follow;
    }

    public final String component7() {
        return this.avatar;
    }

    public final String component8() {
        return this.name;
    }

    public final String component9() {
        return this.avatar_frame;
    }

    public final YYRelationShipRoomUser copy(int i, String uid, String online_time, int i2, int i3, String is_follow, String avatar, String name, String avatar_frame) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(online_time, "online_time");
        Intrinsics.e(is_follow, "is_follow");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar_frame, "avatar_frame");
        return new YYRelationShipRoomUser(i, uid, online_time, i2, i3, is_follow, avatar, name, avatar_frame);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomUser) {
            YYRelationShipRoomUser yYRelationShipRoomUser = (YYRelationShipRoomUser) obj;
            return this.itemTypes == yYRelationShipRoomUser.itemTypes && Intrinsics.a((Object) this.uid, (Object) yYRelationShipRoomUser.uid) && Intrinsics.a((Object) this.online_time, (Object) yYRelationShipRoomUser.online_time) && this.anchor_level == yYRelationShipRoomUser.anchor_level && this.honor_level == yYRelationShipRoomUser.honor_level && Intrinsics.a((Object) this.is_follow, (Object) yYRelationShipRoomUser.is_follow) && Intrinsics.a((Object) this.avatar, (Object) yYRelationShipRoomUser.avatar) && Intrinsics.a((Object) this.name, (Object) yYRelationShipRoomUser.name) && Intrinsics.a((Object) this.avatar_frame, (Object) yYRelationShipRoomUser.avatar_frame);
        }
        return false;
    }

    public final int getAnchor_level() {
        return this.anchor_level;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final int getHonor_level() {
        return this.honor_level;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemTypes;
    }

    public final int getItemTypes() {
        return this.itemTypes;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOnline_time() {
        return this.online_time;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((((((((this.itemTypes * 31) + this.uid.hashCode()) * 31) + this.online_time.hashCode()) * 31) + this.anchor_level) * 31) + this.honor_level) * 31) + this.is_follow.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.name.hashCode()) * 31) + this.avatar_frame.hashCode();
    }

    public final String is_follow() {
        return this.is_follow;
    }

    public final void setAnchor_level(int i) {
        this.anchor_level = i;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatar_frame(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar_frame = str;
    }

    public final void setHonor_level(int i) {
        this.honor_level = i;
    }

    public final void setItemTypes(int i) {
        this.itemTypes = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setOnline_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.online_time = str;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public final void set_follow(String str) {
        Intrinsics.e(str, "<set-?>");
        this.is_follow = str;
    }

    public String toString() {
        return "YYRelationShipRoomUser(itemTypes=" + this.itemTypes + ", uid=" + this.uid + ", online_time=" + this.online_time + ", anchor_level=" + this.anchor_level + ", honor_level=" + this.honor_level + ", is_follow=" + this.is_follow + ", avatar=" + this.avatar + ", name=" + this.name + ", avatar_frame=" + this.avatar_frame + ')';
    }
}
