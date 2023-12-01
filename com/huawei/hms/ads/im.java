package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/im.class */
public class im implements it {
    private static boolean Code = ii.Code(ii.g);
    private static final String V = "AdSessionConfiguration";
    private AdSessionConfiguration I;

    private im(ip ipVar, iu iuVar, iv ivVar, iv ivVar2, boolean z) {
        this.I = null;
        if (ip.Code() && iu.Code() && iv.Code()) {
            this.I = AdSessionConfiguration.createAdSessionConfiguration(ip.Code(ipVar), iu.Code(iuVar), iv.Code(ivVar), iv.Code(ivVar2), z);
        }
    }

    public static im Code(ip ipVar, iu iuVar, iv ivVar, iv ivVar2, boolean z) {
        if (Code) {
            return new im(ipVar, iuVar, ivVar, ivVar2, z);
        }
        return null;
    }

    public static boolean Code() {
        return Code;
    }

    public AdSessionConfiguration V() {
        return this.I;
    }
}
