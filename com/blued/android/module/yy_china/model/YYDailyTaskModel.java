package com.blued.android.module.yy_china.model;

import $r8;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYDailyTaskModel.class */
public final class YYDailyTaskModel {
    private final ArrayList<String> appoint;
    private final int condition;
    private final long end_time;
    private final int is_open;
    private final String item;
    private final long start_time;
    private final int status;

    public YYDailyTaskModel(int i, int i2, long j, long j2, String item, int i3, ArrayList<String> appoint) {
        Intrinsics.e(item, "item");
        Intrinsics.e(appoint, "appoint");
        this.is_open = i;
        this.status = i2;
        this.start_time = j;
        this.end_time = j2;
        this.item = item;
        this.condition = i3;
        this.appoint = appoint;
    }

    public static /* synthetic */ YYDailyTaskModel copy$default(YYDailyTaskModel yYDailyTaskModel, int i, int i2, long j, long j2, String str, int i3, ArrayList arrayList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = yYDailyTaskModel.is_open;
        }
        if ((i4 & 2) != 0) {
            i2 = yYDailyTaskModel.status;
        }
        if ((i4 & 4) != 0) {
            j = yYDailyTaskModel.start_time;
        }
        if ((i4 & 8) != 0) {
            j2 = yYDailyTaskModel.end_time;
        }
        if ((i4 & 16) != 0) {
            str = yYDailyTaskModel.item;
        }
        if ((i4 & 32) != 0) {
            i3 = yYDailyTaskModel.condition;
        }
        if ((i4 & 64) != 0) {
            arrayList = yYDailyTaskModel.appoint;
        }
        return yYDailyTaskModel.copy(i, i2, j, j2, str, i3, arrayList);
    }

    public final int component1() {
        return this.is_open;
    }

    public final int component2() {
        return this.status;
    }

    public final long component3() {
        return this.start_time;
    }

    public final long component4() {
        return this.end_time;
    }

    public final String component5() {
        return this.item;
    }

    public final int component6() {
        return this.condition;
    }

    public final ArrayList<String> component7() {
        return this.appoint;
    }

    public final YYDailyTaskModel copy(int i, int i2, long j, long j2, String item, int i3, ArrayList<String> appoint) {
        Intrinsics.e(item, "item");
        Intrinsics.e(appoint, "appoint");
        return new YYDailyTaskModel(i, i2, j, j2, item, i3, appoint);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYDailyTaskModel) {
            YYDailyTaskModel yYDailyTaskModel = (YYDailyTaskModel) obj;
            return this.is_open == yYDailyTaskModel.is_open && this.status == yYDailyTaskModel.status && this.start_time == yYDailyTaskModel.start_time && this.end_time == yYDailyTaskModel.end_time && Intrinsics.a((Object) this.item, (Object) yYDailyTaskModel.item) && this.condition == yYDailyTaskModel.condition && Intrinsics.a(this.appoint, yYDailyTaskModel.appoint);
        }
        return false;
    }

    public final ArrayList<String> getAppoint() {
        return this.appoint;
    }

    public final int getCondition() {
        return this.condition;
    }

    public final long getEnd_time() {
        return this.end_time;
    }

    public final String getItem() {
        return this.item;
    }

    public final long getStart_time() {
        return this.start_time;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((((((this.is_open * 31) + this.status) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.start_time)) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.end_time)) * 31) + this.item.hashCode()) * 31) + this.condition) * 31) + this.appoint.hashCode();
    }

    public final int is_open() {
        return this.is_open;
    }

    public String toString() {
        return "YYDailyTaskModel(is_open=" + this.is_open + ", status=" + this.status + ", start_time=" + this.start_time + ", end_time=" + this.end_time + ", item=" + this.item + ", condition=" + this.condition + ", appoint=" + this.appoint + ')';
    }
}
