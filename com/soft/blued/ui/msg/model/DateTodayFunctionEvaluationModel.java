package com.soft.blued.ui.msg.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayFunctionEvaluationModel.class */
public final class DateTodayFunctionEvaluationModel {
    private final String icon;
    private final List<String> tags;
    private final String title;

    public DateTodayFunctionEvaluationModel(String title, String icon, List<String> list) {
        Intrinsics.e(title, "title");
        Intrinsics.e(icon, "icon");
        this.title = title;
        this.icon = icon;
        this.tags = list;
    }

    public /* synthetic */ DateTodayFunctionEvaluationModel(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, list);
    }

    public static /* synthetic */ DateTodayFunctionEvaluationModel copy$default(DateTodayFunctionEvaluationModel dateTodayFunctionEvaluationModel, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dateTodayFunctionEvaluationModel.title;
        }
        if ((i & 2) != 0) {
            str2 = dateTodayFunctionEvaluationModel.icon;
        }
        if ((i & 4) != 0) {
            list = dateTodayFunctionEvaluationModel.tags;
        }
        return dateTodayFunctionEvaluationModel.copy(str, str2, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.icon;
    }

    public final List<String> component3() {
        return this.tags;
    }

    public final DateTodayFunctionEvaluationModel copy(String title, String icon, List<String> list) {
        Intrinsics.e(title, "title");
        Intrinsics.e(icon, "icon");
        return new DateTodayFunctionEvaluationModel(title, icon, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodayFunctionEvaluationModel) {
            DateTodayFunctionEvaluationModel dateTodayFunctionEvaluationModel = (DateTodayFunctionEvaluationModel) obj;
            return Intrinsics.a((Object) this.title, (Object) dateTodayFunctionEvaluationModel.title) && Intrinsics.a((Object) this.icon, (Object) dateTodayFunctionEvaluationModel.icon) && Intrinsics.a(this.tags, dateTodayFunctionEvaluationModel.tags);
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode();
        int hashCode2 = this.icon.hashCode();
        List<String> list = this.tags;
        return (((hashCode * 31) + hashCode2) * 31) + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "DateTodayFunctionEvaluationModel(title=" + this.title + ", icon=" + this.icon + ", tags=" + this.tags + ')';
    }
}
