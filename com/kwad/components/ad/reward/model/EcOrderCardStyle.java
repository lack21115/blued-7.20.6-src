package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/model/EcOrderCardStyle.class */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);
    
    private int value;

    EcOrderCardStyle(int i) {
        this.value = i;
    }

    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (com.kwad.components.ad.reward.kwai.b.l(adInfo) || com.kwad.components.ad.reward.kwai.b.k(adInfo)) {
            AdProductInfo ct = com.kwad.sdk.core.response.a.a.ct(adInfo);
            boolean hasSpike = ct.hasSpike();
            boolean hasCoupon = ct.hasCoupon();
            return (hasSpike && hasCoupon) ? SPIKE_AND_COUPON : hasSpike ? SPIKE : hasCoupon ? COUPON : ct.hasOriginalPrice() ? NO_SPIKE_AND_NO_COUPON : DEFAULT;
        }
        return null;
    }

    public final int getValue() {
        return this.value;
    }
}
