package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftDialogDataModel.class */
public final class RandomGiftDialogDataModel implements Serializable {
    private RandomGiftDialogAnimationModel animation;
    private RandomGiftDialogRewardModel reward;
    private ArrayList<RandomGiftItemTaskModel> task;
    private RandomGiftDialogTopModel top;
    private String alert_url = "";
    private String desc = "";

    public final String getAlert_url() {
        return this.alert_url;
    }

    public final RandomGiftDialogAnimationModel getAnimation() {
        return this.animation;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final RandomGiftDialogRewardModel getReward() {
        return this.reward;
    }

    public final ArrayList<RandomGiftItemTaskModel> getTask() {
        return this.task;
    }

    public final RandomGiftDialogTopModel getTop() {
        return this.top;
    }

    public final void setAlert_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.alert_url = str;
    }

    public final void setAnimation(RandomGiftDialogAnimationModel randomGiftDialogAnimationModel) {
        this.animation = randomGiftDialogAnimationModel;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setReward(RandomGiftDialogRewardModel randomGiftDialogRewardModel) {
        this.reward = randomGiftDialogRewardModel;
    }

    public final void setTask(ArrayList<RandomGiftItemTaskModel> arrayList) {
        this.task = arrayList;
    }

    public final void setTop(RandomGiftDialogTopModel randomGiftDialogTopModel) {
        this.top = randomGiftDialogTopModel;
    }
}
