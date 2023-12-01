package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftDialogTopModel.class */
public final class RandomGiftDialogTopModel implements Serializable {
    private int current_count;
    private int full_count;
    private int full_times;
    private boolean isExpand;
    private String light_apng = "";
    private ArrayList<RandomGiftItemModel> list;

    public final int getCurrent_count() {
        return this.current_count;
    }

    public final int getFull_count() {
        return this.full_count;
    }

    public final int getFull_times() {
        return this.full_times;
    }

    public final String getLight_apng() {
        return this.light_apng;
    }

    public final ArrayList<RandomGiftItemModel> getList() {
        return this.list;
    }

    public final boolean isExpand() {
        return this.isExpand;
    }

    public final void setCurrent_count(int i) {
        this.current_count = i;
    }

    public final void setExpand(boolean z) {
        this.isExpand = z;
    }

    public final void setFull_count(int i) {
        this.full_count = i;
    }

    public final void setFull_times(int i) {
        this.full_times = i;
    }

    public final void setLight_apng(String str) {
        Intrinsics.e(str, "<set-?>");
        this.light_apng = str;
    }

    public final void setList(ArrayList<RandomGiftItemModel> arrayList) {
        this.list = arrayList;
    }
}
