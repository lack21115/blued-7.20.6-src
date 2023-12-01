package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYJumpRoomMode.class */
public final class YYJumpRoomMode {
    private final String roomid;
    private final String source;

    public YYJumpRoomMode(String roomid, String source) {
        Intrinsics.e(roomid, "roomid");
        Intrinsics.e(source, "source");
        this.roomid = roomid;
        this.source = source;
    }

    public static /* synthetic */ YYJumpRoomMode copy$default(YYJumpRoomMode yYJumpRoomMode, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYJumpRoomMode.roomid;
        }
        if ((i & 2) != 0) {
            str2 = yYJumpRoomMode.source;
        }
        return yYJumpRoomMode.copy(str, str2);
    }

    public final String component1() {
        return this.roomid;
    }

    public final String component2() {
        return this.source;
    }

    public final YYJumpRoomMode copy(String roomid, String source) {
        Intrinsics.e(roomid, "roomid");
        Intrinsics.e(source, "source");
        return new YYJumpRoomMode(roomid, source);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYJumpRoomMode) {
            YYJumpRoomMode yYJumpRoomMode = (YYJumpRoomMode) obj;
            return Intrinsics.a((Object) this.roomid, (Object) yYJumpRoomMode.roomid) && Intrinsics.a((Object) this.source, (Object) yYJumpRoomMode.source);
        }
        return false;
    }

    public final String getRoomid() {
        return this.roomid;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        return (this.roomid.hashCode() * 31) + this.source.hashCode();
    }

    public String toString() {
        return "YYJumpRoomMode(roomid=" + this.roomid + ", source=" + this.source + ')';
    }
}
