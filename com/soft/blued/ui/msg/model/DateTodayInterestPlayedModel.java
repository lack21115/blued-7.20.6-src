package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayInterestPlayedModel.class */
public final class DateTodayInterestPlayedModel {
    private int played;

    public DateTodayInterestPlayedModel() {
        this(0, 1, null);
    }

    public DateTodayInterestPlayedModel(int i) {
        this.played = i;
    }

    public /* synthetic */ DateTodayInterestPlayedModel(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public static /* synthetic */ DateTodayInterestPlayedModel copy$default(DateTodayInterestPlayedModel dateTodayInterestPlayedModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dateTodayInterestPlayedModel.played;
        }
        return dateTodayInterestPlayedModel.copy(i);
    }

    public final int component1() {
        return this.played;
    }

    public final DateTodayInterestPlayedModel copy(int i) {
        return new DateTodayInterestPlayedModel(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateTodayInterestPlayedModel) && this.played == ((DateTodayInterestPlayedModel) obj).played;
    }

    public final int getPlayed() {
        return this.played;
    }

    public int hashCode() {
        return this.played;
    }

    public final void setPlayed(int i) {
        this.played = i;
    }

    public String toString() {
        return "DateTodayInterestPlayedModel(played=" + this.played + ')';
    }
}
