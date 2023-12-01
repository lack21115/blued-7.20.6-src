package com.soft.blued.ui.msg.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayConfigModel.class */
public final class DateTodayConfigModel {
    private final List<String> friends_evaluation;
    private final List<DateTodayPurposeModel> friends_purpose;
    private final List<DateTodayFunctionEvaluationModel> function_evaluation;

    public DateTodayConfigModel(List<DateTodayPurposeModel> list, List<String> list2, List<DateTodayFunctionEvaluationModel> list3) {
        this.friends_purpose = list;
        this.friends_evaluation = list2;
        this.function_evaluation = list3;
    }

    public static /* synthetic */ DateTodayConfigModel copy$default(DateTodayConfigModel dateTodayConfigModel, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dateTodayConfigModel.friends_purpose;
        }
        if ((i & 2) != 0) {
            list2 = dateTodayConfigModel.friends_evaluation;
        }
        if ((i & 4) != 0) {
            list3 = dateTodayConfigModel.function_evaluation;
        }
        return dateTodayConfigModel.copy(list, list2, list3);
    }

    public final List<DateTodayPurposeModel> component1() {
        return this.friends_purpose;
    }

    public final List<String> component2() {
        return this.friends_evaluation;
    }

    public final List<DateTodayFunctionEvaluationModel> component3() {
        return this.function_evaluation;
    }

    public final DateTodayConfigModel copy(List<DateTodayPurposeModel> list, List<String> list2, List<DateTodayFunctionEvaluationModel> list3) {
        return new DateTodayConfigModel(list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodayConfigModel) {
            DateTodayConfigModel dateTodayConfigModel = (DateTodayConfigModel) obj;
            return Intrinsics.a(this.friends_purpose, dateTodayConfigModel.friends_purpose) && Intrinsics.a(this.friends_evaluation, dateTodayConfigModel.friends_evaluation) && Intrinsics.a(this.function_evaluation, dateTodayConfigModel.function_evaluation);
        }
        return false;
    }

    public final List<String> getFriends_evaluation() {
        return this.friends_evaluation;
    }

    public final List<DateTodayPurposeModel> getFriends_purpose() {
        return this.friends_purpose;
    }

    public final List<DateTodayFunctionEvaluationModel> getFunction_evaluation() {
        return this.function_evaluation;
    }

    public int hashCode() {
        List<DateTodayPurposeModel> list = this.friends_purpose;
        int i = 0;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.friends_evaluation;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        List<DateTodayFunctionEvaluationModel> list3 = this.function_evaluation;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public String toString() {
        return "DateTodayConfigModel(friends_purpose=" + this.friends_purpose + ", friends_evaluation=" + this.friends_evaluation + ", function_evaluation=" + this.function_evaluation + ')';
    }
}
