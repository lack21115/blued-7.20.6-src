package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hy.class */
public class hy extends hz implements id {
    private static final String Code = "DisplayEventAgent";
    private static boolean V = ii.Code(ii.e);
    private final List<AdEvents> I = new ArrayList();

    public static boolean Code() {
        return V;
    }

    @Override // com.huawei.hms.ads.id
    public void Code(is isVar) {
        if (isVar instanceof hw) {
            List<AdSession> V2 = ((hw) isVar).V();
            if (V2.isEmpty()) {
                return;
            }
            for (AdSession adSession : V2) {
                if (adSession != null) {
                    this.I.add(AdEvents.createAdEvents(adSession));
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.hz, com.huawei.hms.ads.ix
    public void Code(jb jbVar) {
        VastProperties C;
        ge.V(Code, "load vastPropertiesWrapper");
        if (jbVar == null || !jb.Code() || (C = jbVar.C()) == null) {
            return;
        }
        Code(C);
    }

    @Override // com.huawei.hms.ads.hz
    void Code(VastProperties vastProperties) {
        if (this.I.isEmpty()) {
            return;
        }
        try {
            for (AdEvents adEvents : this.I) {
                adEvents.loaded(vastProperties);
            }
        } catch (IllegalStateException e) {
            ge.V(Code, "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.hz, com.huawei.hms.ads.ix
    public void D() {
        if (this.I.isEmpty()) {
            ge.I(Code, "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            for (AdEvents adEvents : this.I) {
                adEvents.impressionOccurred();
            }
        } catch (IllegalStateException e) {
            ge.V(Code, "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.hz, com.huawei.hms.ads.ix
    public void L() {
        ge.V(Code, "load");
        if (this.I.isEmpty()) {
            ge.V(Code, "load, AdEventList isEmpty");
            return;
        }
        try {
            for (AdEvents adEvents : this.I) {
                adEvents.loaded();
            }
        } catch (IllegalStateException e) {
            ge.V(Code, "loaded, fail");
        }
    }

    @Override // com.huawei.hms.ads.id
    public void V() {
        this.I.clear();
    }
}
