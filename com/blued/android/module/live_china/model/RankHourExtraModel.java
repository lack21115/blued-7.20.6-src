package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RankHourExtraModel.class */
public final class RankHourExtraModel extends BluedEntityBaseExtra {
    private RankHourDataModel anchor_rank;
    private ArrayList<RankHourDataModel> banner;
    private long current_time;

    public final RankHourDataModel getAnchor_rank() {
        return this.anchor_rank;
    }

    public final ArrayList<RankHourDataModel> getBanner() {
        return this.banner;
    }

    public final long getCurrent_time() {
        return this.current_time;
    }

    public final void setAnchor_rank(RankHourDataModel rankHourDataModel) {
        this.anchor_rank = rankHourDataModel;
    }

    public final void setBanner(ArrayList<RankHourDataModel> arrayList) {
        this.banner = arrayList;
    }

    public final void setCurrent_time(long j) {
        this.current_time = j;
    }
}
