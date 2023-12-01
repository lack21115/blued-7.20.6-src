package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomTaskItemMode.class */
public final class YYRelationShipRoomTaskItemMode {
    private final String data_id;
    private final String date;
    private final String id;
    private final int number;
    private final String task_id;

    public YYRelationShipRoomTaskItemMode(String id, String data_id, String task_id, String date, int i) {
        Intrinsics.e(id, "id");
        Intrinsics.e(data_id, "data_id");
        Intrinsics.e(task_id, "task_id");
        Intrinsics.e(date, "date");
        this.id = id;
        this.data_id = data_id;
        this.task_id = task_id;
        this.date = date;
        this.number = i;
    }

    public static /* synthetic */ YYRelationShipRoomTaskItemMode copy$default(YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYRelationShipRoomTaskItemMode.id;
        }
        if ((i2 & 2) != 0) {
            str2 = yYRelationShipRoomTaskItemMode.data_id;
        }
        if ((i2 & 4) != 0) {
            str3 = yYRelationShipRoomTaskItemMode.task_id;
        }
        if ((i2 & 8) != 0) {
            str4 = yYRelationShipRoomTaskItemMode.date;
        }
        if ((i2 & 16) != 0) {
            i = yYRelationShipRoomTaskItemMode.number;
        }
        return yYRelationShipRoomTaskItemMode.copy(str, str2, str3, str4, i);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.data_id;
    }

    public final String component3() {
        return this.task_id;
    }

    public final String component4() {
        return this.date;
    }

    public final int component5() {
        return this.number;
    }

    public final YYRelationShipRoomTaskItemMode copy(String id, String data_id, String task_id, String date, int i) {
        Intrinsics.e(id, "id");
        Intrinsics.e(data_id, "data_id");
        Intrinsics.e(task_id, "task_id");
        Intrinsics.e(date, "date");
        return new YYRelationShipRoomTaskItemMode(id, data_id, task_id, date, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomTaskItemMode) {
            YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode = (YYRelationShipRoomTaskItemMode) obj;
            return Intrinsics.a((Object) this.id, (Object) yYRelationShipRoomTaskItemMode.id) && Intrinsics.a((Object) this.data_id, (Object) yYRelationShipRoomTaskItemMode.data_id) && Intrinsics.a((Object) this.task_id, (Object) yYRelationShipRoomTaskItemMode.task_id) && Intrinsics.a((Object) this.date, (Object) yYRelationShipRoomTaskItemMode.date) && this.number == yYRelationShipRoomTaskItemMode.number;
        }
        return false;
    }

    public final String getData_id() {
        return this.data_id;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getId() {
        return this.id;
    }

    public final int getNumber() {
        return this.number;
    }

    public final String getTask_id() {
        return this.task_id;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.data_id.hashCode()) * 31) + this.task_id.hashCode()) * 31) + this.date.hashCode()) * 31) + this.number;
    }

    public String toString() {
        return "YYRelationShipRoomTaskItemMode(id=" + this.id + ", data_id=" + this.data_id + ", task_id=" + this.task_id + ", date=" + this.date + ", number=" + this.number + ')';
    }
}
