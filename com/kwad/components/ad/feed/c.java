package com.kwad.components.ad.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.components.ad.feed.a.m;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/c.class */
public final class c extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    private KsFeedAd.AdInteractionListener dV;
    private com.kwad.components.core.widget.b dW;
    private com.kwad.components.core.widget.b dX;
    private boolean dY;
    private final KsAdVideoPlayConfig dZ;
    private final AdInfo mAdInfo;
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.internal.api.c cg = new com.kwad.components.core.internal.api.c();
    private com.kwad.sdk.core.g.b ca = new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.c.1
        @Override // com.kwad.sdk.core.g.b
        public final void ap() {
            c.this.cg.a(c.this);
        }

        @Override // com.kwad.sdk.core.g.b
        public final void aq() {
            c.this.cg.b(c.this);
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/c$a.class */
    public static final class a {
        int ee;
        int size;

        public a(int i) {
            this.size = i;
        }

        public final int aZ() {
            return this.ee;
        }

        public final boolean ba() {
            int i = this.ee + 1;
            this.ee = i;
            return i == this.size;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/c$b.class */
    public interface b {
        void c(int i, String str);
    }

    public c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.dY = z;
        this.dZ = new KSAdVideoPlayConfigImpl();
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    private com.kwad.components.core.widget.b<?> E(Context context) {
        m a2;
        if (this.dY && com.kwad.sdk.core.response.a.b.bq(this.mAdTemplate)) {
            try {
                m mVar = new m(k.wrapContextIfNeed(context));
                mVar.setWidth(this.mAdTemplate.mAdScene.getWidth());
                mVar.setVideoPlayConfig(this.dZ);
                a2 = mVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                a2 = null;
            }
        } else {
            a2 = com.kwad.components.ad.feed.b.a(context, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.a.a.aW(this.mAdInfo));
        }
        if (a2 != null) {
            a2.setPageExitListener(this.ca);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.widget.b bVar, final boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.a() { // from class: com.kwad.components.ad.feed.c.3
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (c.this.dV != null) {
                    c.this.dV.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                com.kwad.components.ad.feed.monitor.a.bg();
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "adShowSuccess").report();
                if (c.this.dV != null) {
                    c.this.dV.onAdShow();
                }
                if (z) {
                    i iVar = new i();
                    y.a aVar = new y.a();
                    FeedType fromInt = FeedType.fromInt(c.this.mAdTemplate.type);
                    FeedType feedType = fromInt;
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedType = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(feedType.getType());
                    iVar.a(aVar);
                    iVar.q(c.this.dW.getHeight(), c.this.dW.getWidth());
                    com.kwad.components.core.r.b.pK().a(c.this.mAdTemplate, null, iVar);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (c.this.dV != null) {
                    c.this.dV.onDislikeClicked();
                    try {
                        if (bVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) bVar.getParent()).removeView(bVar);
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (c.this.dV != null) {
                    try {
                        c.this.dV.onDownloadTipsDialogDismiss();
                    } catch (Throwable th) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (c.this.dV != null) {
                    try {
                        c.this.dV.onDownloadTipsDialogShow();
                    } catch (Throwable th) {
                    }
                }
            }
        });
    }

    private void aY() {
        if (this.mAdTemplate != null) {
            com.kwad.sdk.core.diskcache.a.a vs = com.kwad.sdk.core.diskcache.a.a.vs();
            vs.remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dZ;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return com.kwad.sdk.core.response.a.a.bG(this.mAdInfo);
    }

    public final void a(final b bVar) {
        com.kwad.sdk.g.a.e(IAdInterListener.AdProdType.PRODUCT_FEEDS, "show", "feed_preload_view");
        Context context = ServiceProvider.getContext();
        com.kwad.components.core.widget.b<?> E = E(context);
        this.dX = E;
        if (E != null) {
            this.dX.setMargin(com.kwad.sdk.c.kwai.a.a(context, 16.0f));
            com.kwad.components.core.widget.b bVar2 = this.dX;
            if (bVar2 instanceof m) {
                m mVar = (m) bVar2;
                mVar.setPreloadListener(new m.a() { // from class: com.kwad.components.ad.feed.c.2
                    @Override // com.kwad.components.ad.feed.a.m.a
                    public final void c(int i, String str) {
                        c cVar = c.this;
                        cVar.a(cVar.dX, false);
                        bVar.c(i, str);
                    }
                });
                mVar.bindView(this.mAdTemplate);
                com.kwad.sdk.g.a.f(IAdInterListener.AdProdType.PRODUCT_FEEDS, "show", "feed_preload_view");
            }
            bVar2.bindView(this.mAdTemplate);
            com.kwad.components.core.widget.b bVar3 = this.dX;
            if (bVar3 instanceof com.kwad.components.ad.feed.a.c) {
                ((com.kwad.components.ad.feed.a.c) bVar3).a(this.dZ);
            }
            a(this.dX, true);
        }
        bVar.c(1, "");
        com.kwad.sdk.g.a.f(IAdInterListener.AdProdType.PRODUCT_FEEDS, "show", "feed_preload_view");
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

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        try {
            Context wrapContextIfNeed = k.wrapContextIfNeed(context);
            com.kwad.sdk.g.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, "show");
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "callShow").report();
            if (this.dW == null) {
                aY();
                if (this.dX != null) {
                    this.dW = this.dX;
                    com.kwad.sdk.g.a.V(IAdInterListener.AdProdType.PRODUCT_FEEDS, "show");
                    return this.dW;
                }
                this.dW = E(wrapContextIfNeed);
            } else if (this.dW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dW.getParent()).removeView(this.dW);
            }
            if (this.dW != null) {
                this.dW.bindView(this.mAdTemplate);
                if (this.dW instanceof com.kwad.components.ad.feed.a.c) {
                    ((com.kwad.components.ad.feed.a.c) this.dW).a(this.dZ);
                }
                if (this.dW instanceof m) {
                    a(this.dW, false);
                } else {
                    a(this.dW, true);
                }
            }
            com.kwad.sdk.g.a.V(IAdInterListener.AdProdType.PRODUCT_FEEDS, "show");
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            com.kwad.components.core.c.a.b(th);
        }
        return this.dW;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aI(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aW(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.ur()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.dV = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.i(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.dZ.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.dZ.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.dZ.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            } else {
                this.dZ.setDataFlowAutoStart(com.kwad.sdk.core.config.d.uy());
            }
            com.kwad.components.core.widget.b bVar = this.dX;
            if (bVar instanceof m) {
                ((m) bVar).setVideoPlayConfig(this.dZ);
            }
            com.kwad.components.core.widget.b bVar2 = this.dX;
            if (bVar2 instanceof com.kwad.components.ad.feed.a.c) {
                ((com.kwad.components.ad.feed.a.c) bVar2).setVideoPlayConfig(this.dZ);
            }
        }
        if (isVideoSoundEnable()) {
            adTemplate = this.mAdTemplate;
            i = 2;
        } else {
            adTemplate = this.mAdTemplate;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        this.dZ.setVideoSoundEnable(z);
        if (this.dZ.isVideoSoundEnable()) {
            adTemplate = this.mAdTemplate;
            i = 2;
        } else {
            adTemplate = this.mAdTemplate;
            i = 1;
        }
        adTemplate.mInitVoiceStatus = i;
    }
}
