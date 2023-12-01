package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/RelationshipStatus.class */
public final class RelationshipStatus {
    private final int confirm_score;
    private final String data_id;
    private final String day;
    private final String id;
    private final int is_hidden;
    private final int relation_id;
    private final int score;
    private final int status;
    private final String target_uid;
    private final String uid;

    public RelationshipStatus(String id, String data_id, String uid, String target_uid, int i, int i2, int i3, int i4, String day, int i5) {
        Intrinsics.e(id, "id");
        Intrinsics.e(data_id, "data_id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(day, "day");
        this.id = id;
        this.data_id = data_id;
        this.uid = uid;
        this.target_uid = target_uid;
        this.is_hidden = i;
        this.relation_id = i2;
        this.score = i3;
        this.status = i4;
        this.day = day;
        this.confirm_score = i5;
    }

    public static /* synthetic */ RelationshipStatus copy$default(RelationshipStatus relationshipStatus, String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, String str5, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = relationshipStatus.id;
        }
        if ((i6 & 2) != 0) {
            str2 = relationshipStatus.data_id;
        }
        if ((i6 & 4) != 0) {
            str3 = relationshipStatus.uid;
        }
        if ((i6 & 8) != 0) {
            str4 = relationshipStatus.target_uid;
        }
        if ((i6 & 16) != 0) {
            i = relationshipStatus.is_hidden;
        }
        if ((i6 & 32) != 0) {
            i2 = relationshipStatus.relation_id;
        }
        if ((i6 & 64) != 0) {
            i3 = relationshipStatus.score;
        }
        if ((i6 & 128) != 0) {
            i4 = relationshipStatus.status;
        }
        if ((i6 & 256) != 0) {
            str5 = relationshipStatus.day;
        }
        if ((i6 & 512) != 0) {
            i5 = relationshipStatus.confirm_score;
        }
        return relationshipStatus.copy(str, str2, str3, str4, i, i2, i3, i4, str5, i5);
    }

    public final String component1() {
        return this.id;
    }

    public final int component10() {
        return this.confirm_score;
    }

    public final String component2() {
        return this.data_id;
    }

    public final String component3() {
        return this.uid;
    }

    public final String component4() {
        return this.target_uid;
    }

    public final int component5() {
        return this.is_hidden;
    }

    public final int component6() {
        return this.relation_id;
    }

    public final int component7() {
        return this.score;
    }

    public final int component8() {
        return this.status;
    }

    public final String component9() {
        return this.day;
    }

    public final RelationshipStatus copy(String id, String data_id, String uid, String target_uid, int i, int i2, int i3, int i4, String day, int i5) {
        Intrinsics.e(id, "id");
        Intrinsics.e(data_id, "data_id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(day, "day");
        return new RelationshipStatus(id, data_id, uid, target_uid, i, i2, i3, i4, day, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RelationshipStatus) {
            RelationshipStatus relationshipStatus = (RelationshipStatus) obj;
            return Intrinsics.a((Object) this.id, (Object) relationshipStatus.id) && Intrinsics.a((Object) this.data_id, (Object) relationshipStatus.data_id) && Intrinsics.a((Object) this.uid, (Object) relationshipStatus.uid) && Intrinsics.a((Object) this.target_uid, (Object) relationshipStatus.target_uid) && this.is_hidden == relationshipStatus.is_hidden && this.relation_id == relationshipStatus.relation_id && this.score == relationshipStatus.score && this.status == relationshipStatus.status && Intrinsics.a((Object) this.day, (Object) relationshipStatus.day) && this.confirm_score == relationshipStatus.confirm_score;
        }
        return false;
    }

    public final int getConfirm_score() {
        return this.confirm_score;
    }

    public final String getData_id() {
        return this.data_id;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getId() {
        return this.id;
    }

    public final int getRelation_id() {
        return this.relation_id;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTarget_uid() {
        return this.target_uid;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((((((((((this.id.hashCode() * 31) + this.data_id.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.target_uid.hashCode()) * 31) + this.is_hidden) * 31) + this.relation_id) * 31) + this.score) * 31) + this.status) * 31) + this.day.hashCode()) * 31) + this.confirm_score;
    }

    public final int is_hidden() {
        return this.is_hidden;
    }

    public String toString() {
        return "RelationshipStatus(id=" + this.id + ", data_id=" + this.data_id + ", uid=" + this.uid + ", target_uid=" + this.target_uid + ", is_hidden=" + this.is_hidden + ", relation_id=" + this.relation_id + ", score=" + this.score + ", status=" + this.status + ", day=" + this.day + ", confirm_score=" + this.confirm_score + ')';
    }
}
