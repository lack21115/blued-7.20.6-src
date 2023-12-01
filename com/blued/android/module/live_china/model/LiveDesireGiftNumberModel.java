package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveDesireGiftNumberModel.class */
public class LiveDesireGiftNumberModel implements MultiItemEntity {
    public static final int DESIRE_GIFI_NUMBER_INPUT_MODEL = 1;
    public static final int DESIRE_GIFI_NUMBER_MODEL = 0;
    public int count;
    public int id;
    public String title;
    public int type = 0;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }
}
