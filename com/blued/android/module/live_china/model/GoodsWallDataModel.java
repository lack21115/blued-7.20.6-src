package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallDataModel.class */
public final class GoodsWallDataModel implements Serializable {
    private ArrayList<GoodsWallItemModel> aglow;
    private GoodsWallInfoModel info;
    private ArrayList<GoodsWallItemModel> not_aglow;

    public final ArrayList<GoodsWallItemModel> getAglow() {
        return this.aglow;
    }

    public final GoodsWallInfoModel getInfo() {
        return this.info;
    }

    public final ArrayList<GoodsWallItemModel> getNot_aglow() {
        return this.not_aglow;
    }

    public final void setAglow(ArrayList<GoodsWallItemModel> arrayList) {
        this.aglow = arrayList;
    }

    public final void setInfo(GoodsWallInfoModel goodsWallInfoModel) {
        this.info = goodsWallInfoModel;
    }

    public final void setNot_aglow(ArrayList<GoodsWallItemModel> arrayList) {
        this.not_aglow = arrayList;
    }
}
