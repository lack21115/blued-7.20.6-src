package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftRandomBarModel.class */
public final class LiveGiftRandomBarModel implements Serializable {
    private ArrayList<LiveGiftRandomBarItemModel> goods;
    private int light_times;
    private int remain_reward_count;
    private String front_img = "";
    private String img = "";

    public final String getFront_img() {
        return this.front_img;
    }

    public final ArrayList<LiveGiftRandomBarItemModel> getGoods() {
        return this.goods;
    }

    public final String getImg() {
        return this.img;
    }

    public final int getLight_times() {
        return this.light_times;
    }

    public final int getRemain_reward_count() {
        return this.remain_reward_count;
    }

    public final void setFront_img(String str) {
        Intrinsics.e(str, "<set-?>");
        this.front_img = str;
    }

    public final void setGoods(ArrayList<LiveGiftRandomBarItemModel> arrayList) {
        this.goods = arrayList;
    }

    public final void setImg(String str) {
        Intrinsics.e(str, "<set-?>");
        this.img = str;
    }

    public final void setLight_times(int i) {
        this.light_times = i;
    }

    public final void setRemain_reward_count(int i) {
        this.remain_reward_count = i;
    }
}
