package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BattlePassLevelAwardDataModel.class */
public final class BattlePassLevelAwardDataModel implements Serializable {
    private int bonus;
    private int state;
    private String bubble_url = "";
    private String bubble_title = "";
    private String bubble_desc = "";
    private String icon = "";
    private String label = "";

    public final int getBonus() {
        return this.bonus;
    }

    public final String getBubble_desc() {
        return this.bubble_desc;
    }

    public final String getBubble_title() {
        return this.bubble_title;
    }

    public final String getBubble_url() {
        return this.bubble_url;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getState() {
        return this.state;
    }

    public final void setBonus(int i) {
        this.bonus = i;
    }

    public final void setBubble_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bubble_desc = str;
    }

    public final void setBubble_title(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bubble_title = str;
    }

    public final void setBubble_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bubble_url = str;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setLabel(String str) {
        Intrinsics.e(str, "<set-?>");
        this.label = str;
    }

    public final void setState(int i) {
        this.state = i;
    }
}
