package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LuckyBagRewardModel.class */
public final class LuckyBagRewardModel implements Serializable {
    private long goods_beans;
    private int goods_id;
    private String goods_name = "";
    private String goods_image = "";
    private String rate = "";

    public final long getGoods_beans() {
        return this.goods_beans;
    }

    public final int getGoods_id() {
        return this.goods_id;
    }

    public final String getGoods_image() {
        return this.goods_image;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final String getRate() {
        return this.rate;
    }

    public final void setGoods_beans(long j) {
        this.goods_beans = j;
    }

    public final void setGoods_id(int i) {
        this.goods_id = i;
    }

    public final void setGoods_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_image = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }

    public final void setRate(String str) {
        Intrinsics.e(str, "<set-?>");
        this.rate = str;
    }
}
