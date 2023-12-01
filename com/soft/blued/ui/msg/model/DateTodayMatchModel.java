package com.soft.blued.ui.msg.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayMatchModel.class */
public final class DateTodayMatchModel {
    private final List<String> same_point_friends_purpose;
    private final List<String> same_point_like;
    private final float score;
    private final DateTodayMatchUserModel self_info;
    private final DateTodayMatchUserModel target_info;
    private long time;

    public DateTodayMatchModel(float f, List<String> list, List<String> list2, DateTodayMatchUserModel dateTodayMatchUserModel, DateTodayMatchUserModel dateTodayMatchUserModel2, long j) {
        this.score = f;
        this.same_point_friends_purpose = list;
        this.same_point_like = list2;
        this.target_info = dateTodayMatchUserModel;
        this.self_info = dateTodayMatchUserModel2;
        this.time = j;
    }

    public /* synthetic */ DateTodayMatchModel(float f, List list, List list2, DateTodayMatchUserModel dateTodayMatchUserModel, DateTodayMatchUserModel dateTodayMatchUserModel2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, list, list2, dateTodayMatchUserModel, dateTodayMatchUserModel2, (i & 32) != 0 ? 0L : j);
    }

    public static /* synthetic */ DateTodayMatchModel copy$default(DateTodayMatchModel dateTodayMatchModel, float f, List list, List list2, DateTodayMatchUserModel dateTodayMatchUserModel, DateTodayMatchUserModel dateTodayMatchUserModel2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dateTodayMatchModel.score;
        }
        if ((i & 2) != 0) {
            list = dateTodayMatchModel.same_point_friends_purpose;
        }
        if ((i & 4) != 0) {
            list2 = dateTodayMatchModel.same_point_like;
        }
        if ((i & 8) != 0) {
            dateTodayMatchUserModel = dateTodayMatchModel.target_info;
        }
        if ((i & 16) != 0) {
            dateTodayMatchUserModel2 = dateTodayMatchModel.self_info;
        }
        if ((i & 32) != 0) {
            j = dateTodayMatchModel.time;
        }
        return dateTodayMatchModel.copy(f, list, list2, dateTodayMatchUserModel, dateTodayMatchUserModel2, j);
    }

    public final float component1() {
        return this.score;
    }

    public final List<String> component2() {
        return this.same_point_friends_purpose;
    }

    public final List<String> component3() {
        return this.same_point_like;
    }

    public final DateTodayMatchUserModel component4() {
        return this.target_info;
    }

    public final DateTodayMatchUserModel component5() {
        return this.self_info;
    }

    public final long component6() {
        return this.time;
    }

    public final DateTodayMatchModel copy(float f, List<String> list, List<String> list2, DateTodayMatchUserModel dateTodayMatchUserModel, DateTodayMatchUserModel dateTodayMatchUserModel2, long j) {
        return new DateTodayMatchModel(f, list, list2, dateTodayMatchUserModel, dateTodayMatchUserModel2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodayMatchModel) {
            DateTodayMatchModel dateTodayMatchModel = (DateTodayMatchModel) obj;
            return Intrinsics.a(Float.valueOf(this.score), Float.valueOf(dateTodayMatchModel.score)) && Intrinsics.a(this.same_point_friends_purpose, dateTodayMatchModel.same_point_friends_purpose) && Intrinsics.a(this.same_point_like, dateTodayMatchModel.same_point_like) && Intrinsics.a(this.target_info, dateTodayMatchModel.target_info) && Intrinsics.a(this.self_info, dateTodayMatchModel.self_info) && this.time == dateTodayMatchModel.time;
        }
        return false;
    }

    public final List<String> getSame_point_friends_purpose() {
        return this.same_point_friends_purpose;
    }

    public final List<String> getSame_point_like() {
        return this.same_point_like;
    }

    public final float getScore() {
        return this.score;
    }

    public final DateTodayMatchUserModel getSelf_info() {
        return this.self_info;
    }

    public final DateTodayMatchUserModel getTarget_info() {
        return this.target_info;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.score);
        List<String> list = this.same_point_friends_purpose;
        int i = 0;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.same_point_like;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        DateTodayMatchUserModel dateTodayMatchUserModel = this.target_info;
        int hashCode3 = dateTodayMatchUserModel == null ? 0 : dateTodayMatchUserModel.hashCode();
        DateTodayMatchUserModel dateTodayMatchUserModel2 = this.self_info;
        if (dateTodayMatchUserModel2 != null) {
            i = dateTodayMatchUserModel2.hashCode();
        }
        return (((((((((floatToIntBits * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.time);
    }

    public final void setTime(long j) {
        this.time = j;
    }

    public String toString() {
        return "DateTodayMatchModel(score=" + this.score + ", same_point_friends_purpose=" + this.same_point_friends_purpose + ", same_point_like=" + this.same_point_like + ", target_info=" + this.target_info + ", self_info=" + this.self_info + ", time=" + this.time + ')';
    }
}
