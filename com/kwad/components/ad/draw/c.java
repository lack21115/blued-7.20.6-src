package com.kwad.components.ad.draw;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/c.class */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {
    private KsDrawAd.AdInteractionListener bV;
    private b cf;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.internal.api.c cg = new com.kwad.components.core.internal.api.c();
    private final com.kwad.sdk.core.g.b ca = new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.draw.c.1
        @Override // com.kwad.sdk.core.g.b
        public final void ap() {
            c.this.cg.a(c.this);
        }

        @Override // com.kwad.sdk.core.g.b
        public final void aq() {
            c.this.cg.b(c.this);
        }
    };
    private final KsDrawAd.AdInteractionListener ch = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.2
        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.bV != null) {
                c.this.bV.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.bV != null) {
                c.this.bV.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.bV != null) {
                try {
                    c.this.bV.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }
    };

    public c(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.bi(com.kwad.sdk.core.response.a.d.cb(adTemplate)).getUrl(), this.mAdTemplate);
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.cg.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.cg.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    public final View getDrawView2(Context context) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        Context context2 = context;
        try {
            Context wrapContextIfNeed = k.wrapContextIfNeed(context);
            com.kwad.sdk.g.a.U("draw", "show");
            if (this.cf == null) {
                b bVar = new b(wrapContextIfNeed);
                this.cf = bVar;
                bVar.setPageExitListener(this.ca);
                this.cf.setAdInteractionListener(this.bV);
                this.cf.a(this.mAdTemplate);
            } else {
                com.kwad.sdk.core.d.b.i("KSDrawAdControl", "mDrawVideoView is not null");
            }
            context2 = wrapContextIfNeed;
            com.kwad.sdk.g.a.V("draw", "show");
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            RuntimeException runtimeException = new RuntimeException("context:" + context2.getClass().getName() + "--classloader:" + context2.getClass().getClassLoader());
            if (Build.VERSION.SDK_INT >= 19) {
                runtimeException.addSuppressed(th);
            }
            com.kwad.components.core.c.a.b(runtimeException);
        }
        return this.cf;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aI(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aW(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.ur()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.i(this.mAdTemplate, j2);
    }
}
