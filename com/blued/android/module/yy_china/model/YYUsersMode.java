package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYUsersMode.class */
public final class YYUsersMode {
    private final String avatar;
    private final String name;
    private final String room_role;
    private final String uid;

    public YYUsersMode(String name, String uid, String avatar, String room_role) {
        Intrinsics.e(name, "name");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(room_role, "room_role");
        this.name = name;
        this.uid = uid;
        this.avatar = avatar;
        this.room_role = room_role;
    }

    public static /* synthetic */ YYUsersMode copy$default(YYUsersMode yYUsersMode, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYUsersMode.name;
        }
        if ((i & 2) != 0) {
            str2 = yYUsersMode.uid;
        }
        if ((i & 4) != 0) {
            str3 = yYUsersMode.avatar;
        }
        if ((i & 8) != 0) {
            str4 = yYUsersMode.room_role;
        }
        return yYUsersMode.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.room_role;
    }

    public final YYUsersMode copy(String name, String uid, String avatar, String room_role) {
        Intrinsics.e(name, "name");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(room_role, "room_role");
        return new YYUsersMode(name, uid, avatar, room_role);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYUsersMode) {
            YYUsersMode yYUsersMode = (YYUsersMode) obj;
            return Intrinsics.a((Object) this.name, (Object) yYUsersMode.name) && Intrinsics.a((Object) this.uid, (Object) yYUsersMode.uid) && Intrinsics.a((Object) this.avatar, (Object) yYUsersMode.avatar) && Intrinsics.a((Object) this.room_role, (Object) yYUsersMode.room_role);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoom_role() {
        return this.room_role;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.uid.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.room_role.hashCode();
    }

    public String toString() {
        return "YYUsersMode(name=" + this.name + ", uid=" + this.uid + ", avatar=" + this.avatar + ", room_role=" + this.room_role + ')';
    }
}
