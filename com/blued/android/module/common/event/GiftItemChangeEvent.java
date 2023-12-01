package com.blued.android.module.common.event;

import com.blued.android.module.common.model.BaseGiftModel;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/event/GiftItemChangeEvent.class */
public class GiftItemChangeEvent {
    public BaseGiftModel giftModel;
    public int packageTabIndex;
    public int pageIndex;

    public GiftItemChangeEvent(int i, int i2, BaseGiftModel baseGiftModel) {
        this.packageTabIndex = i;
        this.pageIndex = i2;
        this.giftModel = baseGiftModel;
    }
}
