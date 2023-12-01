package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/WeekStarInfoMode.class */
public final class WeekStarInfoMode {
    private final String avatar;
    private final String named;
    private final String nickname;
    private final int room_id;
    private final String uid;

    public WeekStarInfoMode(int i, String uid, String avatar, String nickname, String named) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(nickname, "nickname");
        Intrinsics.e(named, "named");
        this.room_id = i;
        this.uid = uid;
        this.avatar = avatar;
        this.nickname = nickname;
        this.named = named;
    }

    public static /* synthetic */ WeekStarInfoMode copy$default(WeekStarInfoMode weekStarInfoMode, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = weekStarInfoMode.room_id;
        }
        if ((i2 & 2) != 0) {
            str = weekStarInfoMode.uid;
        }
        if ((i2 & 4) != 0) {
            str2 = weekStarInfoMode.avatar;
        }
        if ((i2 & 8) != 0) {
            str3 = weekStarInfoMode.nickname;
        }
        if ((i2 & 16) != 0) {
            str4 = weekStarInfoMode.named;
        }
        return weekStarInfoMode.copy(i, str, str2, str3, str4);
    }

    public final int component1() {
        return this.room_id;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.nickname;
    }

    public final String component5() {
        return this.named;
    }

    public final WeekStarInfoMode copy(int i, String uid, String avatar, String nickname, String named) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(nickname, "nickname");
        Intrinsics.e(named, "named");
        return new WeekStarInfoMode(i, uid, avatar, nickname, named);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WeekStarInfoMode) {
            WeekStarInfoMode weekStarInfoMode = (WeekStarInfoMode) obj;
            return this.room_id == weekStarInfoMode.room_id && Intrinsics.a((Object) this.uid, (Object) weekStarInfoMode.uid) && Intrinsics.a((Object) this.avatar, (Object) weekStarInfoMode.avatar) && Intrinsics.a((Object) this.nickname, (Object) weekStarInfoMode.nickname) && Intrinsics.a((Object) this.named, (Object) weekStarInfoMode.named);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNamed() {
        return this.named;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final int getRoom_id() {
        return this.room_id;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((this.room_id * 31) + this.uid.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.named.hashCode();
    }

    public String toString() {
        return "WeekStarInfoMode(room_id=" + this.room_id + ", uid=" + this.uid + ", avatar=" + this.avatar + ", nickname=" + this.nickname + ", named=" + this.named + ')';
    }
}
