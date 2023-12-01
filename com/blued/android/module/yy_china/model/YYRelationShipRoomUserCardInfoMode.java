package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomUserCardInfoMode.class */
public final class YYRelationShipRoomUserCardInfoMode {
    private final String confirm_beans;
    private final String data_id;
    private final String day;
    private final String id;
    private int is_hidden;
    private final int is_invite;
    private final YYRelationShipRoomUserLeveLInfoMode level_info;
    private final String score;
    private YYRelationShipRoomUserInfoMode targe_uid_profile;
    private int target_uid_hidden;
    private YYRelationShipRoomUserInfoMode uid_profile;

    public YYRelationShipRoomUserCardInfoMode(String id, String data_id, String score, int i, String day, String confirm_beans, YYRelationShipRoomUserInfoMode uid_profile, YYRelationShipRoomUserLeveLInfoMode level_info, YYRelationShipRoomUserInfoMode targe_uid_profile, int i2, int i3) {
        Intrinsics.e(id, "id");
        Intrinsics.e(data_id, "data_id");
        Intrinsics.e(score, "score");
        Intrinsics.e(day, "day");
        Intrinsics.e(confirm_beans, "confirm_beans");
        Intrinsics.e(uid_profile, "uid_profile");
        Intrinsics.e(level_info, "level_info");
        Intrinsics.e(targe_uid_profile, "targe_uid_profile");
        this.id = id;
        this.data_id = data_id;
        this.score = score;
        this.is_invite = i;
        this.day = day;
        this.confirm_beans = confirm_beans;
        this.uid_profile = uid_profile;
        this.level_info = level_info;
        this.targe_uid_profile = targe_uid_profile;
        this.is_hidden = i2;
        this.target_uid_hidden = i3;
    }

