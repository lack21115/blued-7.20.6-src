package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicRelationDataMode.class */
public final class YYRoomBasicRelationDataMode {
    private final int report_online_number;
    private final int report_online_time;

    public YYRoomBasicRelationDataMode(int i, int i2) {
        this.report_online_number = i;
        this.report_online_time = i2;
    }

    public /* synthetic */ YYRoomBasicRelationDataMode(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 60 : i2);
    }

    public static /* synthetic */ YYRoomBasicRelationDataMode copy$default(YYRoomBasicRelationDataMode yYRoomBasicRelationDataMode, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = yYRoomBasicRelationDataMode.report_online_number;
        }
        if ((i3 & 2) != 0) {
            i2 = yYRoomBasicRelationDataMode.report_online_time;
        }
        return yYRoomBasicRelationDataMode.copy(i, i2);
    }

    public final int component1() {
        return this.report_online_number;
    }

    public final int component2() {
        return this.report_online_time;
    }

    public final YYRoomBasicRelationDataMode copy(int i, int i2) {
        return new YYRoomBasicRelationDataMode(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomBasicRelationDataMode) {
            YYRoomBasicRelationDataMode yYRoomBasicRelationDataMode = (YYRoomBasicRelationDataMode) obj;
            return this.report_online_number == yYRoomBasicRelationDataMode.report_online_number && this.report_online_time == yYRoomBasicRelationDataMode.report_online_time;
        }
        return false;
    }

    public final int getReport_online_number() {
        return this.report_online_number;
    }

    public final int getReport_online_time() {
        return this.report_online_time;
    }

    public int hashCode() {
        return (this.report_online_number * 31) + this.report_online_time;
    }

    public String toString() {
        return "YYRoomBasicRelationDataMode(report_online_number=" + this.report_online_number + ", report_online_time=" + this.report_online_time + ')';
    }
}
