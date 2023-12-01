package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/FullServiceSquareMode.class */
public final class FullServiceSquareMode implements MultiItemEntity {
    private final String avatar;
    private final FullServiceSquareResourcesMode extra_resources;
    private final String id;
    private final int is_voice_online;
    private final String link;
    private final String name;
    private final String room_id;
    private final String title;
    private final int type;
    private final String uid;

    public FullServiceSquareMode(String id, String uid, String room_id, int i, String title, String link, String avatar, String name, FullServiceSquareResourcesMode extra_resources, int i2) {
        Intrinsics.e(id, "id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(title, "title");
        Intrinsics.e(link, "link");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(name, "name");
        Intrinsics.e(extra_resources, "extra_resources");
        this.id = id;
        this.uid = uid;
        this.room_id = room_id;
        this.type = i;
        this.title = title;
        this.link = link;
        this.avatar = avatar;
        this.name = name;
        this.extra_resources = extra_resources;
        this.is_voice_online = i2;
    }

    public static /* synthetic */ FullServiceSquareMode copy$default(FullServiceSquareMode fullServiceSquareMode, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, FullServiceSquareResourcesMode fullServiceSquareResourcesMode, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fullServiceSquareMode.id;
        }
        if ((i3 & 2) != 0) {
            str2 = fullServiceSquareMode.uid;
        }
        if ((i3 & 4) != 0) {
            str3 = fullServiceSquareMode.room_id;
        }
        if ((i3 & 8) != 0) {
            i = fullServiceSquareMode.type;
        }
        if ((i3 & 16) != 0) {
            str4 = fullServiceSquareMode.title;
        }
        if ((i3 & 32) != 0) {
            str5 = fullServiceSquareMode.link;
        }
        if ((i3 & 64) != 0) {
            str6 = fullServiceSquareMode.avatar;
        }
        if ((i3 & 128) != 0) {
            str7 = fullServiceSquareMode.name;
        }
        if ((i3 & 256) != 0) {
            fullServiceSquareResourcesMode = fullServiceSquareMode.extra_resources;
        }
        if ((i3 & 512) != 0) {
            i2 = fullServiceSquareMode.is_voice_online;
        }
        return fullServiceSquareMode.copy(str, str2, str3, i, str4, str5, str6, str7, fullServiceSquareResourcesMode, i2);
    }

    public final String component1() {
        return this.id;
    }

    public final int component10() {
        return this.is_voice_online;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.room_id;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.link;
    }

    public final String component7() {
        return this.avatar;
    }

    public final String component8() {
        return this.name;
    }

    public final FullServiceSquareResourcesMode component9() {
        return this.extra_resources;
    }

    public final FullServiceSquareMode copy(String id, String uid, String room_id, int i, String title, String link, String avatar, String name, FullServiceSquareResourcesMode extra_resources, int i2) {
        Intrinsics.e(id, "id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(title, "title");
        Intrinsics.e(link, "link");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(name, "name");
        Intrinsics.e(extra_resources, "extra_resources");
        return new FullServiceSquareMode(id, uid, room_id, i, title, link, avatar, name, extra_resources, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FullServiceSquareMode) {
            FullServiceSquareMode fullServiceSquareMode = (FullServiceSquareMode) obj;
            return Intrinsics.a((Object) this.id, (Object) fullServiceSquareMode.id) && Intrinsics.a((Object) this.uid, (Object) fullServiceSquareMode.uid) && Intrinsics.a((Object) this.room_id, (Object) fullServiceSquareMode.room_id) && this.type == fullServiceSquareMode.type && Intrinsics.a((Object) this.title, (Object) fullServiceSquareMode.title) && Intrinsics.a((Object) this.link, (Object) fullServiceSquareMode.link) && Intrinsics.a((Object) this.avatar, (Object) fullServiceSquareMode.avatar) && Intrinsics.a((Object) this.name, (Object) fullServiceSquareMode.name) && Intrinsics.a(this.extra_resources, fullServiceSquareMode.extra_resources) && this.is_voice_online == fullServiceSquareMode.is_voice_online;
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final FullServiceSquareResourcesMode getExtra_resources() {
        return this.extra_resources;
    }

    public final String getId() {
        return this.id;
    }

    public int getItemType() {
        return this.type;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((((((((((this.id.hashCode() * 31) + this.uid.hashCode()) * 31) + this.room_id.hashCode()) * 31) + this.type) * 31) + this.title.hashCode()) * 31) + this.link.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.name.hashCode()) * 31) + this.extra_resources.hashCode()) * 31) + this.is_voice_online;
    }

    public final int is_voice_online() {
        return this.is_voice_online;
    }

    public String toString() {
        return "FullServiceSquareMode(id=" + this.id + ", uid=" + this.uid + ", room_id=" + this.room_id + ", type=" + this.type + ", title=" + this.title + ", link=" + this.link + ", avatar=" + this.avatar + ", name=" + this.name + ", extra_resources=" + this.extra_resources + ", is_voice_online=" + this.is_voice_online + ')';
    }
}
