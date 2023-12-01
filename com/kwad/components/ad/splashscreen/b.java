package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b.class */
public final class b {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b$a.class */
    public static final class a {
        private volatile boolean Bs;

        private a() {
            this.Bs = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b$b.class */
    public static final class C0332b {
        private volatile boolean Bt;

        private C0332b() {
            this.Bt = false;
        }

        /* synthetic */ C0332b(byte b) {
            this();
        }

        static /* synthetic */ boolean a(C0332b c0332b, boolean z) {
            c0332b.Bt = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.n.kwai.b bVar) {
        final SceneImpl sceneImpl = bVar.Ow;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.m.a.pb().pe();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.splash.monitor.a.rY();
            com.kwad.components.splash.monitor.a.C(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.ac();
            KsAdLoadManager.a(new a.C0357a().e(bVar).aH(false).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.splashscreen.b.4
                @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
                public final void a(AdResultData adResultData) {
                    if (adResultData.getAdTemplateList().size() > 0) {
                        int b = SplashPreloadManager.rV().b(adResultData, false);
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + b);
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                        com.kwad.components.core.m.a.pb().aC(adResultData.getAdTemplateList().size());
                    }
                }

                @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
                public final void onError(int i, String str) {
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.b(i, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            }).pj());
        }
    }

    public static void loadSplashScreenAd(KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        final a aVar = new a((byte) 0);
        aVar.Bs = false;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(covert);
        final C0332b c0332b = new C0332b((byte) 0);
        com.kwad.components.core.m.a.pb().pd();
        mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.a(com.kwad.components.core.n.kwai.b.this);
            }
        }, 15000L);
        final Runnable runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // java.lang.Runnable
            public final void run() {
                C0332b.a(C0332b.this, true);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                splashScreenAdListener.onError(com.kwad.sdk.core.network.f.agp.errorCode, com.kwad.sdk.core.network.f.agp.msg);
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.a("", false, com.kwad.sdk.core.network.f.agp.errorCode, com.kwad.sdk.core.network.f.agp.msg, covert.getPosId());
                com.kwad.components.core.m.a.pb().aB(4);
            }
        };
        int a3 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BP);
        int i = a3;
        if (a3 < 0) {
            i = 5000;
        }
        mHandler.postDelayed(runnable, i);
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.B(covert.getPosId());
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0357a().e(bVar).aG(true).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(final int i2, final String str, boolean z) {
                if (C0332b.this.Bt) {
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    return;
                }
                b.mHandler.removeCallbacks(runnable);
                if (!aVar.Bs) {
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.a("", z, i2, str, covert.getPosId());
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        splashScreenAdListener.onError(i2, str);
                        if (i2 == com.kwad.sdk.core.network.f.agq.errorCode) {
                            com.kwad.components.core.m.a.pb().aB(0);
                        } else {
                            com.kwad.components.core.m.a.pb().aB(3);
                        }
                    }
                });
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(final AdResultData adResultData, boolean z) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                if (adResultData.getAdTemplateList().size() <= 0) {
                    if (C0332b.this.Bt) {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    b.mHandler.removeCallbacks(runnable);
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.a("", z, com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg, covert.getPosId());
                    aVar.Bs = true;
                    a(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg : adResultData.testErrorMsg, z);
                    com.kwad.components.core.m.a.pb().aB(3);
                    return;
                }
                AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                adTemplate.notNetworkRequest = z;
                com.kwad.sdk.core.response.a.d.cb(adTemplate);
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.T(adTemplate);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "dataReady").report();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData);
                boolean f = SplashPreloadManager.rV().f(adResultData);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + f);
                if (!f) {
                    SplashPreloadManager.rV();
                    if (!SplashPreloadManager.g(adResultData)) {
                        if (C0332b.this.Bt) {
                            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        b.mHandler.removeCallbacks(runnable);
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.c(adTemplate, 5, elapsedRealtime2);
                        aVar.Bs = true;
                        a(com.kwad.sdk.core.network.f.ago.errorCode, "请求成功，但缓存未命中", z);
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                        com.kwad.components.core.m.a.pb().aB(3);
                        return;
                    }
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int b = SplashPreloadManager.rV().b(adResultData, true);
                    if (!C0332b.this.Bt) {
                        b.mHandler.removeCallbacks(runnable);
                        if (b > 0) {
                            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.b.printStackTrace(th);
                                    }
                                }
                            });
                            com.kwad.components.splash.monitor.a.rY();
                            com.kwad.components.splash.monitor.a.b(adTemplate, 3, elapsedRealtime2);
                            com.kwad.components.core.m.a.pb().aB(2);
                            return;
                        }
                        com.kwad.components.splash.monitor.a.rY();
                        com.kwad.components.splash.monitor.a.c(adTemplate, 4, elapsedRealtime2);
                        aVar.Bs = true;
                        a(com.kwad.sdk.core.network.f.agq.errorCode, com.kwad.sdk.core.network.f.agq.msg, z);
                        return;
                    }
                } else if (!C0332b.this.Bt) {
                    b.mHandler.removeCallbacks(runnable);
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsAdLoadManager.ac().a((KsAdLoadManager) ksSplashScreenAdControl);
                                splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.b.printStackTrace(th);
                            }
                        }
                    });
                    com.kwad.components.splash.monitor.a.rY();
                    com.kwad.components.splash.monitor.a.b(adTemplate, 2, elapsedRealtime2);
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                    com.kwad.components.core.m.a.pb().aB(1);
                    return;
                }
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.c(adTemplate, 7, elapsedRealtime2);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            }
        }).pj());
    }
}
