package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bt.class */
public class bt {
    private NativeAd Code;
    private com.huawei.openalliance.ad.inter.data.v I;
    private VideoConfiguration V;

    public bt(NativeAd nativeAd) {
        NativeAdConfiguration ad;
        this.Code = nativeAd;
        if (nativeAd instanceof bs) {
            bs bsVar = (bs) nativeAd;
            this.I = bsVar.Code().B();
            com.huawei.openalliance.ad.inter.data.g Code = bsVar.Code();
            if (!(Code instanceof com.huawei.openalliance.ad.inter.data.n) || (ad = ((com.huawei.openalliance.ad.inter.data.n) Code).ad()) == null) {
                return;
            }
            this.V = ad.getVideoConfiguration();
        }
    }

    public boolean Code() {
        return this.I != null;
    }

    public float I() {
        Float g;
        com.huawei.openalliance.ad.inter.data.v vVar = this.I;
        if (vVar == null || (g = vVar.g()) == null) {
            return 0.0f;
        }
        return g.floatValue();
    }

    public boolean V() {
        com.huawei.openalliance.ad.inter.data.v vVar = this.I;
        return vVar != null && "n".equals(vVar.a());
    }

    public boolean Z() {
        VideoConfiguration videoConfiguration = this.V;
        return videoConfiguration != null && videoConfiguration.isCustomizeOperateRequested();
    }
}
