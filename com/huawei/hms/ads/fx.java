package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fx.class */
public class fx {
    private static final String Code = "InterstitialGlobalDataShare";
    private static final byte[] I = new byte[0];
    private static fw V;

    public static fw Code() {
        fw fwVar;
        synchronized (I) {
            fwVar = V;
        }
        return fwVar;
    }

    public static void Code(fw fwVar) {
        synchronized (I) {
            if (fwVar == null) {
                ge.Code(Code, "set interstitial ad null");
                V = null;
            } else {
                V = fwVar;
            }
        }
    }
}
