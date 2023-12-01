package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicInfoMode.class */
public final class YYRoomBasicInfoMode {
    private final YYRoomBasicLevelInfoMode current_level_info;
    private final YYRoomBasicLevelInfoMode level_max_info;
    private final YYRoomBasicLevelInfoMode next_level_info;

    public YYRoomBasicInfoMode(YYRoomBasicLevelInfoMode current_level_info, YYRoomBasicLevelInfoMode next_level_info, YYRoomBasicLevelInfoMode level_max_info) {
        Intrinsics.e(current_level_info, "current_level_info");
        Intrinsics.e(next_level_info, "next_level_info");
        Intrinsics.e(level_max_info, "level_max_info");
        this.current_level_info = current_level_info;
        this.next_level_info = next_level_info;
        this.level_max_info = level_max_info;
    }

    public static /* synthetic */ YYRoomBasicInfoMode copy$default(YYRoomBasicInfoMode yYRoomBasicInfoMode, YYRoomBasicLevelInfoMode yYRoomBasicLevelInfoMode, YYRoomBasicLevelInfoMode yYRoomBasicLevelInfoMode2, YYRoomBasicLevelInfoMode yYRoomBasicLevelInfoMode3, int i, Object obj) {
        if ((i & 1) != 0) {
            yYRoomBasicLevelInfoMode = yYRoomBasicInfoMode.current_level_info;
        }
        if ((i & 2) != 0) {
            yYRoomBasicLevelInfoMode2 = yYRoomBasicInfoMode.next_level_info;
        }
        if ((i & 4) != 0) {
            yYRoomBasicLevelInfoMode3 = yYRoomBasicInfoMode.level_max_info;
        }
        return yYRoomBasicInfoMode.copy(yYRoomBasicLevelInfoMode, yYRoomBasicLevelInfoMode2, yYRoomBasicLevelInfoMode3);
    }

    public final YYRoomBasicLevelInfoMode component1() {
        return this.current_level_info;
    }

    public final YYRoomBasicLevelInfoMode component2() {
        return this.next_level_info;
    }

    public final YYRoomBasicLevelInfoMode component3() {
        return this.level_max_info;
    }

    public final YYRoomBasicInfoMode copy(YYRoomBasicLevelInfoMode current_level_info, YYRoomBasicLevelInfoMode next_level_info, YYRoomBasicLevelInfoMode level_max_info) {
        Intrinsics.e(current_level_info, "current_level_info");
        Intrinsics.e(next_level_info, "next_level_info");
        Intrinsics.e(level_max_info, "level_max_info");
        return new YYRoomBasicInfoMode(current_level_info, next_level_info, level_max_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomBasicInfoMode) {
            YYRoomBasicInfoMode yYRoomBasicInfoMode = (YYRoomBasicInfoMode) obj;
            return Intrinsics.a(this.current_level_info, yYRoomBasicInfoMode.current_level_info) && Intrinsics.a(this.next_level_info, yYRoomBasicInfoMode.next_level_info) && Intrinsics.a(this.level_max_info, yYRoomBasicInfoMode.level_max_info);
        }
        return false;
    }

    public final YYRoomBasicLevelInfoMode getCurrent_level_info() {
        return this.current_level_info;
    }

    public final YYRoomBasicLevelInfoMode getLevel_max_info() {
        return this.level_max_info;
    }

    public final YYRoomBasicLevelInfoMode getNext_level_info() {
        return this.next_level_info;
    }

    public int hashCode() {
        return (((this.current_level_info.hashCode() * 31) + this.next_level_info.hashCode()) * 31) + this.level_max_info.hashCode();
    }

    public String toString() {
        return "YYRoomBasicInfoMode(current_level_info=" + this.current_level_info + ", next_level_info=" + this.next_level_info + ", level_max_info=" + this.level_max_info + ')';
    }
}
