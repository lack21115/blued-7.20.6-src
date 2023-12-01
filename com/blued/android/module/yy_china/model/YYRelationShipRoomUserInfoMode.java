package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomUserInfoMode.class */
public final class YYRelationShipRoomUserInfoMode {
    private final String avatar;
    private final String name;
    private final String room_id;
    private final String uid;

    public YYRelationShipRoomUserInfoMode(String uid, String room_id, String name, String avatar) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        this.uid = uid;
        this.room_id = room_id;
        this.name = name;
        this.avatar = avatar;
    }

    public static /* synthetic */ YYRelationShipRoomUserInfoMode copy$default(YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRelationShipRoomUserInfoMode.uid;
        }
        if ((i & 2) != 0) {
            str2 = yYRelationShipRoomUserInfoMode.room_id;
        }
        if ((i & 4) != 0) {
            str3 = yYRelationShipRoomUserInfoMode.name;
        }
        if ((i & 8) != 0) {
            str4 = yYRelationShipRoomUserInfoMode.avatar;
        }
        return yYRelationShipRoomUserInfoMode.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.room_id;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.avatar;
    }

    public final YYRelationShipRoomUserInfoMode copy(String uid, String room_id, String name, String avatar) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        return new YYRelationShipRoomUserInfoMode(uid, room_id, name, avatar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomUserInfoMode) {
            YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode = (YYRelationShipRoomUserInfoMode) obj;
            return Intrinsics.a((Object) this.uid, (Object) yYRelationShipRoomUserInfoMode.uid) && Intrinsics.a((Object) this.room_id, (Object) yYRelationShipRoomUserInfoMode.room_id) && Intrinsics.a((Object) this.name, (Object) yYRelationShipRoomUserInfoMode.name) && Intrinsics.a((Object) this.avatar, (Object) yYRelationShipRoomUserInfoMode.avatar);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.uid.hashCode() * 31) + this.room_id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomUserInfoMode(uid=" + this.uid + ", room_id=" + this.room_id + ", name=" + this.name + ", avatar=" + this.avatar + ')';
    }
}
