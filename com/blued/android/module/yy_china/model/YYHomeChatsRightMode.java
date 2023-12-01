package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeChatsRightMode.class */
public final class YYHomeChatsRightMode {
    private final YYHomeChatsRightBownMode down;
    private final YYHomeChatsRightTopMode top;

    public YYHomeChatsRightMode(YYHomeChatsRightTopMode top, YYHomeChatsRightBownMode down) {
        Intrinsics.e(top, "top");
        Intrinsics.e(down, "down");
        this.top = top;
        this.down = down;
    }

    public static /* synthetic */ YYHomeChatsRightMode copy$default(YYHomeChatsRightMode yYHomeChatsRightMode, YYHomeChatsRightTopMode yYHomeChatsRightTopMode, YYHomeChatsRightBownMode yYHomeChatsRightBownMode, int i, Object obj) {
        if ((i & 1) != 0) {
            yYHomeChatsRightTopMode = yYHomeChatsRightMode.top;
        }
        if ((i & 2) != 0) {
            yYHomeChatsRightBownMode = yYHomeChatsRightMode.down;
        }
        return yYHomeChatsRightMode.copy(yYHomeChatsRightTopMode, yYHomeChatsRightBownMode);
    }

    public final YYHomeChatsRightTopMode component1() {
        return this.top;
    }

    public final YYHomeChatsRightBownMode component2() {
        return this.down;
    }

    public final YYHomeChatsRightMode copy(YYHomeChatsRightTopMode top, YYHomeChatsRightBownMode down) {
        Intrinsics.e(top, "top");
        Intrinsics.e(down, "down");
        return new YYHomeChatsRightMode(top, down);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYHomeChatsRightMode) {
            YYHomeChatsRightMode yYHomeChatsRightMode = (YYHomeChatsRightMode) obj;
            return Intrinsics.a(this.top, yYHomeChatsRightMode.top) && Intrinsics.a(this.down, yYHomeChatsRightMode.down);
        }
        return false;
    }

    public final YYHomeChatsRightBownMode getDown() {
        return this.down;
    }

    public final YYHomeChatsRightTopMode getTop() {
        return this.top;
    }

    public int hashCode() {
        return (this.top.hashCode() * 31) + this.down.hashCode();
    }

    public String toString() {
        return "YYHomeChatsRightMode(top=" + this.top + ", down=" + this.down + ')';
    }
}
