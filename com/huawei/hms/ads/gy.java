package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gy.class */
public class gy extends gv {
    boolean f;
    private final int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    public gy(lh lhVar) {
        super(lhVar);
        this.h = hashCode();
        this.i = false;
        this.j = false;
        this.f = false;
        this.k = false;
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ge.V("RealtimeAdMediator", "doOnShowSloganEnd");
        this.j = true;
        if (this.k) {
            ge.V("RealtimeAdMediator", "Ad fails to display or loading timeout, ad dismiss");
            I(499);
            L();
        } else if (this.f) {
        } else {
            ge.V(n(), "doOnShowSloganEnd Ad has been loaded, but not shown yet");
            if (this.l && this.e != null) {
                com.huawei.openalliance.ad.ipc.g.V(this.e).Code("getNormalSplashAd", String.valueOf(this.C.I()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.gy.3
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gy.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                gy.this.B = (AdContentData) callResult.getData();
                                if (gy.this.B != null) {
                                    ge.V(gy.this.n(), "linked loaded, display normal when slogan ends");
                                    gy.this.I(gy.this.B);
                                    gy.this.Z(1202);
                                    return;
                                }
                                ge.V(gy.this.n(), "linked loaded, do not call play");
                                gy.this.I(-6);
                                gy.this.L();
                            }
                        });
                    }
                }, AdContentData.class);
            } else if (this.B != null) {
                ge.V(n(), "show splash");
                I(this.B);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ge.V("RealtimeAdMediator", "doOnReachMinSloganShowTime");
        this.i = true;
        if (!this.f && this.B != null) {
            I(this.B);
            return;
        }
        ge.V("RealtimeAdMediator", "doOnReachMinSloganShowTime adFailToDisplay: %s", Boolean.valueOf(this.k));
        if (this.k) {
            ge.V("RealtimeAdMediator", "ad fail to load when reach min slogan show time");
            I(499);
            L();
        }
    }

    @Override // com.huawei.hms.ads.gv
    protected void I(AdContentData adContentData) {
        ge.V("RealtimeAdMediator", "on content loaded");
        this.B = adContentData;
        if (adContentData == null) {
            I(494);
            l();
            return;
        }
        lh f = f();
        if (f == null) {
            I(497);
            l();
            return;
        }
        el elVar = new el(f.getContext());
        if (elVar.Code()) {
            I(496);
            l();
        } else if (this.B.h() != 12) {
            if (!this.i && !this.j) {
                ge.V("RealtimeAdMediator", "slogan hasn't reach min show time or end, show ad later");
            } else if (elVar.Code()) {
                I(496);
                l();
            } else {
                boolean V = V(this.B);
                this.f = true;
                if (V) {
                    return;
                }
                V(497);
            }
        } else {
            if (I() == 1 && (V() instanceof com.huawei.openalliance.ad.inter.listeners.k)) {
                ge.V("RealtimeAdMediator", "on linked loaded, sloganShowEnd:" + this.j);
                if (!this.j) {
                    com.huawei.openalliance.ad.inter.listeners.k kVar = (com.huawei.openalliance.ad.inter.listeners.k) V();
                    com.huawei.openalliance.ad.inter.data.l Code = kp.Code(this.B);
                    if (Code != null) {
                        ge.V(n(), "on content loaded, linkedAd loaded. ");
                        this.F = System.currentTimeMillis();
                        kVar.Code(Code);
                        this.L = this.B;
                        this.l = true;
                        B(200);
                        return;
                    }
                }
            }
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gy.4
                @Override // java.lang.Runnable
                public void run() {
                    gy.this.I(1200);
                    gy.this.l();
                }
            });
        }
    }

    @Override // com.huawei.hms.ads.gv
    protected String c() {
        return String.valueOf(2);
    }

    @Override // com.huawei.hms.ads.gz
    public void k() {
        ge.V("RealtimeAdMediator", "start");
        lh f = f();
        if (f == null) {
            I(-4);
            L();
            return;
        }
        b();
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.gy.1
            @Override // java.lang.Runnable
            public void run() {
                gy.this.F();
            }
        });
        f.Code(new lu() { // from class: com.huawei.hms.ads.gy.2
            @Override // com.huawei.hms.ads.lu
            public void Code() {
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gy.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        gy.this.p();
                    }
                });
            }

            @Override // com.huawei.hms.ads.lu
            public void V() {
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gy.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        gy.this.o();
                    }
                });
            }
        });
        d();
    }

    @Override // com.huawei.hms.ads.gz
    public void l() {
        ge.V("RealtimeAdMediator", "onAdFailToDisplay - reachMinSloganShowTime: %s sloganShowEnd: %s", Boolean.valueOf(this.i), Boolean.valueOf(this.j));
        this.k = true;
        if (this.i || this.j) {
            L();
        }
    }

    protected String n() {
        return "RealtimeAdMediator" + this.h;
    }
}
