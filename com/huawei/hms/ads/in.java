package com.huawei.hms.ads;

import android.content.Context;
import com.iab.omid.library.huawei.adsession.AdSessionContext;
import com.iab.omid.library.huawei.adsession.Partner;
import com.iab.omid.library.huawei.adsession.VerificationScriptResource;
import java.io.IOException;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/in.class */
public class in implements it {
    private static final String Code = "AdSessionContextWrapper";
    private static boolean I = ii.Code(ii.i);
    private static final String V = "Huawei";
    private Context Z;

    public in(Context context) {
        this.Z = context;
    }

    public static boolean Code() {
        return I;
    }

    public AdSessionContext Code(iw iwVar, String str) {
        String str2;
        if (!ii.Code(ii.p) || !ii.Code(ii.q) || !ii.Code(ii.i)) {
            ge.I(Code, "createNativeAdSessionContext, not available ");
            return null;
        }
        List<VerificationScriptResource> V2 = iwVar.V();
        if (V2.isEmpty()) {
            return null;
        }
        try {
            str2 = com.huawei.openalliance.ad.utils.au.Code("openmeasure/omsdk-v1.js", this.Z);
        } catch (IOException e) {
            ge.I(Code, "getNativeAdSession: " + com.huawei.openalliance.ad.utils.bc.Code(e.getMessage()));
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        return AdSessionContext.createNativeAdSessionContext(Partner.createPartner(V, "13.4.61.304"), str2, V2, str, (String) null);
    }
}
