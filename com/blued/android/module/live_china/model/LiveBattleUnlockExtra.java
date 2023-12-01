package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveBattleUnlockExtra.class */
public final class LiveBattleUnlockExtra extends BluedEntityBaseExtra implements Serializable {
    private int unlock_price;

    public final int getUnlock_price() {
        return this.unlock_price;
    }

    public final void setUnlock_price(int i) {
        this.unlock_price = i;
    }
}
