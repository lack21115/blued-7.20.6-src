package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RankHourHistoryDataModel.class */
public final class RankHourHistoryDataModel implements Serializable {
    private RankHourDataModel potential;
    private RankHourDataModel top;

    public final RankHourDataModel getPotential() {
        return this.potential;
    }

    public final RankHourDataModel getTop() {
        return this.top;
    }

    public final void setPotential(RankHourDataModel rankHourDataModel) {
        this.potential = rankHourDataModel;
    }

    public final void setTop(RankHourDataModel rankHourDataModel) {
        this.top = rankHourDataModel;
    }
}
