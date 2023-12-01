package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LuckyBagModel.class */
public final class LuckyBagModel implements Serializable {
    private LuckyBagLuckyComeModel break_even;
    private long goods_beans;
    private int goods_id;
    private boolean has_tips;
    private ArrayList<LuckyBagRewardModel> reward_settings;
    private String goods_name = "";
    private String goods_image = "";

    public final LuckyBagLuckyComeModel getBreak_even() {
        return this.break_even;
    }

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

    public final boolean getHas_tips() {
        return this.has_tips;
    }

    public final ArrayList<LuckyBagRewardModel> getReward_settings() {
        return this.reward_settings;
    }

    public final boolean hasLuckyCome() {
        LuckyBagLuckyComeModel luckyBagLuckyComeModel = this.break_even;
        if (luckyBagLuckyComeModel != null) {
            Intrinsics.a(luckyBagLuckyComeModel);
            return luckyBagLuckyComeModel.is_enable();
        }
        return false;
    }

    public final void setBreak_even(LuckyBagLuckyComeModel luckyBagLuckyComeModel) {
        this.break_even = luckyBagLuckyComeModel;
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

    public final void setHas_tips(boolean z) {
        this.has_tips = z;
    }

    public final void setReward_settings(ArrayList<LuckyBagRewardModel> arrayList) {
        this.reward_settings = arrayList;
    }
}
