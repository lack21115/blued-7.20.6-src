package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFirstMeetImMessMode.class */
public final class YYFirstMeetImMessMode {
    private final String source_avatar;
    private final String source_name;
    private final String source_uid;
    private final String target_avatar;
    private final String target_name;
    private final String target_uid;

    public YYFirstMeetImMessMode(String source_uid, String source_name, String source_avatar, String target_uid, String target_name, String target_avatar) {
        Intrinsics.e(source_uid, "source_uid");
        Intrinsics.e(source_name, "source_name");
        Intrinsics.e(source_avatar, "source_avatar");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(target_name, "target_name");
        Intrinsics.e(target_avatar, "target_avatar");
        this.source_uid = source_uid;
        this.source_name = source_name;
        this.source_avatar = source_avatar;
        this.target_uid = target_uid;
        this.target_name = target_name;
        this.target_avatar = target_avatar;
    }

    public static /* synthetic */ YYFirstMeetImMessMode copy$default(YYFirstMeetImMessMode yYFirstMeetImMessMode, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYFirstMeetImMessMode.source_uid;
        }
        if ((i & 2) != 0) {
            str2 = yYFirstMeetImMessMode.source_name;
        }
        if ((i & 4) != 0) {
            str3 = yYFirstMeetImMessMode.source_avatar;
        }
        if ((i & 8) != 0) {
            str4 = yYFirstMeetImMessMode.target_uid;
        }
        if ((i & 16) != 0) {
            str5 = yYFirstMeetImMessMode.target_name;
        }
        if ((i & 32) != 0) {
            str6 = yYFirstMeetImMessMode.target_avatar;
        }
        return yYFirstMeetImMessMode.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.source_uid;
    }

    public final String component2() {
        return this.source_name;
    }

    public final String component3() {
        return this.source_avatar;
    }

    public final String component4() {
        return this.target_uid;
    }

    public final String component5() {
        return this.target_name;
    }

    public final String component6() {
        return this.target_avatar;
    }

    public final YYFirstMeetImMessMode copy(String source_uid, String source_name, String source_avatar, String target_uid, String target_name, String target_avatar) {
        Intrinsics.e(source_uid, "source_uid");
        Intrinsics.e(source_name, "source_name");
        Intrinsics.e(source_avatar, "source_avatar");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(target_name, "target_name");
        Intrinsics.e(target_avatar, "target_avatar");
        return new YYFirstMeetImMessMode(source_uid, source_name, source_avatar, target_uid, target_name, target_avatar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYFirstMeetImMessMode) {
            YYFirstMeetImMessMode yYFirstMeetImMessMode = (YYFirstMeetImMessMode) obj;
            return Intrinsics.a((Object) this.source_uid, (Object) yYFirstMeetImMessMode.source_uid) && Intrinsics.a((Object) this.source_name, (Object) yYFirstMeetImMessMode.source_name) && Intrinsics.a((Object) this.source_avatar, (Object) yYFirstMeetImMessMode.source_avatar) && Intrinsics.a((Object) this.target_uid, (Object) yYFirstMeetImMessMode.target_uid) && Intrinsics.a((Object) this.target_name, (Object) yYFirstMeetImMessMode.target_name) && Intrinsics.a((Object) this.target_avatar, (Object) yYFirstMeetImMessMode.target_avatar);
        }
        return false;
    }

    public final String getSource_avatar() {
        return this.source_avatar;
    }

    public final String getSource_name() {
        return this.source_name;
    }

    public final String getSource_uid() {
        return this.source_uid;
    }

    public final String getTarget_avatar() {
        return this.target_avatar;
    }

    public final String getTarget_name() {
        return this.target_name;
    }

    public final String getTarget_uid() {
        return this.target_uid;
    }

    public int hashCode() {
        return (((((((((this.source_uid.hashCode() * 31) + this.source_name.hashCode()) * 31) + this.source_avatar.hashCode()) * 31) + this.target_uid.hashCode()) * 31) + this.target_name.hashCode()) * 31) + this.target_avatar.hashCode();
    }

    public String toString() {
        return "YYFirstMeetImMessMode(source_uid=" + this.source_uid + ", source_name=" + this.source_name + ", source_avatar=" + this.source_avatar + ", target_uid=" + this.target_uid + ", target_name=" + this.target_name + ", target_avatar=" + this.target_avatar + ')';
    }
}
