package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/VipDataModel.class */
public final class VipDataModel implements Serializable {
    private int current_level;
    private float current_score;
    private ArrayList<VipModel> levels;
    private float next_level_score;
    private String current_level_name = "";
    private String next_level_name = "";

    public final int getCurrent_level() {
        return this.current_level;
    }

    public final String getCurrent_level_name() {
        return this.current_level_name;
    }

    public final float getCurrent_score() {
        return this.current_score;
    }

    public final ArrayList<VipModel> getLevels() {
        return this.levels;
    }

    public final String getNext_level_name() {
        return this.next_level_name;
    }

    public final float getNext_level_score() {
        return this.next_level_score;
    }

    public final void setCurrent_level(int i) {
        this.current_level = i;
    }

    public final void setCurrent_level_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.current_level_name = str;
    }

    public final void setCurrent_score(float f) {
        this.current_score = f;
    }

    public final void setLevels(ArrayList<VipModel> arrayList) {
        this.levels = arrayList;
    }

    public final void setNext_level_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.next_level_name = str;
    }

    public final void setNext_level_score(float f) {
        this.next_level_score = f;
    }
}
