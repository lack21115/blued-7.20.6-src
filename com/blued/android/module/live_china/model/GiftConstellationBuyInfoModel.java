package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GiftConstellationBuyInfoModel.class */
public final class GiftConstellationBuyInfoModel implements Serializable {
    private String beans = "";
    private String goods_name = "";
    private String count = "";
    private String goods_id = "";
    private String image = "";

    public final String getBeans() {
        return this.beans;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setBeans(String str) {
        Intrinsics.e(str, "<set-?>");
        this.beans = str;
    }

    public final void setCount(String str) {
        Intrinsics.e(str, "<set-?>");
        this.count = str;
    }

    public final void setGoods_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_id = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }
}
