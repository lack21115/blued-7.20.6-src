package com.kwad.components.ad.interstitial.c.kwai;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Vibrator;
import android.widget.FrameLayout;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.c.h;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.y;
import com.kwad.components.core.webview.a.b;
import com.kwad.components.core.webview.a.f;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.a.kwai.g;
import com.kwad.components.core.webview.a.kwai.n;
import com.kwad.components.core.webview.a.kwai.q;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.f.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/kwai/b.class */
public final class b extends a {
    private static long ka = 400;
    private d ef;
    private Vibrator eg;
    private an fC;
    private com.kwad.components.ad.f.kwai.kwai.b km;
    private FrameLayout lE;
    private boolean lG;
    private f lH;
    private boolean lF = false;
    private final c.a jz = new c.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.1
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.kwad.components.ad.interstitial.c.c.a
        public final void cr() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    };
    private h ko = new h() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.10
        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            b.this.dk.onPageVisible();
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            b.this.dk.onPageInvisible();
        }
    };
    private com.kwad.sdk.core.g.c dk = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.11
        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            if (b.this.fC != null) {
                b.this.fC.re();
            }
            if (b.this.km != null) {
                b.this.km.fd();
            }
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            if (b.this.fC != null && !b.this.lF) {
                b.a(b.this, true);
                b.this.fC.qZ();
                b.this.fC.ra();
            }
            if (b.this.fC != null) {
                b.this.fC.rd();
            }
            if (b.this.km != null) {
                b.this.km.fe();
            }
            if (!b.this.lG) {
                b.this.jt.hU.getTimerHelper().startTiming();
            }
            if (b.this.lG || b.this.jt.jy || b.this.jt.hN == null) {
                return;
            }
            b.this.jt.hN.onAdShow();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(b.this.jt.mAdTemplate, 3);
            b.b(b.this, true);
        }
    };

    private p a(com.kwad.sdk.core.webview.b bVar) {
        return new p(bVar, this.jt.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.3
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!b.this.jt.jy && b.this.jt.hN != null) {
                        b.this.jt.hN.onAdClicked();
                    }
                    b.this.jt.jw = true;
                    if (!b.this.jt.jy) {
                        b.this.jt.cr();
                    }
                    if (b.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    b.this.jt.a(false, -1, b.this.jt.eN);
                    b.this.jt.hU.dismiss();
                }
            }
        });
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.lF = true;
        return true;
    }

    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.lG = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        if (getContext() != null) {
            this.eg = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        }
        float bt = com.kwad.sdk.core.response.a.b.bt(this.jt.mAdTemplate);
        if (this.ef == null) {
            d dVar = new d(bt);
            this.ef = dVar;
            dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.8
                @Override // com.kwad.sdk.core.f.b
                public final void a(double d) {
                    if (bl.o(b.this.getTKContainer(), 100)) {
                        b.this.d(d);
                    }
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.8.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.ef.xD();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.f.b
                public final void bd() {
                }
            });
        }
        this.ef.e(bt);
        this.ef.aX(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d) {
        this.jt.a(new c.b(getContext()).l(true).c(d).C(2).a(this.jt.jC.getTouchCoords()).D(157));
        bi.vibrate(getContext(), this.eg, ka);
    }

    private g dl() {
        k kVar = new k();
        kVar.Vc = this.jt.jI;
        return new g(kVar);
    }

    /* renamed from: do  reason: not valid java name */
    private com.kwad.components.ad.f.kwai.kwai.a m7624do() {
        final com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.jt.jE.add(new c.InterfaceC0484c() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.2
            @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0484c
            public final void dg() {
                aVar.fb();
            }
        });
        return aVar;
    }

    private aw du() {
        aw awVar = new aw(getContext(), this.jt.mAdTemplate);
        awVar.a(new aw.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.4
            @Override // com.kwad.components.core.webview.jshandler.aw.a
            public final boolean dC() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.jt.mAdTemplate);
                b.this.jt.a(true, -1, (com.kwad.sdk.core.video.videoview.a) null);
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.dx();
                    }
                }, 0L);
                return false;
            }
        });
        return awVar;
    }

    private aa dv() {
        return new aa(new aa.b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.6
            @Override // com.kwad.components.core.webview.jshandler.aa.b
            public final void a(final aa.a aVar) {
                if (b.this.jt.hU != null) {
                    b.this.jt.jC.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.6.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean z = true;
                            if (aVar.type == 0 && !b.this.jt.jw && !b.this.jt.jx && com.kwad.components.ad.interstitial.d.a.c(b.this.jt)) {
                                b.this.jt.jx = true;
                                com.kwad.components.ad.interstitial.a.b.K(b.this.getContext());
                                return;
                            }
                            b.this.er();
                            c cVar = b.this.jt;
                            if (aVar.type != 3) {
                                z = false;
                            }
                            cVar.a(z, aVar.Tm, (com.kwad.sdk.core.video.videoview.a) null);
                            b.this.dx();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        if (this.jt == null) {
            return;
        }
        if (this.jt.hU != null && a(this.jt.hU)) {
            this.jt.hU.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.jt.hN;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.c.a.b(th);
        }
    }

    private com.kwad.components.core.webview.a.c en() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.16
            @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
                cVar2.UX = com.kwad.components.ad.interstitial.b.a.cQ();
                cVar.a(cVar2);
            }
        };
    }

    private f eo() {
        return new f() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.17
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.kwad.components.core.webview.a.f, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        };
    }

    private n ep() {
        return new n() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.5
            @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, final com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.5.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.webview.a.a.d dVar = new com.kwad.components.core.webview.a.a.d();
                        dVar.UY = ag.isWifiConnected(b.this.getContext()) || b.this.jt.dZ.isDataFlowAutoStart() || b.i(b.this.jt.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    private com.kwad.components.core.webview.jshandler.n eq() {
        return new com.kwad.components.core.webview.jshandler.n() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.7
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(y yVar) {
                super.a(yVar);
                if (b.this.jt.jy || b.this.jt.hN == null) {
                    return;
                }
                b.this.jt.hN.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void b(y yVar) {
                super.b(yVar);
                b.this.jt.mAdTemplate.setmCurPlayTime(yVar.nZ);
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void c(y yVar) {
                super.c(yVar);
                if (b.this.jt.jy || b.this.jt.hN == null) {
                    return;
                }
                b.this.jt.hN.onVideoPlayEnd();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er() {
        an anVar = this.fC;
        if (anVar != null) {
            anVar.rb();
            this.fC.rc();
        }
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.km;
        if (bVar != null) {
            bVar.fd();
        }
    }

    private ag.a getOpenNewPageListener() {
        return new ag.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.9
            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0529a().au(bVar.title).av(bVar.url).aA(true).L(b.this.jt.mAdTemplate).oc());
            }
        };
    }

    public static boolean i(AdTemplate adTemplate) {
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        return aX != null && aX.exists();
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jt.a(this.ko);
    }

    public final void b(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.report.a.a(adTemplate, 14, -1L, -1, this.jt.hU.getTimerHelper().getTime(), null);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.lE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-interstitial-card", this.jt.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.lE = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
        super.onRegisterLifecycleLisener(anVar);
        this.fC = anVar;
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        com.kwad.components.ad.f.kwai.kwai.b k = com.kwad.components.ad.f.kwai.kwai.b.k(this.jt.mAdTemplate);
        this.km = k;
        if (k != null) {
            k.a(new b.InterfaceC0472b() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.12
                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0472b
                public final void G(int i) {
                    if (i == com.kwad.components.ad.f.kwai.kwai.b.nP) {
                        b.this.jt.b(b.this.getContext(), b.this.jt.mAdTemplate);
                        b bVar2 = b.this;
                        bVar2.b(bVar2.jt.mAdTemplate, true);
                    }
                    b.this.dx();
                }
            });
            lVar.c(this.km);
            this.km.fc();
        }
        lVar.c(dv());
        lVar.c(new com.kwad.components.core.webview.jshandler.ag(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.cS(com.kwad.sdk.core.response.a.d.cb(this.jt.mAdTemplate))) {
            lVar.c(new ap(new ap.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.13
                @Override // com.kwad.components.core.webview.jshandler.ap.a
                public final void bJ() {
                    b.this.bB();
                }
            }));
        }
        lVar.c(ep());
        lVar.c(du());
        lVar.c(dl());
        lVar.c(a(bVar));
        lVar.c(eq());
        lVar.c(m7624do());
        lVar.c(new q() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.14
            @Override // com.kwad.components.core.webview.a.kwai.q, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.r.h.g(b.this.getContext(), b.this.jt.mAdTemplate);
            }
        });
        this.lH = eo();
        this.jt.a(this.jz);
        lVar.c(this.lH);
        lVar.c(new com.kwad.components.core.webview.a.b(new b.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.b.15
            @Override // com.kwad.components.core.webview.a.b.a
            public final void es() {
                com.kwad.components.ad.interstitial.b.a.L(b.this.getContext());
            }
        }));
        lVar.c(en());
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
        super.onSkipClick(uVar);
        if (this.jt.hN != null) {
            this.jt.hN.onSkippedAd();
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        this.lE.setVisibility(8);
        if (this.jt.gG != null) {
            this.jt.gG.u(getTkTemplateId());
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        if (this.fC != null && this.jt.hL.et()) {
            this.lF = true;
            this.fC.qZ();
            this.fC.ra();
        }
        this.jt.hL.a(this.dk);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.lF = false;
        this.lG = false;
        bi.b(getContext(), this.eg);
        d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        if (this.jt.hL != null) {
            this.jt.hL.b(this.dk);
        }
        this.jt.b(this.jz);
        this.jt.b(this.ko);
    }

    @Override // com.kwad.components.ad.interstitial.c.kwai.a, com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        b(this.jt.mAdTemplate, true);
        dx();
    }
}
