package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomToInvitedGiftMode.class */
public final class YYRelationShipRoomToInvitedGiftMode implements MultiItemEntity {
    private final YYGiftModel mode;

    public YYRelationShipRoomToInvitedGiftMode(YYGiftModel mode) {
        Intrinsics.e(mode, "mode");
        this.mode = mode;
    }

    public static /* synthetic */ YYRelationShipRoomToInvitedGiftMode copy$default(YYRelationShipRoomToInvitedGiftMode yYRelationShipRoomToInvitedGiftMode, YYGiftModel yYGiftModel, int i, Object obj) {
        if ((i & 1) != 0) {
            yYGiftModel = yYRelationShipRoomToInvitedGiftMode.mode;
        }
        return yYRelationShipRoomToInvitedGiftMode.copy(yYGiftModel);
    }

    public final YYGiftModel component1() {
        return this.mode;
    }

    public final YYRelationShipRoomToInvitedGiftMode copy(YYGiftModel mode) {
        Intrinsics.e(mode, "mode");
        return new YYRelationShipRoomToInvitedGiftMode(mode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYRelationShipRoomToInvitedGiftMode) && Intrinsics.a(this.mode, ((YYRelationShipRoomToInvitedGiftMode) obj).mode);
    }

    public int getItemType() {
        return 0;
    }

    public final YYGiftModel getMode() {
        return this.mode;
    }

    public int hashCode() {
        return this.mode.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomToInvitedGiftMode(mode=" + this.mode + ')';
    }
}
