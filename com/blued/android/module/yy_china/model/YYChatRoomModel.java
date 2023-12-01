package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYChatRoomModel.class */
public class YYChatRoomModel implements MultiItemEntity {
    public YYChatR_InnerModel data;
    public int type;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }
}
