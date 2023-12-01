package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFirstUserInfoMode.class */
public final class YYFirstUserInfoMode {
    private final String avatar;
    private final String name;
    private final String uid;

    public YYFirstUserInfoMode(String uid, String name, String avatar) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
    }

    public static /* synthetic */ YYFirstUserInfoMode copy$default(YYFirstUserInfoMode yYFirstUserInfoMode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYFirstUserInfoMode.uid;
        }
        if ((i & 2) != 0) {
            str2 = yYFirstUserInfoMode.name;
        }
        if ((i & 4) != 0) {
            str3 = yYFirstUserInfoMode.avatar;
        }
        return yYFirstUserInfoMode.copy(str, str2, str3);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatar;
    }

    public final YYFirstUserInfoMode copy(String uid, String name, String avatar) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        return new YYFirstUserInfoMode(uid, name, avatar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYFirstUserInfoMode) {
            YYFirstUserInfoMode yYFirstUserInfoMode = (YYFirstUserInfoMode) obj;
            return Intrinsics.a((Object) this.uid, (Object) yYFirstUserInfoMode.uid) && Intrinsics.a((Object) this.name, (Object) yYFirstUserInfoMode.name) && Intrinsics.a((Object) this.avatar, (Object) yYFirstUserInfoMode.avatar);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode();
    }

    public String toString() {
        return "YYFirstUserInfoMode(uid=" + this.uid + ", name=" + this.name + ", avatar=" + this.avatar + ')';
    }
}
