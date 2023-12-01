package com.huawei.hms.ads;

import com.huawei.hms.ads.reward.Reward;
import com.huawei.openalliance.ad.inter.data.RewardItem;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bx.class */
public class bx implements Reward {
    private String Code;
    private int V;

    public bx() {
    }

    public bx(RewardItem rewardItem) {
        if (rewardItem != null) {
            this.Code = rewardItem.Code();
            this.V = rewardItem.V();
        }
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public int getAmount() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public String getName() {
        return this.Code;
    }
}
