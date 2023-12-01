package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveBattleGiftExtra.class */
public final class LiveBattleGiftExtra extends BluedEntityBaseExtra implements Serializable {
    private int has_bonus;
    private String duration_desc = "";
    private String reward_desc = "";
    private String unlock_price = "";
    private String alert_desc = "";

    public final String getAlert_desc() {
        return this.alert_desc;
    }

    public final String getDuration_desc() {
        return this.duration_desc;
    }

    public final int getHas_bonus() {
        return this.has_bonus;
    }

    public final String getReward_desc() {
        return this.reward_desc;
    }

    public final String getUnlock_price() {
        return this.unlock_price;
    }

    public final void setAlert_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.alert_desc = str;
    }

    public final void setDuration_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.duration_desc = str;
    }

    public final void setHas_bonus(int i) {
        this.has_bonus = i;
    }

    public final void setReward_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.reward_desc = str;
    }

    public final void setUnlock_price(String str) {
        Intrinsics.e(str, "<set-?>");
        this.unlock_price = str;
    }
}
