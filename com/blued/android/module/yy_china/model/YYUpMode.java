package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYUpMode.class */
public final class YYUpMode {
    private final String avatar;
    private String broadcast_background;
    private final String level;
    private final String material;
    private final String name;
    private final String room_id;
    private final String uid;

    public YYUpMode(String material, String room_id, String level, String name, String avatar, String uid, String broadcast_background) {
        Intrinsics.e(material, "material");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(level, "level");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(broadcast_background, "broadcast_background");
        this.material = material;
        this.room_id = room_id;
        this.level = level;
        this.name = name;
        this.avatar = avatar;
        this.uid = uid;
        this.broadcast_background = broadcast_background;
    }

    public static /* synthetic */ YYUpMode copy$default(YYUpMode yYUpMode, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYUpMode.material;
        }
        if ((i & 2) != 0) {
            str2 = yYUpMode.room_id;
        }
        if ((i & 4) != 0) {
            str3 = yYUpMode.level;
        }
        if ((i & 8) != 0) {
            str4 = yYUpMode.name;
        }
        if ((i & 16) != 0) {
            str5 = yYUpMode.avatar;
        }
        if ((i & 32) != 0) {
            str6 = yYUpMode.uid;
        }
        if ((i & 64) != 0) {
            str7 = yYUpMode.broadcast_background;
        }
        return yYUpMode.copy(str, str2, str3, str4, str5, str6, str7);
    }

    public final String component1() {
        return this.material;
    }

    public final String component2() {
        return this.room_id;
    }

    public final String component3() {
        return this.level;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.avatar;
    }

    public final String component6() {
        return this.uid;
    }

    public final String component7() {
        return this.broadcast_background;
    }

    public final YYUpMode copy(String material, String room_id, String level, String name, String avatar, String uid, String broadcast_background) {
        Intrinsics.e(material, "material");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(level, "level");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(broadcast_background, "broadcast_background");
        return new YYUpMode(material, room_id, level, name, avatar, uid, broadcast_background);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYUpMode) {
            YYUpMode yYUpMode = (YYUpMode) obj;
            return Intrinsics.a((Object) this.material, (Object) yYUpMode.material) && Intrinsics.a((Object) this.room_id, (Object) yYUpMode.room_id) && Intrinsics.a((Object) this.level, (Object) yYUpMode.level) && Intrinsics.a((Object) this.name, (Object) yYUpMode.name) && Intrinsics.a((Object) this.avatar, (Object) yYUpMode.avatar) && Intrinsics.a((Object) this.uid, (Object) yYUpMode.uid) && Intrinsics.a((Object) this.broadcast_background, (Object) yYUpMode.broadcast_background);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBroadcast_background() {
        return this.broadcast_background;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getMaterial() {
        return this.material;
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
        return (((((((((((this.material.hashCode() * 31) + this.room_id.hashCode()) * 31) + this.level.hashCode()) * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.broadcast_background.hashCode();
    }

    public final void setBroadcast_background(String str) {
        Intrinsics.e(str, "<set-?>");
        this.broadcast_background = str;
    }

    public String toString() {
        return "YYUpMode(material=" + this.material + ", room_id=" + this.room_id + ", level=" + this.level + ", name=" + this.name + ", avatar=" + this.avatar + ", uid=" + this.uid + ", broadcast_background=" + this.broadcast_background + ')';
    }
}
