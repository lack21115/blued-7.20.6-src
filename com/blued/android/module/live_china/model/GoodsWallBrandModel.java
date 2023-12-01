package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallBrandModel.class */
public final class GoodsWallBrandModel implements Serializable {
    private ArrayList<GoodsWallBrandItemModel> data;
    private String date = "";

    public final ArrayList<GoodsWallBrandItemModel> getData() {
        return this.data;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setData(ArrayList<GoodsWallBrandItemModel> arrayList) {
        this.data = arrayList;
    }

    public final void setDate(String str) {
        Intrinsics.e(str, "<set-?>");
        this.date = str;
    }
}
