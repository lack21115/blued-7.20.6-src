package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ConfessedUserMode.class */
public final class ConfessedUserMode {
    private final int anchor_level;
    private final String avatar;
    private final int chat_anchor;
    private final int honor_level;
    private final String name;
    private final int room_id;
    private final String uid;

    public ConfessedUserMode(String avatar, String name, String uid, int i, int i2, int i3, int i4) {
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(name, "name");
        Intrinsics.e(uid, "uid");
        this.avatar = avatar;
        this.name = name;
        this.uid = uid;
        this.room_id = i;
        this.chat_anchor = i2;
        this.anchor_level = i3;
        this.honor_level = i4;
    }

    public static /* synthetic */ ConfessedUserMode copy$default(ConfessedUserMode confessedUserMode, String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = confessedUserMode.avatar;
        }
        if ((i5 & 2) != 0) {
            str2 = confessedUserMode.name;
        }
        if ((i5 & 4) != 0) {
            str3 = confessedUserMode.uid;
        }
        if ((i5 & 8) != 0) {
            i = confessedUserMode.room_id;
        }
        if ((i5 & 16) != 0) {
            i2 = confessedUserMode.chat_anchor;
        }
        if ((i5 & 32) != 0) {
            i3 = confessedUserMode.anchor_level;
        }
        if ((i5 & 64) != 0) {
            i4 = confessedUserMode.honor_level;
        }
        return confessedUserMode.copy(str, str2, str3, i, i2, i3, i4);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.uid;
    }

    public final int component4() {
        return this.room_id;
    }

    public final int component5() {
        return this.chat_anchor;
    }

    public final int component6() {
        return this.anchor_level;
    }

    public final int component7() {
        return this.honor_level;
    }

    public final ConfessedUserMode copy(String avatar, String name, String uid, int i, int i2, int i3, int i4) {
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(name, "name");
        Intrinsics.e(uid, "uid");
        return new ConfessedUserMode(avatar, name, uid, i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfessedUserMode) {
            ConfessedUserMode confessedUserMode = (ConfessedUserMode) obj;
            return Intrinsics.a((Object) this.avatar, (Object) confessedUserMode.avatar) && Intrinsics.a((Object) this.name, (Object) confessedUserMode.name) && Intrinsics.a((Object) this.uid, (Object) confessedUserMode.uid) && this.room_id == confessedUserMode.room_id && this.chat_anchor == confessedUserMode.chat_anchor && this.anchor_level == confessedUserMode.anchor_level && this.honor_level == confessedUserMode.honor_level;
        }
        return false;
    }

    public final int getAnchor_level() {
        return this.anchor_level;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getChat_anchor() {
        return this.chat_anchor;
    }

    public final int getHonor_level() {
        return this.honor_level;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRoom_id() {
        return this.room_id;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((((this.avatar.hashCode() * 31) + this.name.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.room_id) * 31) + this.chat_anchor) * 31) + this.anchor_level) * 31) + this.honor_level;
    }

    public String toString() {
        return "ConfessedUserMode(avatar=" + this.avatar + ", name=" + this.name + ", uid=" + this.uid + ", room_id=" + this.room_id + ", chat_anchor=" + this.chat_anchor + ", anchor_level=" + this.anchor_level + ", honor_level=" + this.honor_level + ')';
    }
}
