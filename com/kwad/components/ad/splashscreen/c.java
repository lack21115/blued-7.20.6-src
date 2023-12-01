package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.splashscreen.b.j;
import com.kwad.components.ad.splashscreen.b.l;
import com.kwad.components.ad.splashscreen.b.m;
import com.kwad.components.ad.splashscreen.b.n;
import com.kwad.components.ad.splashscreen.b.o;
import com.kwad.components.ad.splashscreen.b.p;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.j.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/c.class */
public final class c extends com.kwad.components.core.j.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener Bx;
    private com.kwad.components.ad.splashscreen.e.d By;
    private int Bz;
    private com.kwad.sdk.core.g.b ca;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    private c(Context context, AdTemplate adTemplate) {
        super(context);
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        nF();
    }

    public static c a(Context context, AdResultData adResultData, com.kwad.sdk.core.g.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        c cVar;
        try {
            com.kwad.sdk.g.a.U(com.anythink.expressad.foundation.g.a.f.f, "show");
            Context wrapContextIfNeed = k.wrapContextIfNeed(context);
            AdTemplate adTemplate = new AdTemplate();
            if (!adResultData.getAdTemplateList().isEmpty()) {
                adTemplate = adResultData.getAdTemplateList().get(0);
            }
            adTemplate.showStartTime = SystemClock.elapsedRealtime();
            c cVar2 = new c(wrapContextIfNeed, adTemplate);
            try {
                cVar2.setPageExitListener(bVar);
                cVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.V(adTemplate);
                com.kwad.components.splash.monitor.a.rY();
                com.kwad.components.splash.monitor.a.h(adTemplate, KsAdSDKImpl.get().getSDKInitTime());
                com.kwad.sdk.g.a.V(com.anythink.expressad.foundation.g.a.f.f, "show");
                return cVar2;
            } catch (Throwable th) {
                cVar = cVar2;
                th = th;
                if (KsAdSDKImpl.get().getIsExternal()) {
                    com.kwad.components.core.c.a.b(th);
                    return cVar;
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = null;
        }
    }

    private com.kwad.sdk.core.g.c a(final h hVar) {
        return new com.kwad.sdk.core.g.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.g.c
            public final void onPageInvisible() {
                if (hVar.mTimerHelper != null) {
                    hVar.mTimerHelper.EY();
                }
            }

            @Override // com.kwad.sdk.core.g.c
            public final void onPageVisible() {
                if (hVar.mTimerHelper != null) {
                    hVar.mTimerHelper.EX();
                }
            }
        };
    }

    private static Presenter c(Context context, AdTemplate adTemplate) {
        p hVar;
        m oVar;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.splashscreen.b.b());
        presenter.a(new com.kwad.components.ad.splashscreen.b.c());
        presenter.a(new n());
        if (com.kwad.sdk.core.response.a.a.aU(cb)) {
            presenter.a(new com.kwad.components.ad.splashscreen.b.d());
            hVar = new p();
        } else {
            hVar = new com.kwad.components.ad.splashscreen.b.h();
        }
        presenter.a(hVar);
        boolean dg = com.kwad.sdk.core.response.a.b.dg(cb);
        boolean cY = com.kwad.sdk.core.response.a.b.cY(cb);
        boolean da = com.kwad.sdk.core.response.a.b.da(cb);
        boolean df = com.kwad.sdk.core.response.a.b.df(cb);
        boolean dc = com.kwad.sdk.core.response.a.b.dc(cb);
        if (!dg) {
            if (dc) {
                oVar = new m();
            } else if (cY) {
                oVar = new l();
            } else if (da) {
                oVar = new com.kwad.components.ad.splashscreen.b.k();
            } else if (df) {
                oVar = new o();
            }
            presenter.a(oVar);
        }
        if (com.kwad.sdk.core.response.a.a.aH(cb)) {
            presenter.a(new com.kwad.components.ad.splashscreen.b.f());
        }
        if (h.a(context, com.kwad.sdk.core.response.a.d.bU(adTemplate), cb)) {
            presenter.a(new com.kwad.components.ad.splashscreen.b.kwai.f());
        }
        presenter.a(new j());
        presenter.a(new com.kwad.components.ad.splashscreen.b.a());
        presenter.a(new com.kwad.components.ad.splashscreen.b.g());
        return presenter;
    }

    private int getSplashLayoutId() {
        int i = this.Bz;
        return i == 1 ? R.layout.ksad_splash_screen_skip_button_top_left : i == 0 ? R.layout.ksad_splash_screen_skip_button_top_right : i == 2 ? R.layout.ksad_splash_screen_skip_button_bottom_left : i == 3 ? R.layout.ksad_splash_screen_skip_button_bottom_right : R.layout.ksad_splash_screen_skip_button_top_right;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.j.c
    /* renamed from: km */
    public h kp() {
        com.kwad.components.ad.splashscreen.e.d dVar = new com.kwad.components.ad.splashscreen.e.d(this.lW, 70);
        this.By = dVar;
        dVar.a(this.ca);
        this.By.rD();
        if (this.mVideoPlayConfig == null) {
            KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
            boolean z = true;
            if (this.mAdInfo.adSplashInfo.mute == 1) {
                z = false;
            }
            this.mVideoPlayConfig = builder.videoSoundEnable(z).build();
        }
        h hVar = new h();
        hVar.setSplashScreenAdListener(this.Bx);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdTemplate = this.mAdTemplate;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.BH = this.By;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.Bz = this.Bz;
        hVar.mTimerHelper = new bh();
        if (com.kwad.sdk.core.response.a.a.aU(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.d.a aVar = new com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.BG = aVar;
            hVar.BH.a(aVar);
        }
        hVar.BH.a(a(hVar));
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko() {
        if (com.kwad.components.ad.splashscreen.e.c.a(getContext(), getWidth(), getHeight()) && this.Bz != 0) {
            if (com.kwad.components.ad.splashscreen.e.c.d((h) this.JV) == 2) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 16, 16, -1);
            } else if (com.kwad.components.ad.splashscreen.e.c.d((h) this.JV) == 3) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 16, -1, 16);
            }
        }
    }

    private void notifyPageDismiss() {
        com.kwad.sdk.kwai.kwai.c.sZ().tc();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    public static boolean o(AdInfo adInfo) {
        return adInfo.adSplashInfo != null && adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.core.j.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.j.c
    public final void initData() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.mAdInfo = cb;
        this.Bz = cb.adSplashInfo.skipButtonPosition;
        int i = 1;
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = build;
        AdTemplate adTemplate = this.mAdTemplate;
        if (build.isVideoSoundEnable()) {
            i = 2;
        }
        adTemplate.mInitVoiceStatus = i;
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.j.c
    public final boolean kl() {
        return true;
    }

    @Override // com.kwad.components.core.j.c
    public final void kn() {
        this.mRootContainer = (AdBaseFrameLayout) this.lW.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.lW.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (com.kwad.sdk.c.kwai.a.tC() || !c.o(c.this.mAdInfo) || c.this.JV == null) {
                    return;
                }
                ((h) c.this.JV).c(1, view.getContext(), 53, 2);
            }
        });
    }

    @Override // com.kwad.components.core.j.c
    public final Presenter onCreatePresenter() {
        return c(getContext(), this.mAdTemplate);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean mH = dialogInterface instanceof com.kwad.components.core.d.a.b ? ((com.kwad.components.core.d.a.b) dialogInterface).mH() : false;
        try {
            if (this.Bx != null) {
                if (mH) {
                    this.Bx.onDownloadTipsDialogDismiss();
                } else {
                    this.Bx.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            if (this.Bx != null) {
                this.Bx.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.components.core.j.c, com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.U(this.mAdTemplate);
        post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // java.lang.Runnable
            public final void run() {
                c.this.ko();
            }
        });
        if (((h) this.JV).BG != null) {
            ((h) this.JV).BG.lq();
        }
    }

    @Override // com.kwad.components.core.j.c, com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.By.rE();
        notifyPageDismiss();
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public final void setPageExitListener(com.kwad.sdk.core.g.b bVar) {
        this.ca = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Bx = splashScreenAdInteractionListener;
        if (this.JV != 0) {
            ((h) this.JV).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }
}
