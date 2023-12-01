package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomImMode.class */
public final class YYRelationShipRoomImMode {
    private final int beans;
    private final String day;
    private final String goods_id;
    private final String goods_img;
    private final String relation_id;
    private final String relation_name;
    private final String target_uid;
    private final String target_uid_avatar;
    private final String target_uid_name;
    private final String uid;
    private final String uid_avatar;
    private final String uid_name;

    public YYRelationShipRoomImMode(int i, String day, String goods_img, String relation_id, String relation_name, String target_uid, String target_uid_avatar, String target_uid_name, String uid, String goods_id, String uid_avatar, String uid_name) {
        Intrinsics.e(day, "day");
        Intrinsics.e(goods_img, "goods_img");
        Intrinsics.e(relation_id, "relation_id");
        Intrinsics.e(relation_name, "relation_name");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(target_uid_avatar, "target_uid_avatar");
        Intrinsics.e(target_uid_name, "target_uid_name");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(uid_avatar, "uid_avatar");
        Intrinsics.e(uid_name, "uid_name");
        this.beans = i;
        this.day = day;
        this.goods_img = goods_img;
        this.relation_id = relation_id;
        this.relation_name = relation_name;
        this.target_uid = target_uid;
        this.target_uid_avatar = target_uid_avatar;
        this.target_uid_name = target_uid_name;
        this.uid = uid;
        this.goods_id = goods_id;
        this.uid_avatar = uid_avatar;
        this.uid_name = uid_name;
    }

    public static /* synthetic */ YYRelationShipRoomImMode copy$default(YYRelationShipRoomImMode yYRelationShipRoomImMode, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYRelationShipRoomImMode.beans;
        }
        if ((i2 & 2) != 0) {
            str = yYRelationShipRoomImMode.day;
        }
        if ((i2 & 4) != 0) {
            str2 = yYRelationShipRoomImMode.goods_img;
        }
        if ((i2 & 8) != 0) {
            str3 = yYRelationShipRoomImMode.relation_id;
        }
        if ((i2 & 16) != 0) {
            str4 = yYRelationShipRoomImMode.relation_name;
        }
        if ((i2 & 32) != 0) {
            str5 = yYRelationShipRoomImMode.target_uid;
        }
        if ((i2 & 64) != 0) {
            str6 = yYRelationShipRoomImMode.target_uid_avatar;
        }
        if ((i2 & 128) != 0) {
            str7 = yYRelationShipRoomImMode.target_uid_name;
        }
        if ((i2 & 256) != 0) {
            str8 = yYRelationShipRoomImMode.uid;
        }
        if ((i2 & 512) != 0) {
            str9 = yYRelationShipRoomImMode.goods_id;
        }
        if ((i2 & 1024) != 0) {
            str10 = yYRelationShipRoomImMode.uid_avatar;
        }
        if ((i2 & 2048) != 0) {
            str11 = yYRelationShipRoomImMode.uid_name;
        }
        return yYRelationShipRoomImMode.copy(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public final int component1() {
        return this.beans;
    }

    public final String component10() {
        return this.goods_id;
    }

    public final String component11() {
        return this.uid_avatar;
    }

    public final String component12() {
        return this.uid_name;
    }

    public final String component2() {
        return this.day;
    }

    public final String component3() {
        return this.goods_img;
    }

    public final String component4() {
        return this.relation_id;
    }

    public final String component5() {
        return this.relation_name;
    }

    public final String component6() {
        return this.target_uid;
    }

    public final String component7() {
        return this.target_uid_avatar;
    }

    public final String component8() {
        return this.target_uid_name;
    }

    public final String component9() {
        return this.uid;
    }

    public final YYRelationShipRoomImMode copy(int i, String day, String goods_img, String relation_id, String relation_name, String target_uid, String target_uid_avatar, String target_uid_name, String uid, String goods_id, String uid_avatar, String uid_name) {
        Intrinsics.e(day, "day");
        Intrinsics.e(goods_img, "goods_img");
        Intrinsics.e(relation_id, "relation_id");
        Intrinsics.e(relation_name, "relation_name");
        Intrinsics.e(target_uid, "target_uid");
        Intrinsics.e(target_uid_avatar, "target_uid_avatar");
        Intrinsics.e(target_uid_name, "target_uid_name");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(goods_id, "goods_id");
        Intrinsics.e(uid_avatar, "uid_avatar");
        Intrinsics.e(uid_name, "uid_name");
        return new YYRelationShipRoomImMode(i, day, goods_img, relation_id, relation_name, target_uid, target_uid_avatar, target_uid_name, uid, goods_id, uid_avatar, uid_name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomImMode) {
            YYRelationShipRoomImMode yYRelationShipRoomImMode = (YYRelationShipRoomImMode) obj;
            return this.beans == yYRelationShipRoomImMode.beans && Intrinsics.a((Object) this.day, (Object) yYRelationShipRoomImMode.day) && Intrinsics.a((Object) this.goods_img, (Object) yYRelationShipRoomImMode.goods_img) && Intrinsics.a((Object) this.relation_id, (Object) yYRelationShipRoomImMode.relation_id) && Intrinsics.a((Object) this.relation_name, (Object) yYRelationShipRoomImMode.relation_name) && Intrinsics.a((Object) this.target_uid, (Object) yYRelationShipRoomImMode.target_uid) && Intrinsics.a((Object) this.target_uid_avatar, (Object) yYRelationShipRoomImMode.target_uid_avatar) && Intrinsics.a((Object) this.target_uid_name, (Object) yYRelationShipRoomImMode.target_uid_name) && Intrinsics.a((Object) this.uid, (Object) yYRelationShipRoomImMode.uid) && Intrinsics.a((Object) this.goods_id, (Object) yYRelationShipRoomImMode.goods_id) && Intrinsics.a((Object) this.uid_avatar, (Object) yYRelationShipRoomImMode.uid_avatar) && Intrinsics.a((Object) this.uid_name, (Object) yYRelationShipRoomImMode.uid_name);
        }
        return false;
    }

    public final int getBeans() {
        return this.beans;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_img() {
        return this.goods_img;
    }

    public final String getRelation_id() {
        return this.relation_id;
    }

    public final String getRelation_name() {
        return this.relation_name;
    }

    public final String getTarget_uid() {
        return this.target_uid;
    }

    public final String getTarget_uid_avatar() {
        return this.target_uid_avatar;
    }

    public final String getTarget_uid_name() {
        return this.target_uid_name;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUid_avatar() {
        return this.uid_avatar;
    }

    public final String getUid_name() {
        return this.uid_name;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.beans * 31) + this.day.hashCode()) * 31) + this.goods_img.hashCode()) * 31) + this.relation_id.hashCode()) * 31) + this.relation_name.hashCode()) * 31) + this.target_uid.hashCode()) * 31) + this.target_uid_avatar.hashCode()) * 31) + this.target_uid_name.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.goods_id.hashCode()) * 31) + this.uid_avatar.hashCode()) * 31) + this.uid_name.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomImMode(beans=" + this.beans + ", day=" + this.day + ", goods_img=" + this.goods_img + ", relation_id=" + this.relation_id + ", relation_name=" + this.relation_name + ", target_uid=" + this.target_uid + ", target_uid_avatar=" + this.target_uid_avatar + ", target_uid_name=" + this.target_uid_name + ", uid=" + this.uid + ", goods_id=" + this.goods_id + ", uid_avatar=" + this.uid_avatar + ", uid_name=" + this.uid_name + ')';
    }
}
