package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallTaskItemModel.class */
public final class GoodsWallTaskItemModel implements Serializable {
    private int count;
    private boolean isExpand;
    private int order;
    private int progress;
    private ArrayList<GoodsWallTaskAwardItemModel> rewards;
    private int status = -1;
    private String title = "";

    public final int getCount() {
        return this.count;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final ArrayList<GoodsWallTaskAwardItemModel> getRewards() {
        return this.rewards;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isExpand() {
        return this.isExpand;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setExpand(boolean z) {
        this.isExpand = z;
    }

    public final void setOrder(int i) {
        this.order = i;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final void setRewards(ArrayList<GoodsWallTaskAwardItemModel> arrayList) {
        this.rewards = arrayList;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
