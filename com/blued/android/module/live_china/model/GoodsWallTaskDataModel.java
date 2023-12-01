package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallTaskDataModel.class */
public final class GoodsWallTaskDataModel implements Serializable {
    private String description = "";
    private ArrayList<GoodsWallTaskItemModel> tasks;

    public final String getDescription() {
        return this.description;
    }

    public final ArrayList<GoodsWallTaskItemModel> getTasks() {
        return this.tasks;
    }

    public final void setDescription(String str) {
        Intrinsics.e(str, "<set-?>");
        this.description = str;
    }

    public final void setTasks(ArrayList<GoodsWallTaskItemModel> arrayList) {
        this.tasks = arrayList;
    }
}
