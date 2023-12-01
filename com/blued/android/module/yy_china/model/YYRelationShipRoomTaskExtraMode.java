package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomTaskExtraMode.class */
public final class YYRelationShipRoomTaskExtraMode extends BluedEntityBaseExtra {
    private final String remark1;
    private final String remark2;
    private final ArrayList<YYRelationShipRoomTask> task;
    private final String title;

    public YYRelationShipRoomTaskExtraMode(String title, String remark1, String remark2, ArrayList<YYRelationShipRoomTask> task) {
        Intrinsics.e(title, "title");
        Intrinsics.e(remark1, "remark1");
        Intrinsics.e(remark2, "remark2");
        Intrinsics.e(task, "task");
        this.title = title;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.task = task;
    }

    public static /* synthetic */ YYRelationShipRoomTaskExtraMode copy$default(YYRelationShipRoomTaskExtraMode yYRelationShipRoomTaskExtraMode, String str, String str2, String str3, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRelationShipRoomTaskExtraMode.title;
        }
        if ((i & 2) != 0) {
            str2 = yYRelationShipRoomTaskExtraMode.remark1;
        }
        if ((i & 4) != 0) {
            str3 = yYRelationShipRoomTaskExtraMode.remark2;
        }
        if ((i & 8) != 0) {
            arrayList = yYRelationShipRoomTaskExtraMode.task;
        }
        return yYRelationShipRoomTaskExtraMode.copy(str, str2, str3, arrayList);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.remark1;
    }

    public final String component3() {
        return this.remark2;
    }

    public final ArrayList<YYRelationShipRoomTask> component4() {
        return this.task;
    }

    public final YYRelationShipRoomTaskExtraMode copy(String title, String remark1, String remark2, ArrayList<YYRelationShipRoomTask> task) {
        Intrinsics.e(title, "title");
        Intrinsics.e(remark1, "remark1");
        Intrinsics.e(remark2, "remark2");
        Intrinsics.e(task, "task");
        return new YYRelationShipRoomTaskExtraMode(title, remark1, remark2, task);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomTaskExtraMode) {
            YYRelationShipRoomTaskExtraMode yYRelationShipRoomTaskExtraMode = (YYRelationShipRoomTaskExtraMode) obj;
            return Intrinsics.a((Object) this.title, (Object) yYRelationShipRoomTaskExtraMode.title) && Intrinsics.a((Object) this.remark1, (Object) yYRelationShipRoomTaskExtraMode.remark1) && Intrinsics.a((Object) this.remark2, (Object) yYRelationShipRoomTaskExtraMode.remark2) && Intrinsics.a(this.task, yYRelationShipRoomTaskExtraMode.task);
        }
        return false;
    }

    public final String getRemark1() {
        return this.remark1;
    }

    public final String getRemark2() {
        return this.remark2;
    }

    public final ArrayList<YYRelationShipRoomTask> getTask() {
        return this.task;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.remark1.hashCode()) * 31) + this.remark2.hashCode()) * 31) + this.task.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomTaskExtraMode(title=" + this.title + ", remark1=" + this.remark1 + ", remark2=" + this.remark2 + ", task=" + this.task + ')';
    }
}
