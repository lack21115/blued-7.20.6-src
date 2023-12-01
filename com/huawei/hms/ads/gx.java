package com.huawei.hms.ads;

import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.b;
import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gx.class */
public class gx extends gv {
    public gx(lh lhVar) {
        super(lhVar);
    }

    private void m() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gx.3
            @Override // java.lang.Runnable
            public void run() {
                gx.this.b();
            }
        }, 2000L);
    }

    @Override // com.huawei.hms.ads.gv
    protected void I(AdContentData adContentData) {
    }

    @Override // com.huawei.hms.ads.gv
    protected String c() {
        return String.valueOf(1);
    }

    @Override // com.huawei.hms.ads.gz
    public void k() {
        ge.V("CacheAdMediator", "start");
        lh f = f();
        if (f == null) {
            I(-4);
            L();
            return;
        }
        AdContentData adContentData = null;
        if (this.C.Z() != 0) {
            adContentData = (AdContentData) com.huawei.openalliance.ad.utils.aw.Code(new Callable<AdContentData>() { // from class: com.huawei.hms.ads.gx.1
                @Override // java.util.concurrent.Callable
                /* renamed from: Code */
                public AdContentData call() {
                    AdSlotParam a2 = gx.this.a();
                    if (a2 == null || gx.this.e == null) {
                        ge.I("CacheAdMediator", "adslot is null");
                        return null;
                    }
                    CallResult Code = b.Code(gx.this.e).Code("queryCacheSplashAd", com.huawei.openalliance.ad.utils.z.V(a2), String.class);
                    gx.this.d = (String) Code.getData();
                    return (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) Code.getData(), AdContentData.class, new Class[0]);
                }
            }, null);
        }
        this.B = adContentData;
        this.S = true;
        if (adContentData == null) {
            ge.V("CacheAdMediator", "show sloganView");
            f.Code(new lu() { // from class: com.huawei.hms.ads.gx.2
                @Override // com.huawei.hms.ads.lu
                public void Code() {
                    ge.V("CacheAdMediator", "on Slogan Reach Min Show Time");
                }

                @Override // com.huawei.hms.ads.lu
                public void V() {
                    ge.V("CacheAdMediator", "on Slogan Show End");
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gx.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gx.this.I(498);
                            gx.this.L();
                        }
                    });
                }
            });
        } else if (adContentData.h() == 12) {
            if (I() == 1 && (V() instanceof com.huawei.openalliance.ad.inter.listeners.k)) {
                com.huawei.openalliance.ad.inter.listeners.k kVar = (com.huawei.openalliance.ad.inter.listeners.k) V();
                com.huawei.openalliance.ad.inter.data.l Code = kp.Code(adContentData);
                if (Code != null) {
                    ge.V("CacheAdMediator", "on content find, linkedAd loaded. ");
                    this.F = System.currentTimeMillis();
                    kVar.Code(Code);
                    this.L = adContentData;
                    m();
                    B(200);
                    return;
                }
            }
            I(1200);
            l();
            m();
            return;
        } else if (!V(adContentData)) {
            I(497);
            l();
        }
        m();
    }

    @Override // com.huawei.hms.ads.gz
    public void l() {
        ge.V("CacheAdMediator", "onAdFailToDisplay");
        L();
    }
}
