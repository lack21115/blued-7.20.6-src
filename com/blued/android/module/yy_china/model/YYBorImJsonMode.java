package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYBorImJsonMode.class */
public final class YYBorImJsonMode {
    private final YYBorImJsonBodyMode body;
    private final int type;

    public YYBorImJsonMode(int i, YYBorImJsonBodyMode body) {
        Intrinsics.e(body, "body");
        this.type = i;
        this.body = body;
    }

    public static /* synthetic */ YYBorImJsonMode copy$default(YYBorImJsonMode yYBorImJsonMode, int i, YYBorImJsonBodyMode yYBorImJsonBodyMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYBorImJsonMode.type;
        }
        if ((i2 & 2) != 0) {
            yYBorImJsonBodyMode = yYBorImJsonMode.body;
        }
        return yYBorImJsonMode.copy(i, yYBorImJsonBodyMode);
    }

    public final int component1() {
        return this.type;
    }

    public final YYBorImJsonBodyMode component2() {
        return this.body;
    }

    public final YYBorImJsonMode copy(int i, YYBorImJsonBodyMode body) {
        Intrinsics.e(body, "body");
        return new YYBorImJsonMode(i, body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYBorImJsonMode) {
            YYBorImJsonMode yYBorImJsonMode = (YYBorImJsonMode) obj;
            return this.type == yYBorImJsonMode.type && Intrinsics.a(this.body, yYBorImJsonMode.body);
        }
        return false;
    }

    public final YYBorImJsonBodyMode getBody() {
        return this.body;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.body.hashCode();
    }

    public String toString() {
        return "YYBorImJsonMode(type=" + this.type + ", body=" + this.body + ')';
    }
}
