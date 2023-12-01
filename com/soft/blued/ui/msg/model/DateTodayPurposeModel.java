package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayPurposeModel.class */
public final class DateTodayPurposeModel {
    private final String icon;
    private final String title;

    public DateTodayPurposeModel() {
        this(null, null, 3, null);
    }

    public DateTodayPurposeModel(String str, String str2) {
        Intrinsics.e(str, "title");
        Intrinsics.e(str2, "icon");
        this.title = str;
        this.icon = str2;
    }

    public /* synthetic */ DateTodayPurposeModel(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ DateTodayPurposeModel copy$default(DateTodayPurposeModel dateTodayPurposeModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dateTodayPurposeModel.title;
        }
        if ((i & 2) != 0) {
            str2 = dateTodayPurposeModel.icon;
        }
        return dateTodayPurposeModel.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final DateTodayPurposeModel copy(String str, String str2) {
        Intrinsics.e(str, "title");
        Intrinsics.e(str2, "icon");
        return new DateTodayPurposeModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodayPurposeModel) {
            DateTodayPurposeModel dateTodayPurposeModel = (DateTodayPurposeModel) obj;
            return Intrinsics.a(this.title, dateTodayPurposeModel.title) && Intrinsics.a(this.icon, dateTodayPurposeModel.icon);
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "DateTodayPurposeModel(title=" + this.title + ", icon=" + this.icon + ')';
    }
}
