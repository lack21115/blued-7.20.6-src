package com.blued.android.module.live_china.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/EnumOperation.class */
public enum EnumOperation {
    VIEW_TYPE_DEFAULT(0),
    VIEW_TYPE_RED_BAG(1),
    VIEW_TYPE_TREASURE_BOX(2),
    VIEW_TYPE_WISHING_KNOCKING(3),
    VIEW_TYPE_WISHING_CONTEST(4),
    VIEW_TYPE_CHICKEN_WIN(5),
    VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG(6),
    VIEW_TYPE_RECHARGE_GIFT_BAG(7),
    VIEW_TYPE_WISHING(8),
    VIEW_TYPE_DARED_ATM(9),
    GOODS_WALL(10),
    POINT_MALL(11),
    NOBLE_RECOMMEND(12);
    
    private final int value;

    EnumOperation(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
