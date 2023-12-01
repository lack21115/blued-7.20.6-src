package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.kn;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.SplashAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.bc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.b;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gv.class */
public abstract class gv implements gz {
    protected AdContentData B;
    protected fk C;
    protected WeakReference<lj> I;
    protected AdContentData L;
    protected com.huawei.openalliance.ad.constant.a Z;
    protected RewardVerifyConfig b;

    /* renamed from: c  reason: collision with root package name */
    protected int f22487c;
    protected String d;
    protected Context e;
    private WeakReference<lh> i;
    private b j;
    private SplashView.SplashAdLoadListener k;
    private com.huawei.openalliance.ad.inter.listeners.a s;
    private SplashAdDisplayListener t;
    private CountDownTimer u;
    private String v;
    private ih h = new hv();
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    protected boolean S = false;
    private boolean o = false;
    private final String p = "load_timeout_" + hashCode();
    private boolean q = false;
    private boolean r = false;
    private long w = 0;
    private long x = -1;
    protected long F = 0;
    private int y = 0;
    protected boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    protected DelayInfo f22486a = new DelayInfo();
    private boolean z = false;

    /* renamed from: com.huawei.hms.ads.gv$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gv$1.class */
    class AnonymousClass1 implements RemoteCallResultCallback<String> {
        final /* synthetic */ int Code;

