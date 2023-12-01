package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveBattleGiftReceiveModel.class */
public final class LiveBattleGiftReceiveModel implements Serializable {
    private List<LiveBattleGiftModel> current;
    private List<LiveBattleGiftModel> incomming;

    public final List<LiveBattleGiftModel> getCurrent() {
        return this.current;
    }

    public final List<LiveBattleGiftModel> getIncomming() {
        return this.incomming;
    }

    public final void setCurrent(List<LiveBattleGiftModel> list) {
        this.current = list;
    }

    public final void setIncomming(List<LiveBattleGiftModel> list) {
        this.incomming = list;
    }
}
