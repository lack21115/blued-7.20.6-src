package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePlanetExtra.class */
public final class LivePlanetExtra extends BluedEntityBaseExtra implements Serializable {
    private int bet_count;
    private int ship_count;

    public final int getBet_count() {
        return this.bet_count;
    }

    public final int getShip_count() {
        return this.ship_count;
    }

    public final void setBet_count(int i) {
        this.bet_count = i;
    }

    public final void setShip_count(int i) {
        this.ship_count = i;
    }
}
