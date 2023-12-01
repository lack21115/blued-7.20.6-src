package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomRank.class */
public final class YYRelationShipRoomRank implements MultiItemEntity {
    private YYRelationShipRoomUserCardInfoMode da;
    private final ArrayList<YYRelationShipRoomUserCardInfoMode> list;
    private final int type;

    public YYRelationShipRoomRank(int i, YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode, ArrayList<YYRelationShipRoomUserCardInfoMode> list) {
        Intrinsics.e(list, "list");
        this.type = i;
        this.da = yYRelationShipRoomUserCardInfoMode;
        this.list = list;
    }

    public /* synthetic */ YYRelationShipRoomRank(int i, YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : yYRelationShipRoomUserCardInfoMode, arrayList);
    }

    public static /* synthetic */ YYRelationShipRoomRank copy$default(YYRelationShipRoomRank yYRelationShipRoomRank, int i, YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYRelationShipRoomRank.type;
        }
        if ((i2 & 2) != 0) {
            yYRelationShipRoomUserCardInfoMode = yYRelationShipRoomRank.da;
        }
        if ((i2 & 4) != 0) {
            arrayList = yYRelationShipRoomRank.list;
        }
        return yYRelationShipRoomRank.copy(i, yYRelationShipRoomUserCardInfoMode, arrayList);
    }

    public final int component1() {
        return this.type;
    }

    public final YYRelationShipRoomUserCardInfoMode component2() {
        return this.da;
    }

    public final ArrayList<YYRelationShipRoomUserCardInfoMode> component3() {
        return this.list;
    }

    public final YYRelationShipRoomRank copy(int i, YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode, ArrayList<YYRelationShipRoomUserCardInfoMode> list) {
        Intrinsics.e(list, "list");
        return new YYRelationShipRoomRank(i, yYRelationShipRoomUserCardInfoMode, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomRank) {
            YYRelationShipRoomRank yYRelationShipRoomRank = (YYRelationShipRoomRank) obj;
            return this.type == yYRelationShipRoomRank.type && Intrinsics.a(this.da, yYRelationShipRoomRank.da) && Intrinsics.a(this.list, yYRelationShipRoomRank.list);
        }
        return false;
    }

    public final YYRelationShipRoomUserCardInfoMode getDa() {
        return this.da;
    }

    public int getItemType() {
        return this.type;
    }

    public final ArrayList<YYRelationShipRoomUserCardInfoMode> getList() {
        return this.list;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.type;
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this.da;
        return (((i * 31) + (yYRelationShipRoomUserCardInfoMode == null ? 0 : yYRelationShipRoomUserCardInfoMode.hashCode())) * 31) + this.list.hashCode();
    }

    public final void setDa(YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode) {
        this.da = yYRelationShipRoomUserCardInfoMode;
    }

    public String toString() {
        return "YYRelationShipRoomRank(type=" + this.type + ", da=" + this.da + ", list=" + this.list + ')';
    }
}
