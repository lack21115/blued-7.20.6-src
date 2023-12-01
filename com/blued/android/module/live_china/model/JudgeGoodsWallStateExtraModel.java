package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/JudgeGoodsWallStateExtraModel.class */
public final class JudgeGoodsWallStateExtraModel extends BluedEntityBaseExtra {
    private int goods_id;
    private int is_goods_pack;
    private int is_valid;
    private int is_wish;
    private String toast = "";

    public final int getGoods_id() {
        return this.goods_id;
    }

    public final String getToast() {
        return this.toast;
    }

    public final int is_goods_pack() {
        return this.is_goods_pack;
    }

    public final int is_valid() {
        return this.is_valid;
    }

    public final int is_wish() {
        return this.is_wish;
    }

    public final void setGoods_id(int i) {
        this.goods_id = i;
    }

    public final void setToast(String str) {
        Intrinsics.e(str, "<set-?>");
        this.toast = str;
    }

    public final void set_goods_pack(int i) {
        this.is_goods_pack = i;
    }

    public final void set_valid(int i) {
        this.is_valid = i;
    }

    public final void set_wish(int i) {
        this.is_wish = i;
    }
}
