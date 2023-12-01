package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSetErrorModel.class */
public final class LiveGiftSetErrorModel implements Serializable {
    private String goods_id = "";
    private String goods_name = "";
    private String count = "";

    public final String getCount() {
        return this.count;
    }

    public final String getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_name() {
        return this.goods_name;
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
}
