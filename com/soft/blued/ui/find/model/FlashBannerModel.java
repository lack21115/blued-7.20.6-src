package com.soft.blued.ui.find.model;

import com.blued.android.chat.model.FlashVideoGiftModel;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/FlashBannerModel.class */
public class FlashBannerModel extends FlashVideoGiftModel {
    public String uid;

    public FlashBannerModel() {
    }

    public FlashBannerModel(FlashVideoGiftModel flashVideoGiftModel) {
        copy(flashVideoGiftModel);
    }

    public void copy(FlashVideoGiftModel flashVideoGiftModel) {
        if (flashVideoGiftModel != null) {
            this.roomId = flashVideoGiftModel.roomId;
            this.addTime = flashVideoGiftModel.addTime;
            this.addLike = flashVideoGiftModel.addLike;
            this.totalTime = flashVideoGiftModel.totalTime;
            this.totalLike = flashVideoGiftModel.totalLike;
            this.giftIcon = flashVideoGiftModel.giftIcon;
            this.giftName = flashVideoGiftModel.giftName;
        }
    }
}
