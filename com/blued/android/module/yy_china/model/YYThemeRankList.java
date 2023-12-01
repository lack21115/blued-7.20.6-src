package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYThemeRankList.class */
public final class YYThemeRankList {
    private final String avatar;
    private final String id;
    private final String name;
    private final String uid;
    private final String value;

    public YYThemeRankList(String id, String uid, String name, String avatar, String value) {
        Intrinsics.e(id, "id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(value, "value");
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
        this.value = value;
    }

    public static /* synthetic */ YYThemeRankList copy$default(YYThemeRankList yYThemeRankList, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYThemeRankList.id;
        }
        if ((i & 2) != 0) {
            str2 = yYThemeRankList.uid;
        }
        if ((i & 4) != 0) {
            str3 = yYThemeRankList.name;
        }
        if ((i & 8) != 0) {
            str4 = yYThemeRankList.avatar;
        }
        if ((i & 16) != 0) {
            str5 = yYThemeRankList.value;
        }
        return yYThemeRankList.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.avatar;
    }

    public final String component5() {
        return this.value;
    }

    public final YYThemeRankList copy(String id, String uid, String name, String avatar, String value) {
        Intrinsics.e(id, "id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(value, "value");
        return new YYThemeRankList(id, uid, name, avatar, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYThemeRankList) {
            YYThemeRankList yYThemeRankList = (YYThemeRankList) obj;
            return Intrinsics.a((Object) this.id, (Object) yYThemeRankList.id) && Intrinsics.a((Object) this.uid, (Object) yYThemeRankList.uid) && Intrinsics.a((Object) this.name, (Object) yYThemeRankList.name) && Intrinsics.a((Object) this.avatar, (Object) yYThemeRankList.avatar) && Intrinsics.a((Object) this.value, (Object) yYThemeRankList.value);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.uid.hashCode()) * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "YYThemeRankList(id=" + this.id + ", uid=" + this.uid + ", name=" + this.name + ", avatar=" + this.avatar + ", value=" + this.value + ')';
    }
}
