package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftHostDialogDataModel.class */
public final class RandomGiftHostDialogDataModel implements Serializable {
    private String alert_url = "";
    private ArrayList<RandomGiftItemModel> reward_power;
    private ArrayList<RandomGiftItemModel> reward_record;
    private ArrayList<RandomGiftItemModel> rewards;

    public final String getAlert_url() {
        return this.alert_url;
    }

    public final ArrayList<RandomGiftItemModel> getReward_power() {
        return this.reward_power;
    }

    public final ArrayList<RandomGiftItemModel> getReward_record() {
        return this.reward_record;
    }

    public final ArrayList<RandomGiftItemModel> getRewards() {
        return this.rewards;
    }

    public final void setAlert_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.alert_url = str;
    }

    public final void setReward_power(ArrayList<RandomGiftItemModel> arrayList) {
        this.reward_power = arrayList;
    }

    public final void setReward_record(ArrayList<RandomGiftItemModel> arrayList) {
        this.reward_record = arrayList;
    }

    public final void setRewards(ArrayList<RandomGiftItemModel> arrayList) {
        this.rewards = arrayList;
    }
}
