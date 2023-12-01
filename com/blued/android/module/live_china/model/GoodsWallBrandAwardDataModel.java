package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallBrandAwardDataModel.class */
public final class GoodsWallBrandAwardDataModel implements Serializable {
    private ArrayList<GoodsWallBrandAwardModel> rewards;
    private int stamp_count;
    private ArrayList<GoodsWallBrandAwardTaskModel> tasks;

    public final ArrayList<GoodsWallBrandAwardModel> getRewards() {
        return this.rewards;
    }

    public final int getStamp_count() {
        return this.stamp_count;
    }

    public final ArrayList<GoodsWallBrandAwardTaskModel> getTasks() {
        return this.tasks;
    }

    public final void setRewards(ArrayList<GoodsWallBrandAwardModel> arrayList) {
        this.rewards = arrayList;
    }

    public final void setStamp_count(int i) {
        this.stamp_count = i;
    }

    public final void setTasks(ArrayList<GoodsWallBrandAwardTaskModel> arrayList) {
        this.tasks = arrayList;
    }
}
