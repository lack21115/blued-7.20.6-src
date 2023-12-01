package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayStateModel.class */
public final class DateTodayStateModel {
    private final long initiator;
    private final int state;

    public DateTodayStateModel() {
        this(0L, 0, 3, null);
    }

    public DateTodayStateModel(long j, int i) {
        this.initiator = j;
        this.state = i;
    }

    public /* synthetic */ DateTodayStateModel(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0 : i);
    }

    public static /* synthetic */ DateTodayStateModel copy$default(DateTodayStateModel dateTodayStateModel, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = dateTodayStateModel.initiator;
        }
        if ((i2 & 2) != 0) {
            i = dateTodayStateModel.state;
        }
        return dateTodayStateModel.copy(j, i);
    }

    public final long component1() {
        return this.initiator;
    }

    public final int component2() {
        return this.state;
    }

    public final DateTodayStateModel copy(long j, int i) {
        return new DateTodayStateModel(j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodayStateModel) {
            DateTodayStateModel dateTodayStateModel = (DateTodayStateModel) obj;
            return this.initiator == dateTodayStateModel.initiator && this.state == dateTodayStateModel.state;
        }
        return false;
    }

    public final long getInitiator() {
        return this.initiator;
    }

    public final int getState() {
        return this.state;
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.initiator) * 31) + this.state;
    }

    public String toString() {
        return "DateTodayStateModel(initiator=" + this.initiator + ", state=" + this.state + ')';
    }
}
