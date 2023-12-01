package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomMyRoom.class */
public final class YYRelationShipRoomMyRoom implements MultiItemEntity {
    private final YYRelationShipRoomUserCardInfoMode da;
    private final int type;

    public YYRelationShipRoomMyRoom(int i, YYRelationShipRoomUserCardInfoMode da) {
        Intrinsics.e(da, "da");
        this.type = i;
        this.da = da;
    }

    public static /* synthetic */ YYRelationShipRoomMyRoom copy$default(YYRelationShipRoomMyRoom yYRelationShipRoomMyRoom, int i, YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYRelationShipRoomMyRoom.type;
        }
        if ((i2 & 2) != 0) {
            yYRelationShipRoomUserCardInfoMode = yYRelationShipRoomMyRoom.da;
        }
        return yYRelationShipRoomMyRoom.copy(i, yYRelationShipRoomUserCardInfoMode);
    }

    public final int component1() {
        return this.type;
    }

    public final YYRelationShipRoomUserCardInfoMode component2() {
        return this.da;
    }

    public final YYRelationShipRoomMyRoom copy(int i, YYRelationShipRoomUserCardInfoMode da) {
        Intrinsics.e(da, "da");
        return new YYRelationShipRoomMyRoom(i, da);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomMyRoom) {
            YYRelationShipRoomMyRoom yYRelationShipRoomMyRoom = (YYRelationShipRoomMyRoom) obj;
            return this.type == yYRelationShipRoomMyRoom.type && Intrinsics.a(this.da, yYRelationShipRoomMyRoom.da);
        }
        return false;
    }

    public final YYRelationShipRoomUserCardInfoMode getDa() {
        return this.da;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.da.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomMyRoom(type=" + this.type + ", da=" + this.da + ')';
    }
}
