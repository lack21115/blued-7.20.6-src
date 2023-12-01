package com.kwad.components.ad.interstitial.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.z;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.a.kwai.u;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/d.class */
public final class d extends b {
    private static long ka = 400;
    private static float kb = 0.8f;
    private static float kc = 1.0f;
    private static float kd = 0.749f;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private KsAdVideoPlayConfig dZ;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;
    private an fC;
    private boolean fG;
    private ap jZ;
    private c jt;
    private KSFrameLayout ke;
    private KSFrameLayout kf;
    private Dialog kg;
    private KsAdWebView kh;
    private ImageView ki;
    private a.c kj;
    private p kk;
    private c.a kl;
    private com.kwad.components.ad.f.kwai.kwai.b km;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    protected Context mContext;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int cW = -1;
    private boolean kn = false;
    private h ko = new h() { // from class: com.kwad.components.ad.interstitial.c.d.1
        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            d.this.dk.onPageVisible();
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            d.this.dk.onPageInvisible();
        }
    };
    private com.kwad.sdk.core.g.c dk = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.d.12
        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageInvisible");
            if (d.this.fC != null) {
                d.this.fC.rb();
                d.this.fC.rc();
            }
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageVisible");
            if (d.this.fC != null) {
                d.this.fC.qZ();
                d.this.fC.ra();
            }
        }
    };
    private final Runnable kp = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.20
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "rollBackRunnable run");
            d.this.w("4");
        }
    };
    private ac.a kq = new ac.a() { // from class: com.kwad.components.ad.interstitial.c.d.25
        @Override // com.kwad.components.core.webview.jshandler.ac.a
        public final void onAdShow() {
            if (d.this.mAdTemplate.mPvReported || d.this.jt.jy || d.this.jt.hN == null) {
                return;
            }
            d.this.jt.hN.onAdShow();
            d.this.jt.hU.getTimerHelper().startTiming();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(d.this.mAdTemplate, 2);
        }
    };
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.ad.interstitial.c.d.18
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            if (d.this.fG || d.this.kn) {
                return;
            }
            d.this.cW = aVar.status;
            if (d.this.cW != 1) {
                d.this.w("3");
                return;
            }
            d.this.kh.setVisibility(0);
            com.kwad.components.core.m.a.pb().N(d.this.mAdTemplate);
            d.this.mHandler.removeCallbacksAndMessages(null);
            bi.b(d.this.kp);
            if (d.this.km != null) {
                d.this.km.fc();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams E(int i) {
        int i2 = (int) (i * kd);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    private static float a(boolean z, boolean z2) {
        return (z && z2) ? 1.7777778f : 0.749f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams a(int i, boolean z) {
        int i2 = (int) (i * (z ? kb : kc));
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? 1.7777778f : 0.749f)));
    }

    private static ViewGroup.MarginLayoutParams a(WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        marginLayoutParams.topMargin = videoPosition.topMargin;
        marginLayoutParams.leftMargin = videoPosition.leftMargin;
        marginLayoutParams.width = videoPosition.width;
        marginLayoutParams.height = videoPosition.height;
        return marginLayoutParams;
    }

    private static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
        marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
        marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
        marginLayoutParams2.width = marginLayoutParams.width;
        marginLayoutParams2.height = marginLayoutParams.height;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(dz());
        aVar.a(dy());
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(dr());
        aVar.a(new v(this.cV));
        aVar.a(dq());
        aVar.a(dp());
        aVar.a(dv());
        an anVar = new an();
        this.fC = anVar;
        aVar.a(anVar);
        this.jt.a(ds());
        aVar.a(dw());
        aVar.a(dt());
        aVar.a(new y(this.cV));
        aVar.a(dm());
        aVar.a(new ai(this.cZ, str));
        aVar.a(dk());
        ac acVar = new ac(this.cV);
        acVar.a(this.kq);
        aVar.a(acVar);
        aVar.a(du());
        aVar.a(new ag(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.cS(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            aVar.a(dj());
        }
        if (dn() != null) {
            aVar.a(this.km);
        }
        aVar.a(dl());
        aVar.a(m4613do());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setWidthBasedRatio(!z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + ", " + marginLayoutParams.height);
        a(videoPosition, marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
        float aP = com.kwad.sdk.core.response.a.a.aP(adInfo);
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + aP);
        if (!z || aP <= 0.0f) {
            kSFrameLayout.setRatio(0.0f);
        } else {
            int i = marginLayoutParams.width;
            int i2 = (int) (marginLayoutParams.height / aP);
            marginLayoutParams.width = i2;
            marginLayoutParams.leftMargin += (i - i2) / 2;
            if (marginLayoutParams.width != 0) {
                float f = marginLayoutParams.height / marginLayoutParams.width;
                com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "cardParams ratio: " + f);
                kSFrameLayout.setRatio(f);
            }
        }
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
        kSFrameLayout.setLayoutParams(marginLayoutParams);
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        if (videoPosition.cornerRadius != null) {
            kSFrameLayout.setRadius((float) videoPosition.cornerRadius.topLeft, (float) videoPosition.cornerRadius.topRight, (float) videoPosition.cornerRadius.bottomRight, (float) videoPosition.cornerRadius.bottomLeft);
        } else if (marginLayoutParams.width > marginLayoutParams.height) {
            kSFrameLayout.setRadius(dimension, dimension, 0.0f, 0.0f);
        } else {
            kSFrameLayout.setRadius(dimension, dimension, dimension, dimension);
        }
        if (z) {
            this.ki.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.ki.getLayoutParams();
            a(marginLayoutParams2, marginLayoutParams3);
            this.ki.setLayoutParams(marginLayoutParams3);
            this.jt.a(this.mContext, adInfo, this.mAdTemplate, this.ki);
        } else {
            this.ki.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            kSFrameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.kwad.components.ad.interstitial.c.d.17
                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View view, Outline outline) {
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                }
            });
            kSFrameLayout.setClipToOutline(true);
        }
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.kn = true;
        return true;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.jt.mAdTemplate);
        boolean DL = com.kwad.sdk.utils.ai.DL();
        this.cV.mScreenOrientation = !DL ? 1 : 0;
        this.cV.app = this.ke;
        this.cV.LD = this.ke;
        this.cV.Lc = this.kh;
        this.cV.mReportExtData = null;
    }

    private void aG() {
        String bw = com.kwad.sdk.core.response.a.b.bw(this.mAdTemplate);
        if (TextUtils.isEmpty(bw) || this.kh == null) {
            w("1");
        } else {
            v(bw);
        }
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        float bt = com.kwad.sdk.core.response.a.b.bt(this.mAdTemplate);
        if (this.ef == null) {
            com.kwad.sdk.core.f.d dVar = new com.kwad.sdk.core.f.d(bt);
            this.ef = dVar;
            dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.interstitial.c.d.19
                @Override // com.kwad.sdk.core.f.b
                public final void a(double d) {
                    if (bl.o(d.this.ke, 100)) {
                        d.this.d(d);
                    }
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.19.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                            d.this.ef.xD();
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
        this.jt.a(new c.b(getContext()).l(true).c(d).C(2).a(this.ke.getTouchCoords()).D(157));
        bi.a(getContext(), this.eg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        final boolean aO = com.kwad.sdk.core.response.a.a.aO(this.mAdInfo);
        final boolean DL = com.kwad.sdk.utils.ai.DL();
        float a2 = a(DL, aO);
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + a2);
        this.jt.ju.setRatio(a2);
        final ViewGroup viewGroup = (ViewGroup) this.ke.findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.24
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams a3 = DL ? d.a(d.this.ke.getWidth(), aO) : d.E(d.this.ke.getHeight());
                if (d.this.kh != null) {
                    d.this.kh.setVisibility(8);
                }
                d.this.kf.setVisibility(8);
                ViewParent parent = d.this.jt.ju.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.jt.ju);
                }
                viewGroup.addView(d.this.jt.ju);
                d.this.jt.ju.f(a3.width, a3.height);
                d.this.eN.requestLayout();
                d.a(d.this, true);
            }
        });
    }

    private ap dj() {
        ap apVar = new ap(new ap.a() { // from class: com.kwad.components.ad.interstitial.c.d.26
            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void bJ() {
                d.this.bB();
            }
        });
        this.jZ = apVar;
        return apVar;
    }

    private aq dk() {
        return new aq(this.cV, this.mApkDownloadHelper);
    }

    private com.kwad.components.core.webview.a.kwai.g dl() {
        com.kwad.components.core.webview.a.a.k kVar = new com.kwad.components.core.webview.a.a.k();
        kVar.Vc = this.jt.jI;
        return new com.kwad.components.core.webview.a.kwai.g(kVar);
    }

    private u dm() {
        u uVar = new u(this.cV);
        uVar.a(new u.b() { // from class: com.kwad.components.ad.interstitial.c.d.2
            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                aVar.height = com.kwad.sdk.c.kwai.a.getScreenHeight(d.this.mContext);
                aVar.width = com.kwad.sdk.c.kwai.a.getScreenHeight(d.this.mContext);
            }
        });
        return uVar;
    }

    private com.kwad.components.ad.f.kwai.kwai.b dn() {
        com.kwad.components.ad.f.kwai.kwai.b k = com.kwad.components.ad.f.kwai.kwai.b.k(this.mAdTemplate);
        this.km = k;
        if (k != null) {
            k.a(new b.InterfaceC0302b() { // from class: com.kwad.components.ad.interstitial.c.d.3
                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0302b
                public final void G(int i) {
                    if (i == com.kwad.components.ad.f.kwai.kwai.b.nP) {
                        d.this.jt.b(d.this.getContext(), d.this.mAdTemplate);
                        d.this.jt.a(true, -1, d.this.jt.eN);
                    }
                    d.this.dx();
                }
            });
        }
        return this.km;
    }

    /* renamed from: do  reason: not valid java name */
    private com.kwad.components.ad.f.kwai.kwai.a m4613do() {
        final com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.jt.jE.add(new c.InterfaceC0314c() { // from class: com.kwad.components.ad.interstitial.c.d.4
            @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0314c
            public final void dg() {
                aVar.fb();
            }
        });
        return aVar;
    }

    private com.kwad.components.core.webview.a.kwai.u dp() {
        com.kwad.components.core.webview.a.kwai.u uVar = new com.kwad.components.core.webview.a.kwai.u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.interstitial.c.d.5
            @Override // com.kwad.components.core.webview.a.kwai.u.a
            public final void a(m mVar) {
                d.this.eN.setVideoSoundEnable(!mVar.Vf);
            }
        });
        return uVar;
    }

    private o dq() {
        return new o() { // from class: com.kwad.components.ad.interstitial.c.d.6
            @Override // com.kwad.components.core.webview.a.kwai.o, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                m mVar = new m();
                mVar.Vf = !d.this.dZ.isVideoSoundEnable();
                cVar.a(mVar);
            }
        };
    }

    private ab dr() {
        return new ab(this.cV, new ab.b() { // from class: com.kwad.components.ad.interstitial.c.d.7
            @Override // com.kwad.components.core.webview.jshandler.ab.b
            public final void a(ab.a aVar) {
            }
        });
    }

    private a.c ds() {
        final z zVar = new z();
        a.c cVar = new a.c() { // from class: com.kwad.components.ad.interstitial.c.d.8
            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                zVar.Vq = false;
                zVar.Vm = true;
                zVar.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.cV.getAdTemplate()));
                d.this.kk.a(zVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                zVar.Vq = false;
                zVar.Vm = false;
                zVar.nZ = (int) Math.ceil(((float) j) / 1000.0f);
                d.this.kk.a(zVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                zVar.Vq = false;
                zVar.Vm = false;
                zVar.nZ = 0;
                d.this.kk.a(zVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (d.this.eM.getVisibility() == 0) {
                    d.this.eM.setVisibility(8);
                }
                zVar.Vq = false;
                zVar.Vm = false;
                zVar.nZ = (int) Math.ceil(((float) d.this.eN.getCurrentPosition()) / 1000.0f);
                d.this.kk.a(zVar);
            }
        };
        this.kj = cVar;
        return cVar;
    }

    private WebCardVideoPositionHandler dt() {
        return new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.interstitial.c.d.9
            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + d.this.kn);
                if (d.this.kn || d.this.mAdInfo == null || !com.kwad.sdk.core.response.a.a.aU(d.this.mAdInfo)) {
                    return;
                }
                c unused = d.this.jt;
                boolean a2 = c.a(d.this.mContext, d.this.mAdInfo);
                d dVar = d.this;
                dVar.a(dVar.mAdInfo, videoPosition, d.this.kf, a2);
                d.this.kf.setVisibility(0);
                d.this.kh.setVisibility(0);
            }
        });
    }

    private aw du() {
        aw awVar = new aw(getContext(), this.mAdTemplate);
        awVar.a(new aw.a() { // from class: com.kwad.components.ad.interstitial.c.d.10
            @Override // com.kwad.components.core.webview.jshandler.aw.a
            public final boolean dC() {
                if (d.this.kk != null) {
                    d.this.kk.aP(false);
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.10.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.dx();
                    }
                });
                boolean z = !d.this.jt.jG;
                if (z) {
                    d.this.jt.a(true, -1, d.this.jt.eN);
                }
                return z;
            }
        });
        return awVar;
    }

    private aa dv() {
        return new aa(new aa.b() { // from class: com.kwad.components.ad.interstitial.c.d.13
            @Override // com.kwad.components.core.webview.jshandler.aa.b
            public final void a(final aa.a aVar) {
                if (d.this.kg != null) {
                    d.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.13.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            boolean z = true;
                            if (!d.this.jt.jy && aVar.type == 0 && !d.this.jt.jw && !d.this.jt.jx && com.kwad.components.ad.interstitial.d.a.c(d.this.jt)) {
                                d.this.jt.jx = true;
                                com.kwad.components.ad.interstitial.a.b.K(d.this.mContext);
                                return;
                            }
                            c cVar = d.this.jt;
                            if (aVar.type != 3) {
                                z = false;
                            }
                            cVar.a(z, -1, d.this.eN);
                            d.this.dx();
                        }
                    });
                }
            }
        });
    }

    private p dw() {
        p pVar = new p() { // from class: com.kwad.components.ad.interstitial.c.d.14
            @Override // com.kwad.components.core.webview.a.kwai.p, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                if (d.this.eN.isIdle()) {
                    z zVar = new z();
                    zVar.Vq = false;
                    zVar.Vm = false;
                    zVar.nZ = 0;
                    cVar.a(zVar);
                }
                if (d.this.eN.isCompleted()) {
                    z zVar2 = new z();
                    zVar2.Vq = false;
                    zVar2.Vm = true;
                    zVar2.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.cV.getAdTemplate()));
                    cVar.a(zVar2);
                }
            }
        };
        this.kk = pVar;
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        Activity ownerActivity;
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Dialog dialog = this.kg;
        if (dialog == null || (ownerActivity = dialog.getOwnerActivity()) == null || ownerActivity.isFinishing()) {
            return;
        }
        this.kg.dismiss();
        if (!this.jt.jy && (adInteractionListener = this.jt.hN) != null) {
            adInteractionListener.onAdClosed();
        }
        if (this.jt.eN != null) {
            this.jt.eN.release();
        }
    }

    private com.kwad.components.core.webview.jshandler.p dy() {
        return new com.kwad.components.core.webview.jshandler.p(this.cV, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.d.15
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.jt.jy && d.this.jt.hN != null) {
                        d.this.jt.hN.onAdClicked();
                    }
                    d.this.jt.jw = true;
                    if (!d.this.jt.jy) {
                        d.this.jt.cr();
                    }
                    if (d.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    d.this.jt.a(false, -1, d.this.jt.eN);
                    d.this.jt.hU.dismiss();
                }
            }
        });
    }

    private s dz() {
        return new s(this.cV, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.d.16
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.jt.jy && d.this.jt.hN != null) {
                        d.this.jt.hN.onAdClicked();
                    }
                    d.this.jt.jw = true;
                    if (!d.this.jt.jy) {
                        d.this.jt.cr();
                    }
                    if (d.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    d.this.jt.a(false, -1, d.this.jt.eN);
                    d.this.jt.hU.dismiss();
                }
            }
        });
    }

    private ag.a getOpenNewPageListener() {
        return new ag.a() { // from class: com.kwad.components.ad.interstitial.c.d.11
            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(d.this.mContext, new AdWebViewActivityProxy.a.C0359a().au(bVar.title).av(bVar.url).aA(true).L(d.this.mAdTemplate).oc());
            }
        };
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.interstitial.c.d.22
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                d.this.w("1");
            }
        };
    }

    private void v(String str) {
        aI();
        c.a b = this.kh.getClientConfig().ct(this.mAdTemplate).b(getWebListener());
        this.kl = b;
        this.kh.setClientConfig(b);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.kh);
        this.cU = aVar;
        a(aVar, str);
        this.kh.addJavascriptInterface(this.cU, "KwaiAd");
        this.kh.setBackgroundColor(0);
        this.kh.setVisibility(4);
        this.kh.loadUrl(str);
        bi.a(this.kp, null, com.anythink.expressad.video.module.a.a.m.ag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str) {
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "handleWebViewError " + str);
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fG) {
            return;
        }
        this.fG = true;
        com.kwad.components.core.m.a pb = com.kwad.components.core.m.a.pb();
        AdTemplate adTemplate = this.mAdTemplate;
        pb.b(adTemplate, com.kwad.sdk.core.response.a.b.bw(adTemplate), str);
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.23
            @Override // java.lang.Runnable
            public final void run() {
                d.this.di();
                d.this.jt.cV();
            }
        });
        c.a aVar = this.kl;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        c cVar = (c) Bh();
        this.jt = cVar;
        this.kn = false;
        this.kg = cVar.hU;
        this.dZ = this.jt.dZ;
        this.mApkDownloadHelper = this.jt.mApkDownloadHelper;
        AdTemplate adTemplate = this.jt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.eN = this.jt.eN;
        this.mViewVisibleHelper.rD();
        this.mViewVisibleHelper.a(this.dk);
        this.jt.a(this.ko);
        if (com.kwad.sdk.core.response.a.b.bu(this.mAdTemplate)) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.21
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.di();
                    d.this.jt.cV();
                }
            });
            return;
        }
        aF();
        aG();
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cT() {
        super.cT();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.km;
        if (bVar != null) {
            bVar.fe();
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cU() {
        super.cU();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.km;
        if (bVar != null) {
            bVar.fd();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kh = (KsAdWebView) getRootView().findViewById(R.id.ksad_web_card_webView);
        this.mViewVisibleHelper = new com.kwad.components.core.widget.kwai.b(getRootView(), 100);
        this.ke = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kf = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.ki = (ImageView) getRootView().findViewById(R.id.ksad_interstitial_video_blur);
        Context context = getContext();
        this.mContext = context;
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mViewVisibleHelper.b(this.dk);
        this.mViewVisibleHelper.rE();
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        c.a aVar = this.kl;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
        this.jt.b(this.ko);
    }
}
