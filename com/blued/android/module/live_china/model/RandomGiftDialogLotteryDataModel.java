package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftDialogLotteryDataModel.class */
public final class RandomGiftDialogLotteryDataModel extends BluedEntityBaseExtra implements Serializable {
    private int remain_count;
    private String anchor_name = "";
    private String label = "";
    private String goods_icon = "";
    private String goods_name = "";
    private String goods_type = "";

    public final String getAnchor_name() {
        return this.anchor_name;
    }

    public final String getGoods_icon() {
        return this.goods_icon;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final String getGoods_type() {
        return this.goods_type;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getRemain_count() {
        return this.remain_count;
    }

    public final void setAnchor_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_name = str;
    }

    public final void setGoods_icon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_icon = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }

    public final void setGoods_type(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_type = str;
    }

    public final void setLabel(String str) {
        Intrinsics.e(str, "<set-?>");
        this.label = str;
    }

    public final void setRemain_count(int i) {
        this.remain_count = i;
    }
}
