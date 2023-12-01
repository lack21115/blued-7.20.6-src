package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftItemTaskModel.class */
public final class RandomGiftItemTaskModel implements Serializable {
    private int current;
    private int full;
    private ArrayList<RandomGiftItemModel> rewards;
    private String title = "";

    public final int getCurrent() {
        return this.current;
    }

    public final int getFull() {
        return this.full;
    }

    public final ArrayList<RandomGiftItemModel> getRewards() {
        return this.rewards;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setFull(int i) {
        this.full = i;
    }

    public final void setRewards(ArrayList<RandomGiftItemModel> arrayList) {
        this.rewards = arrayList;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
