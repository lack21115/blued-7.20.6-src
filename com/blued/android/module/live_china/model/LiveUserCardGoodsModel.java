package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveUserCardGoodsModel.class */
public final class LiveUserCardGoodsModel implements Serializable {
    private ArrayList<LiveUserCardGalleryItemModel> data;
    private String desc;
    private String title;

    public final ArrayList<LiveUserCardGalleryItemModel> getData() {
        return this.data;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setData(ArrayList<LiveUserCardGalleryItemModel> arrayList) {
        this.data = arrayList;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
