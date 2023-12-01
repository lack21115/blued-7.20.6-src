package com.kwad.components.ad.interstitial.kwai;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/kwai/b.class */
public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r0 <= 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(com.kwad.sdk.core.response.model.AdInfo r3) {
        /*
            com.kwad.sdk.core.config.item.k r0 = com.kwad.components.ad.interstitial.kwai.a.jd
            java.lang.Integer r0 = r0.getValue()
            int r0 = r0.intValue()
            r5 = r0
            r0 = r3
            boolean r0 = com.kwad.sdk.core.response.a.a.aU(r0)
            if (r0 == 0) goto L22
            r0 = r3
            int r0 = com.kwad.sdk.core.response.a.a.F(r0)
            r4 = r0
            r0 = r5
            if (r0 != 0) goto L1c
            r0 = r4
            return r0
        L1c:
            r0 = r5
            r1 = r4
            int r0 = java.lang.Math.min(r0, r1)
            return r0
        L22:
            r0 = r5
            r1 = 60
            if (r0 > r1) goto L2e
            r0 = r5
            r4 = r0
            r0 = r5
            if (r0 > 0) goto L31
        L2e:
            r0 = 60
            r4 = r0
        L31:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.interstitial.kwai.b.b(com.kwad.sdk.core.response.model.AdInfo):int");
    }

    public static boolean c(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.co(adInfo) && a.jg.getValue().intValue() == 1;
    }

    public static boolean cH() {
        return a.jf.getValue().booleanValue();
    }

    public static boolean cI() {
        return a.iZ.getValue().intValue() == 1;
    }

    public static int cJ() {
        return a.ja.getValue().intValue();
    }

    public static boolean cK() {
        return a.jb.getValue().intValue() == 1;
    }

    public static boolean cL() {
        return a.jc.getValue().intValue() == 1;
    }

    public static int cM() {
        return a.jh.getValue().intValue();
    }

    public static boolean cN() {
        return a.je.getValue().intValue() == 1;
    }
}
