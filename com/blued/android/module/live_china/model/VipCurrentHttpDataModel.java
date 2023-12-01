package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/VipCurrentHttpDataModel.class */
public final class VipCurrentHttpDataModel implements Serializable {
    private int level;
    private int next_level;
    private float next_score;
    private float score;
    private float upgrade_score;
    private String name = "";
    private String next_name = "";

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNext_level() {
        return this.next_level;
    }

    public final String getNext_name() {
        return this.next_name;
    }

    public final float getNext_score() {
        return this.next_score;
    }

    public final float getScore() {
        return this.score;
    }

    public final float getUpgrade_score() {
        return this.upgrade_score;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setNext_level(int i) {
        this.next_level = i;
    }

    public final void setNext_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.next_name = str;
    }

    public final void setNext_score(float f) {
        this.next_score = f;
    }

    public final void setScore(float f) {
        this.score = f;
    }

    public final void setUpgrade_score(float f) {
        this.upgrade_score = f;
    }
}
