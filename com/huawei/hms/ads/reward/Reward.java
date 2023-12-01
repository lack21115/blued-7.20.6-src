package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.bx;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/reward/Reward.class */
public interface Reward {
    public static final Reward DEFAULT = new bx();

    int getAmount();

    String getName();
}
