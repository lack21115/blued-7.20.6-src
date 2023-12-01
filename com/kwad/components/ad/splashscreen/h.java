package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/h.class */
public final class h extends com.kwad.sdk.mvp.a {
    public com.kwad.components.ad.splashscreen.d.a BG;
    public com.kwad.sdk.core.g.a BH;
    private List<g> BI = new CopyOnWriteArrayList();
    private List<f> BJ = new CopyOnWriteArrayList();
    private boolean BK = false;
    public boolean BL = false;
    public boolean BM = false;
    private KsSplashScreenAd.SplashScreenAdInteractionListener Bx;
    public int Bz;
    public SceneImpl mAdScene;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;
    public bh mTimerHelper;
    public KsVideoPlayConfig mVideoPlayConfig;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/h$a.class */
    public interface a {
        void b(i iVar);
    }

    public static boolean a(Context context, long j, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.b.cF(adInfo) && com.kwad.sdk.core.response.a.a.aV(adInfo) && !com.kwad.components.ad.splashscreen.local.b.b(context, j, adInfo);
    }

    private void kA() {
        for (f fVar : this.BJ) {
            fVar.ks();
        }
    }

    private void kz() {
        for (g gVar : this.BI) {
            gVar.kt();
        }
    }

    public final void a(int i, Context context, final int i2, int i3, final a aVar) {
        com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        com.kwad.components.core.d.b.a.a(new a.C0519a(context).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(i3).ao(false).ao(i2).an(i).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (h.this.Bx != null) {
                    h.this.Bx.onAdClicked();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (h.this.BG != null) {
                        jSONObject.put("duration", h.this.BG.getCurrentPosition());
                    }
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.b.printStackTrace(e);
                }
                i c2 = new i().bj(i2).c(h.this.mRootContainer.getTouchCoords());
                com.kwad.sdk.core.report.a.a(h.this.mAdTemplate, c2, jSONObject);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(c2);
                }
            }
        }));
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.BJ.add(fVar);
    }

    public final void a(g gVar) {
        this.BI.add(gVar);
    }

    public final void ab(int i) {
        for (g gVar : this.BI) {
            gVar.aa(i);
        }
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.BJ.remove(fVar);
    }

    public final void b(g gVar) {
        this.BI.remove(gVar);
    }

    public final void c(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, null);
    }

    public final void f(int i, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, str);
        }
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.d(this.mAdTemplate, 0, String.valueOf(str));
        kz();
    }

    public final void kB() {
        this.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.d.a.b.mF()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.kx();
                }
            }
        });
    }

    public final void ku() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    public final void kv() {
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.g(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.a.kC();
        com.kwad.sdk.kwai.kwai.c.sZ().aU(true);
        bh bhVar = this.mTimerHelper;
        if (bhVar != null) {
            bhVar.startTiming();
        }
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    public final void kw() {
        if (this.BK) {
            return;
        }
        this.BK = true;
        if (!a(this.mRootContainer.getContext(), com.kwad.sdk.core.response.a.d.bU(this.mAdTemplate), com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) || this.mAdTemplate.converted) {
            y.a aVar = new y.a();
            bh bhVar = this.mTimerHelper;
            if (bhVar != null) {
                aVar.duration = bhVar.getTime();
            }
            com.kwad.sdk.core.report.a.b(this.mAdTemplate, new i().bk(14).bp(22).a(aVar), (JSONObject) null);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
        } else {
            kA();
        }
        kz();
    }

    public final void kx() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    public final void ky() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Bx;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        kz();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.BG;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.g.a aVar2 = this.BH;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Bx = splashScreenAdInteractionListener;
    }
}
