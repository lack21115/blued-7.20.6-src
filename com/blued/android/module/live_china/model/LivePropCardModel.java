package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePropCardModel.class */
public final class LivePropCardModel implements Serializable {
    private int anchor_pocket_traffic_card;
    private String anchor_pocket_traffic_card_name = "";

    public final int getAnchor_pocket_traffic_card() {
        return this.anchor_pocket_traffic_card;
    }

    public final String getAnchor_pocket_traffic_card_name() {
        return this.anchor_pocket_traffic_card_name;
    }

    public final void setAnchor_pocket_traffic_card(int i) {
        this.anchor_pocket_traffic_card = i;
    }

    public final void setAnchor_pocket_traffic_card_name(String str) {
        this.anchor_pocket_traffic_card_name = str;
    }
}
