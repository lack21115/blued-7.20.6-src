package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallDataBrandModel.class */
public final class GoodsWallDataBrandModel implements Serializable {
    private GoodsWallInfoModel info;
    private ArrayList<GoodsWallBrandModel> records;

    public final GoodsWallInfoModel getInfo() {
        return this.info;
    }

    public final ArrayList<GoodsWallBrandModel> getRecords() {
        return this.records;
    }

    public final void setInfo(GoodsWallInfoModel goodsWallInfoModel) {
        this.info = goodsWallInfoModel;
    }

    public final void setRecords(ArrayList<GoodsWallBrandModel> arrayList) {
        this.records = arrayList;
    }
}
