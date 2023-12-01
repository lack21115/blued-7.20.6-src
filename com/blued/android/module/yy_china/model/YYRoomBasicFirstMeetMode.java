package com.blued.android.module.yy_china.model;

import $r8;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicFirstMeetMode.class */
public final class YYRoomBasicFirstMeetMode {
    private final long show_delay;

    public YYRoomBasicFirstMeetMode(long j) {
        this.show_delay = j;
    }

    public static /* synthetic */ YYRoomBasicFirstMeetMode copy$default(YYRoomBasicFirstMeetMode yYRoomBasicFirstMeetMode, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = yYRoomBasicFirstMeetMode.show_delay;
        }
        return yYRoomBasicFirstMeetMode.copy(j);
    }

    public final long component1() {
        return this.show_delay;
    }

    public final YYRoomBasicFirstMeetMode copy(long j) {
        return new YYRoomBasicFirstMeetMode(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYRoomBasicFirstMeetMode) && this.show_delay == ((YYRoomBasicFirstMeetMode) obj).show_delay;
    }

    public final long getShow_delay() {
        return this.show_delay;
    }

    public int hashCode() {
        return $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.show_delay);
    }

    public String toString() {
        return "YYRoomBasicFirstMeetMode(show_delay=" + this.show_delay + ')';
    }
}
