package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveBattleGiftModel.class */
public final class LiveBattleGiftModel implements Serializable {
    private int after_exp;
    private int bonus;
    private int exp;
    private int id;
    private int remain;
    private int total;
    private String icon = "";
    private String name = "";
    private String label = "";
    private String bubble_url = "";
    private String bubble_title = "";
    private String bubble_desc = "";

    public final int getAfter_exp() {
        return this.after_exp;
    }

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

    public final int getExp() {
        return this.exp;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRemain() {
        return this.remain;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setAfter_exp(int i) {
        this.after_exp = i;
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

    public final void setExp(int i) {
        this.exp = i;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLabel(String str) {
        Intrinsics.e(str, "<set-?>");
        this.label = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setRemain(int i) {
        this.remain = i;
    }

    public final void setTotal(int i) {
        this.total = i;
    }
}