    public /* synthetic */ YYRelationShipRoomUserCardInfoMode(String str, String str2, String str3, int i, String str4, String str5, YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode, YYRelationShipRoomUserLeveLInfoMode yYRelationShipRoomUserLeveLInfoMode, YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i4 & 8) != 0 ? 1 : i, str4, str5, yYRelationShipRoomUserInfoMode, yYRelationShipRoomUserLeveLInfoMode, yYRelationShipRoomUserInfoMode2, i2, i3);
    }

    public static /* synthetic */ YYRelationShipRoomUserCardInfoMode copy$default(YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode, String str, String str2, String str3, int i, String str4, String str5, YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode, YYRelationShipRoomUserLeveLInfoMode yYRelationShipRoomUserLeveLInfoMode, YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = yYRelationShipRoomUserCardInfoMode.id;
        }
        if ((i4 & 2) != 0) {
            str2 = yYRelationShipRoomUserCardInfoMode.data_id;
        }
        if ((i4 & 4) != 0) {
            str3 = yYRelationShipRoomUserCardInfoMode.score;
        }
        if ((i4 & 8) != 0) {
            i = yYRelationShipRoomUserCardInfoMode.is_invite;
        }
        if ((i4 & 16) != 0) {
            str4 = yYRelationShipRoomUserCardInfoMode.day;
        }
        if ((i4 & 32) != 0) {
            str5 = yYRelationShipRoomUserCardInfoMode.confirm_beans;
        }
        if ((i4 & 64) != 0) {
            yYRelationShipRoomUserInfoMode = yYRelationShipRoomUserCardInfoMode.uid_profile;
        }
        if ((i4 & 128) != 0) {
            yYRelationShipRoomUserLeveLInfoMode = yYRelationShipRoomUserCardInfoMode.level_info;
        }
        if ((i4 & 256) != 0) {
            yYRelationShipRoomUserInfoMode2 = yYRelationShipRoomUserCardInfoMode.targe_uid_profile;
        }
        if ((i4 & 512) != 0) {
            i2 = yYRelationShipRoomUserCardInfoMode.is_hidden;
        }
        if ((i4 & 1024) != 0) {
            i3 = yYRelationShipRoomUserCardInfoMode.target_uid_hidden;
        }
        return yYRelationShipRoomUserCardInfoMode.copy(str, str2, str3, i, str4, str5, yYRelationShipRoomUserInfoMode, yYRelationShipRoomUserLeveLInfoMode, yYRelationShipRoomUserInfoMode2, i2, i3);
    }

    public final String component1() {
        return this.id;
    }

    public final int component10() {
        return this.is_hidden;
    }

    public final int component11() {
        return this.target_uid_hidden;
    }

    public final String component2() {
        return this.data_id;
    }

    public final String component3() {
        return this.score;
    }

    public final int component4() {
        return this.is_invite;
    }

    public final String component5() {
        return this.day;
    }

    public final String component6() {
        return this.confirm_beans;
    }

    public final YYRelationShipRoomUserInfoMode component7() {
        return this.uid_profile;
    }

    public final YYRelationShipRoomUserLeveLInfoMode component8() {
        return this.level_info;
    }

    public final YYRelationShipRoomUserInfoMode component9() {
        return this.targe_uid_profile;
    }

    public final YYRelationShipRoomUserCardInfoMode copy(String id, String data_id, String score, int i, String day, String confirm_beans, YYRelationShipRoomUserInfoMode uid_profile, YYRelationShipRoomUserLeveLInfoMode level_info, YYRelationShipRoomUserInfoMode targe_uid_profile, int i2, int i3) {
        Intrinsics.e(id, "id");
        Intrinsics.e(data_id, "data_id");
        Intrinsics.e(score, "score");
        Intrinsics.e(day, "day");
        Intrinsics.e(confirm_beans, "confirm_beans");
        Intrinsics.e(uid_profile, "uid_profile");
        Intrinsics.e(level_info, "level_info");
        Intrinsics.e(targe_uid_profile, "targe_uid_profile");
        return new YYRelationShipRoomUserCardInfoMode(id, data_id, score, i, day, confirm_beans, uid_profile, level_info, targe_uid_profile, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomUserCardInfoMode) {
            YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = (YYRelationShipRoomUserCardInfoMode) obj;
            return Intrinsics.a((Object) this.id, (Object) yYRelationShipRoomUserCardInfoMode.id) && Intrinsics.a((Object) this.data_id, (Object) yYRelationShipRoomUserCardInfoMode.data_id) && Intrinsics.a((Object) this.score, (Object) yYRelationShipRoomUserCardInfoMode.score) && this.is_invite == yYRelationShipRoomUserCardInfoMode.is_invite && Intrinsics.a((Object) this.day, (Object) yYRelationShipRoomUserCardInfoMode.day) && Intrinsics.a((Object) this.confirm_beans, (Object) yYRelationShipRoomUserCardInfoMode.confirm_beans) && Intrinsics.a(this.uid_profile, yYRelationShipRoomUserCardInfoMode.uid_profile) && Intrinsics.a(this.level_info, yYRelationShipRoomUserCardInfoMode.level_info) && Intrinsics.a(this.targe_uid_profile, yYRelationShipRoomUserCardInfoMode.targe_uid_profile) && this.is_hidden == yYRelationShipRoomUserCardInfoMode.is_hidden && this.target_uid_hidden == yYRelationShipRoomUserCardInfoMode.target_uid_hidden;
        }
        return false;
    }

    public final String getConfirm_beans() {
        return this.confirm_beans;
    }

    public final String getData_id() {
        return this.data_id;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getId() {
        return this.id;
    }

    public final YYRelationShipRoomUserLeveLInfoMode getLevel_info() {
        return this.level_info;
    }

    public final String getScore() {
        return this.score;
    }

    public final YYRelationShipRoomUserInfoMode getTarge_uid_profile() {
        return this.targe_uid_profile;
    }

    public final int getTarget_uid_hidden() {
        return this.target_uid_hidden;
    }

    public final YYRelationShipRoomUserInfoMode getUid_profile() {
        return this.uid_profile;
    }

    public int hashCode() {
        return (((((((((((((((((((this.id.hashCode() * 31) + this.data_id.hashCode()) * 31) + this.score.hashCode()) * 31) + this.is_invite) * 31) + this.day.hashCode()) * 31) + this.confirm_beans.hashCode()) * 31) + this.uid_profile.hashCode()) * 31) + this.level_info.hashCode()) * 31) + this.targe_uid_profile.hashCode()) * 31) + this.is_hidden) * 31) + this.target_uid_hidden;
    }

    public final int is_hidden() {
        return this.is_hidden;
    }

    public final int is_invite() {
        return this.is_invite;
    }

    public final void setTarge_uid_profile(YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode) {
        Intrinsics.e(yYRelationShipRoomUserInfoMode, "<set-?>");
        this.targe_uid_profile = yYRelationShipRoomUserInfoMode;
    }

    public final void setTarget_uid_hidden(int i) {
        this.target_uid_hidden = i;
    }

    public final void setUid_profile(YYRelationShipRoomUserInfoMode yYRelationShipRoomUserInfoMode) {
        Intrinsics.e(yYRelationShipRoomUserInfoMode, "<set-?>");
        this.uid_profile = yYRelationShipRoomUserInfoMode;
    }

    public final void set_hidden(int i) {
        this.is_hidden = i;
    }

    public String toString() {
        return "YYRelationShipRoomUserCardInfoMode(id=" + this.id + ", data_id=" + this.data_id + ", score=" + this.score + ", is_invite=" + this.is_invite + ", day=" + this.day + ", confirm_beans=" + this.confirm_beans + ", uid_profile=" + this.uid_profile + ", level_info=" + this.level_info + ", targe_uid_profile=" + this.targe_uid_profile + ", is_hidden=" + this.is_hidden + ", target_uid_hidden=" + this.target_uid_hidden + ')';
    }
}
