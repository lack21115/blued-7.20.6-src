package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayQualificationModel.class */
public final class DateTodayQualificationModel {
    private final int enable;
    private final long expire_time;
    private final int residue_degree;

    public DateTodayQualificationModel() {
        this(0, 0, 0L, 7, null);
    }

    public DateTodayQualificationModel(int i, int i2, long j) {
        this.enable = i;
        this.residue_degree = i2;
        this.expire_time = j;
    }

    public /* synthetic */ DateTodayQualificationModel(int i, int i2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? 0L : j);
    }

    public static /* synthetic */ DateTodayQualificationModel copy$default(DateTodayQualificationModel dateTodayQualificationModel, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dateTodayQualificationModel.enable;
        }
        if ((i3 & 2) != 0) {
            i2 = dateTodayQualificationModel.residue_degree;
        }
        if ((i3 & 4) != 0) {
            j = dateTodayQualificationModel.expire_time;
        }
        return dateTodayQualificationModel.copy(i, i2, j);
    }

    public final int component1() {
        return this.enable;
    }

    public final int component2() {
        return this.residue_degree;
    }

    public final long component3() {
        return this.expire_time;
    }

    public final DateTodayQualificationModel copy(int i, int i2, long j) {
        return new DateTodayQualificationModel(i, i2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodayQualificationModel) {
            DateTodayQualificationModel dateTodayQualificationModel = (DateTodayQualificationModel) obj;
            return this.enable == dateTodayQualificationModel.enable && this.residue_degree == dateTodayQualificationModel.residue_degree && this.expire_time == dateTodayQualificationModel.expire_time;
        }
        return false;
    }

    public final int getEnable() {
        return this.enable;
    }

    public final long getExpire_time() {
        return this.expire_time;
    }

    public final int getResidue_degree() {
        return this.residue_degree;
    }

    public int hashCode() {
        return (((this.enable * 31) + this.residue_degree) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.expire_time);
    }

    public String toString() {
        return "DateTodayQualificationModel(enable=" + this.enable + ", residue_degree=" + this.residue_degree + ", expire_time=" + this.expire_time + ')';
    }
}
