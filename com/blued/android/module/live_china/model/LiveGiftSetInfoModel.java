package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftSetInfoModel.class */
public final class LiveGiftSetInfoModel implements Serializable {
    private int expire_time;
    private int id;
    private int is_finish;
    private ArrayList<LiveGiftSetItemModel> progress;
    private String name = "";
    private String goods_set_animation = "";

    public final int getExpire_time() {
        return this.expire_time;
    }

    public final String getGoods_set_animation() {
        return this.goods_set_animation;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<LiveGiftSetItemModel> getProgress() {
        return this.progress;
    }

    public final int is_finish() {
        return this.is_finish;
    }

    public final void setExpire_time(int i) {
        this.expire_time = i;
    }

    public final void setGoods_set_animation(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_set_animation = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setProgress(ArrayList<LiveGiftSetItemModel> arrayList) {
        this.progress = arrayList;
    }

    public final void set_finish(int i) {
        this.is_finish = i;
    }
}
