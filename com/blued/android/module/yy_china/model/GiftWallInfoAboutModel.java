package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/GiftWallInfoAboutModel.class */
public final class GiftWallInfoAboutModel implements MultiItemEntity {
    private YYCollectorConfigMode allDa;
    private boolean isTop;
    private int item;
    private int type;

    public final YYCollectorConfigMode getAllDa() {
        return this.allDa;
    }

    public final int getItem() {
        return this.item;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isTop() {
        return this.isTop;
    }

    public final void setAllDa(YYCollectorConfigMode yYCollectorConfigMode) {
        this.allDa = yYCollectorConfigMode;
    }

    public final void setItem(int i) {
        this.item = i;
    }

    public final void setTop(boolean z) {
        this.isTop = z;
    }

    public final GiftWallInfoAboutModel setType(int i) {
        this.type = i;
        return this;
    }

    /* renamed from: setType  reason: collision with other method in class */
    public final void m4706setType(int i) {
        this.type = i;
    }
}
