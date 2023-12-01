package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFirstMeetMessMode.class */
public final class YYFirstMeetMessMode {
    private YYFirstMeetMode da;
    private final int type;

    public YYFirstMeetMessMode(int i, YYFirstMeetMode yYFirstMeetMode) {
        this.type = i;
        this.da = yYFirstMeetMode;
    }

    public static /* synthetic */ YYFirstMeetMessMode copy$default(YYFirstMeetMessMode yYFirstMeetMessMode, int i, YYFirstMeetMode yYFirstMeetMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYFirstMeetMessMode.type;
        }
        if ((i2 & 2) != 0) {
            yYFirstMeetMode = yYFirstMeetMessMode.da;
        }
        return yYFirstMeetMessMode.copy(i, yYFirstMeetMode);
    }

    public final int component1() {
        return this.type;
    }

    public final YYFirstMeetMode component2() {
        return this.da;
    }

    public final YYFirstMeetMessMode copy(int i, YYFirstMeetMode yYFirstMeetMode) {
        return new YYFirstMeetMessMode(i, yYFirstMeetMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYFirstMeetMessMode) {
            YYFirstMeetMessMode yYFirstMeetMessMode = (YYFirstMeetMessMode) obj;
            return this.type == yYFirstMeetMessMode.type && Intrinsics.a(this.da, yYFirstMeetMessMode.da);
        }
        return false;
    }

    public final YYFirstMeetMode getDa() {
        return this.da;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type;
        YYFirstMeetMode yYFirstMeetMode = this.da;
        return (i * 31) + (yYFirstMeetMode == null ? 0 : yYFirstMeetMode.hashCode());
    }

    public final void setDa(YYFirstMeetMode yYFirstMeetMode) {
        this.da = yYFirstMeetMode;
    }

    public String toString() {
        return "YYFirstMeetMessMode(type=" + this.type + ", da=" + this.da + ')';
    }
}
