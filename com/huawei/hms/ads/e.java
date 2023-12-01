package com.huawei.hms.ads;

import com.huawei.hms.ads.inter.data.IInterstitialAd;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/e.class */
public abstract class e {
    private static final byte[] I = new byte[0];
    private static IInterstitialAd V;

    public static IInterstitialAd Code() {
        IInterstitialAd iInterstitialAd;
        synchronized (I) {
            iInterstitialAd = V;
        }
        return iInterstitialAd;
    }

    public static void Code(IInterstitialAd iInterstitialAd) {
        synchronized (I) {
            if (iInterstitialAd == null) {
                ge.Code("InterstitialGlobalDataShare", "set interstitial ad null");
                V = null;
            } else {
                V = iInterstitialAd;
            }
        }
    }
}
