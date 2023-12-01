package com.blued.android.module.live_china.model;

import com.blued.android.core.AppInfo;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveScrawlBuyResult.class */
public class LiveScrawlBuyResult extends PayRemaining {
    public long danmu_count;
    public List<LiveGiftScrawlModel> goods;
    public int join_club;

    @Override // com.blued.android.module.live_china.model.PayRemaining, com.blued.android.module.live.base.model.BasePayRemaining
    public String toString() {
        return "LiveScrawlBuyResult{" + super.toString() + ", join_club=" + this.join_club + ", danmu_count=" + this.danmu_count + ", goods=" + AppInfo.f().toJson(this.goods) + '}';
    }
}
