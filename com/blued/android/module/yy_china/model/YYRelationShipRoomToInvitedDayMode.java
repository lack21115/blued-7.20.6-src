package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomToInvitedDayMode.class */
public final class YYRelationShipRoomToInvitedDayMode implements MultiItemEntity {
    private final String day;

    public YYRelationShipRoomToInvitedDayMode(String day) {
        Intrinsics.e(day, "day");
        this.day = day;
    }

    public static /* synthetic */ YYRelationShipRoomToInvitedDayMode copy$default(YYRelationShipRoomToInvitedDayMode yYRelationShipRoomToInvitedDayMode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRelationShipRoomToInvitedDayMode.day;
        }
        return yYRelationShipRoomToInvitedDayMode.copy(str);
    }

    public final String component1() {
        return this.day;
    }

    public final YYRelationShipRoomToInvitedDayMode copy(String day) {
        Intrinsics.e(day, "day");
        return new YYRelationShipRoomToInvitedDayMode(day);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYRelationShipRoomToInvitedDayMode) && Intrinsics.a((Object) this.day, (Object) ((YYRelationShipRoomToInvitedDayMode) obj).day);
    }

    public final String getDay() {
        return this.day;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
    }

    public int hashCode() {
        return this.day.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomToInvitedDayMode(day=" + this.day + ')';
    }
}