        AnonymousClass1(int i) {
            this.Code = i;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, final CallResult<String> callResult) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gv.1.1
                @Override // java.lang.Runnable
                public void run() {
                    gv gvVar;
                    int i;
                    gv.this.d = (String) callResult.getData();
                    final AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        gv.this.F = System.currentTimeMillis();
                        gv.this.S(AnonymousClass1.this.Code);
                        gv.this.B = adContentData;
                        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.gv.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                gv.this.Code(gv.this.e, adContentData, AnonymousClass1.this.Code);
                            }
                        });
                        if (gv.this.V(adContentData)) {
                            return;
                        }
                        gvVar = gv.this;
                        i = 497;
                    } else {
                        gvVar = gv.this;
                        i = AnonymousClass1.this.Code;
                    }
                    gvVar.I(i);
                    gv.this.l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ads.gv$3  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gv$3.class */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ AdSlotParam Code;
        final /* synthetic */ SplashAdReqParam V;

        /* renamed from: com.huawei.hms.ads.gv$3$1  reason: invalid class name */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gv$3$1.class */
        class AnonymousClass1 implements RemoteCallResultCallback<String> {

            /* renamed from: com.huawei.hms.ads.gv$3$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gv$3$1$1.class */
            class RunnableC04031 implements Runnable {
                final /* synthetic */ long Code;
                final /* synthetic */ CallResult V;

                RunnableC04031(long j, CallResult callResult) {
                    this.Code = j;
                    this.V = callResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    gv.this.f22486a.D(com.huawei.openalliance.ad.utils.v.Code() - this.Code);
                    gv.this.d = (String) this.V.getData();
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) this.V.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        gv.this.v = adContentData.E();
                    }
                    if (adContentData != null) {
                        gv.this.I(adContentData);
                    } else {
                        com.huawei.openalliance.ad.ipc.g.V(gv.this.e).Code("getSpareSplashAd", String.valueOf(gv.this.C.I()), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.gv.3.1.1.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, final CallResult<String> callResult) {
                                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gv.3.1.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        gv.this.d = (String) callResult.getData();
                                        AdContentData adContentData2 = (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                                        if (adContentData2 != null) {
                                            gv.this.Code(adContentData2, 494);
                                        } else {
                                            gv.this.I((AdContentData) null);
                                        }
                                    }
                                });
                            }
                        }, String.class);
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                ge.V("AdMediator", "onDownloaded");
                gv.this.f22486a.Code(gv.this.w, System.currentTimeMillis());
                synchronized (gv.this) {
                    ge.V("AdMediator", "onDownloaded, loadingTimeout:" + gv.this.l);
                    if (!gv.this.S) {
                        gv.this.S = true;
                    }
                    if (callResult.getCode() != 200) {
                        gv.this.f22486a.V(Integer.valueOf(callResult.getCode()));
                    }
                    if (gv.this.l) {
                        gv.this.f22486a.I(-2);
                        gv.this.o = true;
                    } else {
                        gv.this.l = true;
                        com.huawei.openalliance.ad.utils.ba.Code(gv.this.p);
                        ge.V("AdMediator", "cancel loadTimeoutTask");
                        gv.this.f22486a.Z(gv.this.w, System.currentTimeMillis());
                        com.huawei.openalliance.ad.utils.ba.Code(new RunnableC04031(com.huawei.openalliance.ad.utils.v.Code(), callResult));
                    }
                    if (gv.this.o) {
                        gv.this.B((AdContentData) com.huawei.openalliance.ad.utils.z.V(callResult.getData(), AdContentData.class, new Class[0]));
                    }
                }
            }
        }

        AnonymousClass3(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam) {
            this.Code = adSlotParam;
            this.V = splashAdReqParam;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gv.this.e == null) {
                return;
            }
            kk.Code(gv.this.e, com.huawei.openalliance.ad.constant.t.ce, this.Code, com.huawei.openalliance.ad.utils.z.V(this.V), new AnonymousClass1(), String.class);
        }
    }

    /* renamed from: com.huawei.hms.ads.gv$4  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gv$4.class */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (gv.this) {
                ge.V("AdMediator", "on load task timeout, loadingTimeout: %s", Boolean.valueOf(gv.this.l));
                if (!gv.this.l) {
                    gv.this.l = true;
                    com.huawei.openalliance.ad.ipc.g.V(gv.this.e).Code("getSpareSplashAd", String.valueOf(gv.this.C.I()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.gv.4.1
                        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gv.4.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdContentData adContentData = (AdContentData) callResult.getData();
                                    if (adContentData != null) {
                                        gv.this.Code(adContentData, -2);
                                        return;
                                    }
                                    gv.this.I(-2);
                                    gv.this.e();
                                }
                            });
                        }
                    }, AdContentData.class);
                }
            }
        }
    }

    public gv(lh lhVar) {
        this.i = new WeakReference<>(lhVar);
        this.f22487c = lhVar.getAdType();
        Context applicationContext = lhVar.getContext().getApplicationContext();
        this.e = applicationContext;
        this.C = fk.Code(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(AdContentData adContentData) {
        if (this.S && this.o && this.e != null) {
            ge.V("AdMediator", "reportSplashCostTime");
            this.o = false;
            this.f22486a.Code(c());
            this.f22486a.V(this.w, this.F);
            eh.Code(this.e, this.v, this.f22487c, adContentData, this.f22486a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        adContentData.j();
        Context context = this.e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("updateContentOnAdLoad", com.huawei.openalliance.ad.utils.z.V(adContentData), null, null);
        }
    }

    private void Code(int i, int i2, com.huawei.openalliance.ad.uriaction.q qVar, Long l, com.huawei.openalliance.ad.inter.data.m mVar, int i3) {
        Code(l, 1, true);
        ko.Code(this.e, this.B, i, i2, qVar.I(), i3, mVar, com.huawei.openalliance.ad.utils.b.Code(f()), com.huawei.openalliance.ad.utils.ay.Code(f()));
        if (this.z) {
            ge.V("AdMediator", "onDoActionSucc hasShowFinish");
            return;
        }
        this.z = true;
        com.huawei.openalliance.ad.utils.ax.V(this.e);
        C();
    }

    private void Code(int i, String str, Long l) {
        Code(l, i, false);
        if (this.z) {
            ge.V("AdMediator", str);
            return;
        }
        this.z = true;
        com.huawei.openalliance.ad.utils.ax.V(this.e);
    }

    private void Code(Context context, int i, String str, String str2, AdContentData adContentData) {
        List<String> Code;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        AdContentData adContentData2 = adContentData;
        if (adContentData == null) {
            adContentData2 = new AdContentData();
        }
        adContentData2.d(this.f22487c);
        analysisEventReport.Code(adContentData2);
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.S(adContentData2.az());
        analysisEventReport.F(adContentData2.C());
        analysisEventReport.C(adContentData2.S());
        analysisEventReport.I(adContentData2.aA());
        try {
            analysisEventReport.V(Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            ge.Code("AdMediator", "setShowMode error%s", e.getClass().getSimpleName());
        }
        if (a() != null && (Code = a().Code()) != null && !Code.isEmpty()) {
            ge.Code("AdMediator", "setSlotId: %s", Code.get(0));
            analysisEventReport.Z(Code.get(0));
        }
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("rptSplashFailedEvt", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, AdContentData adContentData, int i) {
        if (context == null) {
            return;
        }
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i);
        if (adContentData != null) {
            analysisEventReport.S(adContentData.az());
            analysisEventReport.F(adContentData.C());
            analysisEventReport.C(adContentData.S());
            analysisEventReport.I(adContentData.aA());
        }
        com.huawei.openalliance.ad.ipc.g.V(context).Code("rptStartSpareSplashAd", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
    }

    private void Code(lj ljVar, AdContentData adContentData, lh lhVar) {
        if (adContentData == null || ljVar == null || this.h == null) {
            ge.I("AdMediator", "there is no splash ad or adView is null");
            return;
        }
        ge.V("AdMediator", "initOmsdkResource");
        this.h.Code(this.e, adContentData, lhVar, true);
        ljVar.Code(this.h);
    }

    private void Code(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam) {
        com.huawei.openalliance.ad.utils.f.Code(new AnonymousClass3(adSlotParam, splashAdReqParam), f.a.SPLASH_NET, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final AdContentData adContentData, final int i) {
        if (adContentData != null) {
            ge.V("AdMediator", "use spare ad");
            this.S = true;
            this.v = adContentData.E();
            this.F = System.currentTimeMillis();
            S(i);
            adContentData.C(true);
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.gv.5
                @Override // java.lang.Runnable
                public void run() {
                    gv gvVar = gv.this;
                    gvVar.Code(gvVar.e, adContentData, i);
                }
            });
            I(adContentData);
        }
    }

    private void Code(Long l, int i, boolean z) {
        Code(l != null ? Long.valueOf(System.currentTimeMillis() - l.longValue()) : null, (Integer) 100, Integer.valueOf(i), z);
    }

    private void Code(boolean z) {
        this.q = z;
    }

    private void F(int i) {
        if (this.L != null) {
            Code(this.e, i, this.v, c(), this.L);
            b bVar = this.j;
            if (bVar instanceof com.huawei.openalliance.ad.inter.listeners.k) {
                bVar.Code(-6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i) {
        if (i == -6) {
            Code(this.e, i, this.v, c(), this.L);
        } else {
            Code(this.e, i, this.v, c(), this.B);
        }
        B(i);
    }

    private void S(AdContentData adContentData) {
        if (this.h == null) {
            return;
        }
        if (adContentData != null && adContentData.h() == 9) {
            this.h.Code(jg.Code(0.0f, true, jf.STANDALONE));
        } else if (adContentData != null) {
            if (adContentData.h() == 4 || adContentData.h() == 2) {
                this.h.L();
            }
        }
    }

    private void m() {
        long j = this.x;
        if (j <= 0) {
            j = com.huawei.openalliance.ad.utils.v.Code();
        }
        this.B.Z(j);
    }

    private void n() {
        CountDownTimer countDownTimer = new CountDownTimer(2000L, 500L) { // from class: com.huawei.hms.ads.gv.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                ge.V("AdMediator", "onFinish");
                if (gv.this.Z != com.huawei.openalliance.ad.constant.a.LOADED) {
                    gv.this.I(-10);
                    gv.this.l();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                ge.Code("AdMediator", "onTick = %s", Long.valueOf(j));
            }
        };
        this.u = countDownTimer;
        countDownTimer.start();
    }

    private boolean o() {
        return this.q;
    }

    @Override // com.huawei.hms.ads.gz
    public void B() {
        Code(11, "feedback hasShowFinish", Long.valueOf(this.F));
        lj g = g();
        if (g != null) {
            g.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i) {
        this.o = true;
        this.f22486a.I(i);
        B(this.B);
    }

    public void C() {
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.s;
        if (aVar != null) {
            aVar.V();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.t;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdClick();
        }
        com.huawei.openalliance.ad.utils.ax.V(this.e);
    }

    @Override // com.huawei.hms.ads.gz
    public void C(int i) {
        lh f = f();
        if (f != null) {
            f.I(i);
        }
    }

    protected lj Code(AdContentData adContentData, lh lhVar) {
        lj ljVar;
        if (adContentData != null) {
            lj V = lhVar.V(adContentData.h());
            ljVar = V;
            if (V != null) {
                V.setAdContent(adContentData);
                V.setAdMediator(this);
                if (adContentData.h() == 2 || adContentData.h() == 4) {
                    int i = 0;
                    if (adContentData.am() > 0) {
                        i = adContentData.am();
                    }
                    V.setDisplayDuration(i + (adContentData.an() >= 2000 ? adContentData.an() : this.C.V()));
                }
                Code(V, adContentData, lhVar);
                return V;
            }
        } else {
            ljVar = null;
        }
        return ljVar;
    }

    @Override // com.huawei.hms.ads.gz
    public com.huawei.openalliance.ad.constant.a Code() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(int i) {
        this.y = i;
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(int i, int i2) {
        lj g = g();
        if (g != null) {
            g.Code(i, i2);
        }
        if (this.z) {
            return;
        }
        this.z = true;
        com.huawei.openalliance.ad.utils.ax.V(this.e);
        ko.Code(this.e, this.B, i, i2, (List<String>) null);
        Code(Long.valueOf(this.F), 3, false);
        L();
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(long j) {
        this.x = j;
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.b = rewardVerifyConfig;
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(SplashAdDisplayListener splashAdDisplayListener) {
        this.t = splashAdDisplayListener;
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.k = splashAdLoadListener;
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.gv.2
            @Override // java.lang.Runnable
            public void run() {
                gv.this.C(adContentData);
            }
        });
        lh f = f();
        if (f != null) {
            int D = adContentData.D();
            f.Code(adContentData.D(), adContentData.az() == null);
            f.V();
            if (adContentData.az() == null) {
                f.Code(adContentData, this.C.F());
                f.Code(km.C(adContentData.r()), km.S(adContentData.r()), adContentData.aq(), 1 == D, f.Code(adContentData));
            }
        }
        this.Z = com.huawei.openalliance.ad.constant.a.LOADED;
        CountDownTimer countDownTimer = this.u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ge.V("AdMediator", "ad loaded");
        this.F = System.currentTimeMillis();
        b bVar = this.j;
        if (bVar != null) {
            bVar.Code();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdLoaded();
        }
        m();
        D();
        if (!this.C.k()) {
            Code((Long) null, (Integer) null, (Integer) null, false);
        }
        B(200);
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(AdContentData adContentData, long j, int i) {
        String str;
        if (!this.C.k()) {
            ge.I("AdMediator", "onAdShowEnd - use old adshow event");
            return;
        }
        ge.V("AdMediator", "onAdShowEnd duration: %d showRatio: %d", Long.valueOf(j), Integer.valueOf(i));
        ko.Code(this.e, adContentData, j, i);
        if (adContentData != null) {
            MetaData Z = adContentData.Z();
            if (Z != null) {
                if (j < Z.C() || i < Z.S()) {
                    ge.I("AdMediator", "duration or show ratio is invalid for showId %s", adContentData.B());
                    return;
                } else {
                    Code(Long.valueOf(j), Integer.valueOf(i), (Integer) null, false);
                    return;
                }
            }
            str = "onAdShowEnd - metaData is null";
        } else {
            str = "onAdShowEnd - content record is null";
        }
        ge.I("AdMediator", str);
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.s = aVar;
    }

    @Override // com.huawei.hms.ads.gz
    public void Code(b bVar) {
        this.j = bVar;
    }

    public void Code(Long l, Integer num, Integer num2, boolean z) {
        if (o()) {
            ge.I("AdMediator", "show event already reported before, ignore this");
            return;
        }
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.s;
        if (aVar != null) {
            aVar.Code();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.t;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdShowed();
        }
        ih ihVar = this.h;
        if (ihVar != null) {
            ihVar.D();
        }
        Code(true);
        kn.a aVar2 = new kn.a();
        if (z) {
            aVar2.V(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code()));
        }
        aVar2.Code(l).Code(num).V(num2).Code(com.huawei.openalliance.ad.utils.b.Code(f()));
        ko.Code(this.e, this.B, aVar2.Code());
    }

    @Override // com.huawei.hms.ads.gz
    public boolean Code(int i, int i2, AdContentData adContentData, Long l, com.huawei.openalliance.ad.inter.data.m mVar, int i3) {
        boolean z;
        ge.V("AdMediator", "onTouch");
        Context context = f() instanceof View ? ((View) f()).getContext() : this.e;
        com.huawei.openalliance.ad.uriaction.q Code = com.huawei.openalliance.ad.uriaction.r.Code(context, adContentData, new HashMap(0));
        if (Code instanceof com.huawei.openalliance.ad.uriaction.e) {
            Code.Code(new kx() { // from class: com.huawei.hms.ads.gv.8
            });
        }
        if (Code.Code()) {
            if (18 == i3 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
            }
            Code(i, i2, Code, l, mVar, i3);
            z = true;
        } else {
            z = false;
        }
        com.huawei.openalliance.ad.inter.d.Code(this.e).Code(false);
        return z;
    }

    @Override // com.huawei.hms.ads.gz
    public void D() {
        if (this.r) {
            return;
        }
        this.r = true;
        ko.Code(this.e, this.B);
        ih ihVar = this.h;
        if (ihVar != null) {
            ihVar.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        Context context = this.e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("resetDisplayDateAndCount", null, null, null);
        }
    }

    public int I() {
        return this.y;
    }

    @Override // com.huawei.hms.ads.gz
    public void I(int i) {
        ge.V("AdMediator", "ad failed:" + i);
        if (this.n) {
            ge.V("AdMediator", "ad is already failed");
            return;
        }
        this.n = true;
        this.F = System.currentTimeMillis();
        b bVar = this.j;
        if (bVar != null) {
            bVar.Code(i);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(dq.Code(i));
        }
        com.huawei.openalliance.ad.utils.ax.V(this.e);
        S(i);
    }

    protected abstract void I(AdContentData adContentData);

    @Override // com.huawei.hms.ads.gz
    public void L() {
        ge.V("AdMediator", "notifyAdDismissed");
        if (this.m) {
            ge.V("AdMediator", "ad already dismissed");
            return;
        }
        this.m = true;
        b bVar = this.j;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        AdContentData adContentData = this.B;
        if (adContentData != null && adContentData.aA() != 3) {
            kr.Code(this.e).Code(this.B, -10);
        }
        lj g = g();
        if (g != null) {
            g.destroyView();
        }
    }

    @Override // com.huawei.hms.ads.gz
    public void S() {
        this.f22486a.I(this.w, System.currentTimeMillis());
    }

    public b V() {
        return this.j;
    }

    @Override // com.huawei.hms.ads.gz
    public void V(int i) {
        Context context;
        ge.V("AdMediator", "toShowSpare");
        if (!this.B.al() && (context = this.e) != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("getSpareSplashAd", String.valueOf(this.C.I()), new AnonymousClass1(i), String.class);
            return;
        }
        I(i);
        l();
    }

    @Override // com.huawei.hms.ads.gz
    public void V(long j) {
        this.w = j;
    }

    public boolean V(AdContentData adContentData) {
        ge.V("AdMediator", "showAdContent");
        if (this.b != null) {
            ge.V("AdMediator", "set verifyConfig.");
            adContentData.p(this.b.getData());
            adContentData.q(this.b.getUserId());
        }
        this.D = true;
        lh f = f();
        if (f == null) {
            return false;
        }
        ge.V("AdMediator", "showAdContent, getTemplateIdV3 = %s", adContentData.az());
        if (adContentData.az() == null) {
            this.I = null;
            lj Code = Code(adContentData, f);
            if (Code == null) {
                return false;
            }
            ih ihVar = this.h;
            if (ihVar != null) {
                ihVar.Z();
            }
            S(adContentData);
            f.Code(Code, f.Code(adContentData));
            Code.V();
            this.I = new WeakReference<>(Code);
            return true;
        } else if (!(f instanceof PPSSplashView)) {
            ge.I("AdMediator", "not PPSSplashView");
            return false;
        } else {
            IRemoteCreator Code2 = f.Code(this.e);
            if (Code2 == null) {
                ge.V("AdMediator", "Creator is null");
                return false;
            }
            Cdo cdo = new Cdo(f.getContext(), this, adContentData);
            Bundle bundle = new Bundle();
            bundle.putInt("audioFocusType", f.getAudioFocusType());
            PPSSplashView pPSSplashView = (PPSSplashView) f;
            bundle.putInt(bc.e.C, pPSSplashView.getMediaNameResId());
            bundle.putInt(bc.e.B, pPSSplashView.getLogoResId());
            bundle.putString("content", this.d);
            AdSlotParam a2 = a();
            if (a2 != null) {
                bundle.putInt("orientation", a2.V());
                bundle.putInt(bc.e.Z, a2.f() != null ? a2.f().intValue() : 1);
            }
            try {
                View view = (View) ObjectWrapper.unwrap(Code2.newSplashTemplateView(bundle, cdo));
                if (view == null) {
                    ge.I("AdMediator", "templateView is null;");
                    return false;
                }
                this.h = null;
                f.Code(view);
                Code2.bindData(ObjectWrapper.wrap(view), this.d);
                n();
                return true;
            } catch (Throwable th) {
                ge.I("AdMediator", "create splashTemplateView err: %s", th.getClass().getSimpleName());
                return false;
            }
        }
    }

    @Override // com.huawei.hms.ads.gz
    public void Z() {
        Code(10, "onWhyThisAd hasShowFinish", Long.valueOf(this.F));
        lj g = g();
        if (g != null) {
            g.F();
        }
    }

    public void Z(int i) {
        F(i);
    }

    @Override // com.huawei.hms.ads.gz
    public void Z(AdContentData adContentData) {
        String jSONObject;
        if (adContentData == null) {
            return;
        }
        try {
            if (!com.huawei.openalliance.ad.utils.v.I() && !com.huawei.openalliance.ad.utils.v.D(this.e)) {
                jSONObject = adContentData.S();
                final String str = jSONObject;
                com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.gv.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.gv.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.huawei.openalliance.ad.ipc.g.V(gv.this.e).Code(com.huawei.openalliance.ad.constant.p.r, str, null, null);
                            }
                        });
                    }
                });
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("content_id", adContentData.S());
            jSONObject2.put(com.huawei.openalliance.ad.constant.at.C, adContentData.az());
            jSONObject2.put(com.huawei.openalliance.ad.constant.at.ac, adContentData.C());
            jSONObject2.put(com.huawei.openalliance.ad.constant.at.S, adContentData.aA());
            jSONObject = jSONObject2.toString();
            final String str2 = jSONObject;
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.gv.7
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.gv.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.huawei.openalliance.ad.ipc.g.V(gv.this.e).Code(com.huawei.openalliance.ad.constant.p.r, str2, null, null);
                        }
                    });
                }
            });
        } catch (Throwable th) {
            ge.V("AdMediator", "onMaterialLoadFailed err: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdSlotParam a() {
        lh f = f();
        if (f == null) {
            return null;
        }
        AdSlotParam adSlotParam = f.getAdSlotParam();
        if (adSlotParam != null) {
            this.f22486a.Code(adSlotParam.Code());
        }
        return adSlotParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        AdSlotParam a2 = a();
        Integer num = null;
        if (a2 == null) {
            I((AdContentData) null);
            return;
        }
        Context context = this.e;
        if (context != null) {
            num = com.huawei.openalliance.ad.inter.g.Code(context).I();
        }
        a2.I(num);
        SplashAdReqParam splashAdReqParam = new SplashAdReqParam();
        splashAdReqParam.Code(c());
        splashAdReqParam.Code(this.w);
        String B = com.huawei.openalliance.ad.utils.v.B();
        this.v = B;
        a2.V(B);
        a2.Code(this.f22487c);
        Code(a2, splashAdReqParam);
    }

    protected abstract String c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        int a2 = this.C.a();
        ge.V("AdMediator", "startAdLoadTimeoutTask - max load time: %d", Integer.valueOf(a2));
        com.huawei.openalliance.ad.utils.ba.Code(new AnonymousClass4(), this.p, a2);
    }

    protected void e() {
        L();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public lh f() {
        return this.i.get();
    }

    protected lj g() {
        WeakReference<lj> weakReference = this.I;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.ads.gz
    public void i() {
        ge.V("AdMediator", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.z));
        if (this.z) {
            return;
        }
        this.z = true;
        com.huawei.openalliance.ad.utils.ax.V(this.e);
        L();
    }

    @Override // com.huawei.hms.ads.gz
    public String j() {
        AdContentData adContentData = this.B;
        if (adContentData != null) {
            return adContentData.T();
        }
        return null;
    }
}
