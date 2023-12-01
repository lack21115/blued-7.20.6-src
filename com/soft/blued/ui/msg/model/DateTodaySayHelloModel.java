package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodaySayHelloModel.class */
public final class DateTodaySayHelloModel {
    private int matchAnimationType;
    private int played;

    public DateTodaySayHelloModel() {
        this(0, 0, 3, null);
    }

    public DateTodaySayHelloModel(int i, int i2) {
        this.matchAnimationType = i;
        this.played = i2;
    }

    public /* synthetic */ DateTodaySayHelloModel(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public static /* synthetic */ DateTodaySayHelloModel copy$default(DateTodaySayHelloModel dateTodaySayHelloModel, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dateTodaySayHelloModel.matchAnimationType;
        }
        if ((i3 & 2) != 0) {
            i2 = dateTodaySayHelloModel.played;
        }
        return dateTodaySayHelloModel.copy(i, i2);
    }

    public final int component1() {
        return this.matchAnimationType;
    }

    public final int component2() {
        return this.played;
    }

    public final DateTodaySayHelloModel copy(int i, int i2) {
        return new DateTodaySayHelloModel(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodaySayHelloModel) {
            DateTodaySayHelloModel dateTodaySayHelloModel = (DateTodaySayHelloModel) obj;
            return this.matchAnimationType == dateTodaySayHelloModel.matchAnimationType && this.played == dateTodaySayHelloModel.played;
        }
        return false;
    }

    public final int getMatchAnimationType() {
        return this.matchAnimationType;
    }

    public final int getPlayed() {
        return this.played;
    }

    public int hashCode() {
        return (this.matchAnimationType * 31) + this.played;
    }

    public final void setMatchAnimationType(int i) {
        this.matchAnimationType = i;
    }

    public final void setPlayed(int i) {
        this.played = i;
    }

    public String toString() {
        return "DateTodaySayHelloModel(matchAnimationType=" + this.matchAnimationType + ", played=" + this.played + ')';
    }
}
