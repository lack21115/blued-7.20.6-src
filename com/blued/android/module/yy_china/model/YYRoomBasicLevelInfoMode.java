package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicLevelInfoMode.class */
public final class YYRoomBasicLevelInfoMode {
    private final String current_consume_beans;
    private final String current_score;
    private final String level;
    private final String level_badge;
    private final String level_consume_beans;
    private final String level_score;

    public YYRoomBasicLevelInfoMode(String str, String str2, String str3, String str4, String str5, String str6) {
        this.level = str;
        this.current_score = str2;
        this.current_consume_beans = str3;
        this.level_score = str4;
        this.level_badge = str5;
        this.level_consume_beans = str6;
    }

    public static /* synthetic */ YYRoomBasicLevelInfoMode copy$default(YYRoomBasicLevelInfoMode yYRoomBasicLevelInfoMode, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRoomBasicLevelInfoMode.level;
        }
        if ((i & 2) != 0) {
            str2 = yYRoomBasicLevelInfoMode.current_score;
        }
        if ((i & 4) != 0) {
            str3 = yYRoomBasicLevelInfoMode.current_consume_beans;
        }
        if ((i & 8) != 0) {
            str4 = yYRoomBasicLevelInfoMode.level_score;
        }
        if ((i & 16) != 0) {
            str5 = yYRoomBasicLevelInfoMode.level_badge;
        }
        if ((i & 32) != 0) {
            str6 = yYRoomBasicLevelInfoMode.level_consume_beans;
        }
        return yYRoomBasicLevelInfoMode.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.level;
    }

    public final String component2() {
        return this.current_score;
    }

    public final String component3() {
        return this.current_consume_beans;
    }

    public final String component4() {
        return this.level_score;
    }

    public final String component5() {
        return this.level_badge;
    }

    public final String component6() {
        return this.level_consume_beans;
    }

    public final YYRoomBasicLevelInfoMode copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new YYRoomBasicLevelInfoMode(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomBasicLevelInfoMode) {
            YYRoomBasicLevelInfoMode yYRoomBasicLevelInfoMode = (YYRoomBasicLevelInfoMode) obj;
            return Intrinsics.a((Object) this.level, (Object) yYRoomBasicLevelInfoMode.level) && Intrinsics.a((Object) this.current_score, (Object) yYRoomBasicLevelInfoMode.current_score) && Intrinsics.a((Object) this.current_consume_beans, (Object) yYRoomBasicLevelInfoMode.current_consume_beans) && Intrinsics.a((Object) this.level_score, (Object) yYRoomBasicLevelInfoMode.level_score) && Intrinsics.a((Object) this.level_badge, (Object) yYRoomBasicLevelInfoMode.level_badge) && Intrinsics.a((Object) this.level_consume_beans, (Object) yYRoomBasicLevelInfoMode.level_consume_beans);
        }
        return false;
    }

    public final String getCurrent_consume_beans() {
        return this.current_consume_beans;
    }

    public final String getCurrent_score() {
        return this.current_score;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getLevel_badge() {
        return this.level_badge;
    }

    public final String getLevel_consume_beans() {
        return this.level_consume_beans;
    }

    public final String getLevel_score() {
        return this.level_score;
    }

    public int hashCode() {
        String str = this.level;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.current_score;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.current_consume_beans;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.level_score;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.level_badge;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.level_consume_beans;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
    }

    public String toString() {
        return "YYRoomBasicLevelInfoMode(level=" + ((Object) this.level) + ", current_score=" + ((Object) this.current_score) + ", current_consume_beans=" + ((Object) this.current_consume_beans) + ", level_score=" + ((Object) this.level_score) + ", level_badge=" + ((Object) this.level_badge) + ", level_consume_beans=" + ((Object) this.level_consume_beans) + ')';
    }
}
