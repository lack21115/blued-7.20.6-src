package com.kwad.components.ad.reward.kwai;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/kwai/b.class */
public final class b {
    public static int gA() {
        return a.qB.getValue().intValue();
    }

    private static boolean gB() {
        return a.qF.getValue().intValue() == 1;
    }

    public static float gC() {
        return a.qK.getValue().floatValue();
    }

    public static boolean gD() {
        return a.qK.getValue().floatValue() > 0.0f && a.qK.getValue().floatValue() < 1.0f;
    }

    public static boolean gE() {
        return a.qL.getValue().booleanValue();
    }

    public static long gF() {
        return a.qI.getValue().intValue();
    }

    public static int gG() {
        return a.qJ.getValue().intValue();
    }

    public static int gH() {
        return a.qM.getValue().intValue();
    }

    public static boolean gI() {
        return a.qN.getValue().booleanValue();
    }

    public static boolean gJ() {
        return a.qO.getValue().intValue() == 1 || a.qO.getValue().intValue() == 3;
    }

    public static int gw() {
        return a.qz.getValue().intValue();
    }

    public static String gx() {
        return a.qD.getValue();
    }

    public static int gy() {
        return a.qA.getValue().intValue();
    }

    public static boolean gz() {
        return a.qC.getValue().booleanValue();
    }

    public static boolean j(AdInfo adInfo) {
        return !k(adInfo) && com.kwad.sdk.core.response.a.a.co(adInfo) && gB();
    }

    public static boolean k(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.co(adInfo) && a.qH.getValue().intValue() == 1;
    }

    public static boolean l(AdInfo adInfo) {
        return j(adInfo);
    }
}
