package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BattlePassBonusHistoryDataModel.class */
public final class BattlePassBonusHistoryDataModel implements Serializable {
    private int count;
    private int uid;
    private String name = "";
    private int is_hide = 1;
    private int level = 1;
    private String icon = "";
    private String goods_name = "";

    public final int getCount() {
        return this.count;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUid() {
        return this.uid;
    }

    public final int is_hide() {
        return this.is_hide;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setUid(int i) {
        this.uid = i;
    }

    public final void set_hide(int i) {
        this.is_hide = i;
    }
}
