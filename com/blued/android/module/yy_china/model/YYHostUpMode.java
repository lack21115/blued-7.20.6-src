package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHostUpMode.class */
public final class YYHostUpMode {
    private final String anchor_level;
    private final String anchor_uid;
    private final String avatar;
    private final String broadcast_background;
    private final String content;
    private final String material;
    private final String name;
    private final String roomid;

    public YYHostUpMode(String material, String roomid, String content, String anchor_level, String name, String avatar, String anchor_uid, String broadcast_background) {
        Intrinsics.e(material, "material");
        Intrinsics.e(roomid, "roomid");
        Intrinsics.e(content, "content");
        Intrinsics.e(anchor_level, "anchor_level");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(anchor_uid, "anchor_uid");
        Intrinsics.e(broadcast_background, "broadcast_background");
        this.material = material;
        this.roomid = roomid;
        this.content = content;
        this.anchor_level = anchor_level;
        this.name = name;
        this.avatar = avatar;
        this.anchor_uid = anchor_uid;
        this.broadcast_background = broadcast_background;
    }

    public static /* synthetic */ YYHostUpMode copy$default(YYHostUpMode yYHostUpMode, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYHostUpMode.material;
        }
        if ((i & 2) != 0) {
            str2 = yYHostUpMode.roomid;
        }
        if ((i & 4) != 0) {
            str3 = yYHostUpMode.content;
        }
        if ((i & 8) != 0) {
            str4 = yYHostUpMode.anchor_level;
        }
        if ((i & 16) != 0) {
            str5 = yYHostUpMode.name;
        }
        if ((i & 32) != 0) {
            str6 = yYHostUpMode.avatar;
        }
        if ((i & 64) != 0) {
            str7 = yYHostUpMode.anchor_uid;
        }
        if ((i & 128) != 0) {
            str8 = yYHostUpMode.broadcast_background;
        }
        return yYHostUpMode.copy(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final String component1() {
        return this.material;
    }

    public final String component2() {
        return this.roomid;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.anchor_level;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.avatar;
    }

    public final String component7() {
        return this.anchor_uid;
    }

    public final String component8() {
        return this.broadcast_background;
    }

    public final YYHostUpMode copy(String material, String roomid, String content, String anchor_level, String name, String avatar, String anchor_uid, String broadcast_background) {
        Intrinsics.e(material, "material");
        Intrinsics.e(roomid, "roomid");
        Intrinsics.e(content, "content");
        Intrinsics.e(anchor_level, "anchor_level");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(anchor_uid, "anchor_uid");
        Intrinsics.e(broadcast_background, "broadcast_background");
        return new YYHostUpMode(material, roomid, content, anchor_level, name, avatar, anchor_uid, broadcast_background);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYHostUpMode) {
            YYHostUpMode yYHostUpMode = (YYHostUpMode) obj;
            return Intrinsics.a((Object) this.material, (Object) yYHostUpMode.material) && Intrinsics.a((Object) this.roomid, (Object) yYHostUpMode.roomid) && Intrinsics.a((Object) this.content, (Object) yYHostUpMode.content) && Intrinsics.a((Object) this.anchor_level, (Object) yYHostUpMode.anchor_level) && Intrinsics.a((Object) this.name, (Object) yYHostUpMode.name) && Intrinsics.a((Object) this.avatar, (Object) yYHostUpMode.avatar) && Intrinsics.a((Object) this.anchor_uid, (Object) yYHostUpMode.anchor_uid) && Intrinsics.a((Object) this.broadcast_background, (Object) yYHostUpMode.broadcast_background);
        }
        return false;
    }

    public final String getAnchor_level() {
        return this.anchor_level;
    }

    public final String getAnchor_uid() {
        return this.anchor_uid;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBroadcast_background() {
        return this.broadcast_background;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getMaterial() {
        return this.material;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoomid() {
        return this.roomid;
    }

    public int hashCode() {
        return (((((((((((((this.material.hashCode() * 31) + this.roomid.hashCode()) * 31) + this.content.hashCode()) * 31) + this.anchor_level.hashCode()) * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.anchor_uid.hashCode()) * 31) + this.broadcast_background.hashCode();
    }

    public String toString() {
        return "YYHostUpMode(material=" + this.material + ", roomid=" + this.roomid + ", content=" + this.content + ", anchor_level=" + this.anchor_level + ", name=" + this.name + ", avatar=" + this.avatar + ", anchor_uid=" + this.anchor_uid + ", broadcast_background=" + this.broadcast_background + ')';
    }
}
