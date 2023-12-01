package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipSuccessBuriedPointDataImMode.class */
public final class YYRelationShipSuccessBuriedPointDataImMode {
    private final int confirm_beans;
    private final int day;
    private final String relation_id;
    private final String target_uid;
    private final String uid;

    public YYRelationShipSuccessBuriedPointDataImMode(String uid, String target_uid, String relation_id, int i, int i2) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(relation_id, "relation_id");
        this.uid = uid;
        this.target_uid = target_uid;
        this.relation_id = relation_id;
        this.confirm_beans = i;
        this.day = i2;
    }

    public static /* synthetic */ YYRelationShipSuccessBuriedPointDataImMode copy$default(YYRelationShipSuccessBuriedPointDataImMode yYRelationShipSuccessBuriedPointDataImMode, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = yYRelationShipSuccessBuriedPointDataImMode.uid;
        }
        if ((i3 & 2) != 0) {
            str2 = yYRelationShipSuccessBuriedPointDataImMode.target_uid;
        }
        if ((i3 & 4) != 0) {
            str3 = yYRelationShipSuccessBuriedPointDataImMode.relation_id;
        }
        if ((i3 & 8) != 0) {
            i = yYRelationShipSuccessBuriedPointDataImMode.confirm_beans;
        }
        if ((i3 & 16) != 0) {
            i2 = yYRelationShipSuccessBuriedPointDataImMode.day;
        }
        return yYRelationShipSuccessBuriedPointDataImMode.copy(str, str2, str3, i, i2);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.target_uid;
    }

    public final String component3() {
        return this.relation_id;
    }

    public final int component4() {
        return this.confirm_beans;
    }

    public final int component5() {
        return this.day;
    }

    public final YYRelationShipSuccessBuriedPointDataImMode copy(String uid, String target_uid, String relation_id, int i, int i2) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(relation_id, "relation_id");
        return new YYRelationShipSuccessBuriedPointDataImMode(uid, target_uid, relation_id, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipSuccessBuriedPointDataImMode) {
            YYRelationShipSuccessBuriedPointDataImMode yYRelationShipSuccessBuriedPointDataImMode = (YYRelationShipSuccessBuriedPointDataImMode) obj;
            return Intrinsics.a((Object) this.uid, (Object) yYRelationShipSuccessBuriedPointDataImMode.uid) && Intrinsics.a((Object) this.target_uid, (Object) yYRelationShipSuccessBuriedPointDataImMode.target_uid) && Intrinsics.a((Object) this.relation_id, (Object) yYRelationShipSuccessBuriedPointDataImMode.relation_id) && this.confirm_beans == yYRelationShipSuccessBuriedPointDataImMode.confirm_beans && this.day == yYRelationShipSuccessBuriedPointDataImMode.day;
        }
        return false;
    }

    public final int getConfirm_beans() {
        return this.confirm_beans;
    }

    public final int getDay() {
        return this.day;
    }

    public final String getRelation_id() {
        return this.relation_id;
    }

    public final String getTarget_uid() {
        return this.target_uid;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((this.uid.hashCode() * 31) + this.target_uid.hashCode()) * 31) + this.relation_id.hashCode()) * 31) + this.confirm_beans) * 31) + this.day;
    }

    public String toString() {
        return "YYRelationShipSuccessBuriedPointDataImMode(uid=" + this.uid + ", target_uid=" + this.target_uid + ", relation_id=" + this.relation_id + ", confirm_beans=" + this.confirm_beans + ", day=" + this.day + ')';
    }
}
