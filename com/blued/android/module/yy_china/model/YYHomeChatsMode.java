package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeChatsMode.class */
public final class YYHomeChatsMode {
    private final YYHomeChatsLeftMode left;
    private final YYHomeChatsRightMode right;

    public YYHomeChatsMode(YYHomeChatsRightMode right, YYHomeChatsLeftMode left) {
        Intrinsics.e(right, "right");
        Intrinsics.e(left, "left");
        this.right = right;
        this.left = left;
    }

    public static /* synthetic */ YYHomeChatsMode copy$default(YYHomeChatsMode yYHomeChatsMode, YYHomeChatsRightMode yYHomeChatsRightMode, YYHomeChatsLeftMode yYHomeChatsLeftMode, int i, Object obj) {
        if ((i & 1) != 0) {
            yYHomeChatsRightMode = yYHomeChatsMode.right;
        }
        if ((i & 2) != 0) {
            yYHomeChatsLeftMode = yYHomeChatsMode.left;
        }
        return yYHomeChatsMode.copy(yYHomeChatsRightMode, yYHomeChatsLeftMode);
    }

    public final YYHomeChatsRightMode component1() {
        return this.right;
    }

    public final YYHomeChatsLeftMode component2() {
        return this.left;
    }

    public final YYHomeChatsMode copy(YYHomeChatsRightMode right, YYHomeChatsLeftMode left) {
        Intrinsics.e(right, "right");
        Intrinsics.e(left, "left");
        return new YYHomeChatsMode(right, left);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYHomeChatsMode) {
            YYHomeChatsMode yYHomeChatsMode = (YYHomeChatsMode) obj;
            return Intrinsics.a(this.right, yYHomeChatsMode.right) && Intrinsics.a(this.left, yYHomeChatsMode.left);
        }
        return false;
    }

    public final YYHomeChatsLeftMode getLeft() {
        return this.left;
    }

    public final YYHomeChatsRightMode getRight() {
        return this.right;
    }

    public int hashCode() {
        return (this.right.hashCode() * 31) + this.left.hashCode();
    }

    public String toString() {
        return "YYHomeChatsMode(right=" + this.right + ", left=" + this.left + ')';
    }
}
