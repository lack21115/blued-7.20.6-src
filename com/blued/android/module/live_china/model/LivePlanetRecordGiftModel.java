package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePlanetRecordGiftModel.class */
public final class LivePlanetRecordGiftModel implements Serializable {
    private int goods_count;
    private String goods_id = "";
    private String goods_name = "";
    private String goods_image = "";

    public final int getGoods_count() {
        return this.goods_count;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_image() {
        return this.goods_image;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final void setGoods_count(int i) {
        this.goods_count = i;
    }

    public final void setGoods_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_id = str;
    }

    public final void setGoods_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_image = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }
}
