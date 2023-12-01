package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.g;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATSplashAdapter.class */
public class AdxATSplashAdapter extends CustomSplashAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f8845a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Object> f8846c;

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        int parseInt = (!map.containsKey("orientation") || (obj2 = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj2.toString());
        int parseInt2 = (!map.containsKey("countdown") || (obj = map.get("countdown")) == null) ? 5 : Integer.parseInt(obj.toString()) * 1000;
        int i = 1;
        if (map.containsKey("allows_skip")) {
            Object obj3 = map.get("allows_skip");
            i = 1;
            if (obj3 != null) {
                i = Integer.parseInt(obj3.toString());
                if (i == 0) {
                    i = 1;
                } else if (i == 1) {
                    i = 0;
                }
            }
        }
        this.b = (j) map.get(g.k.f6515a);
        com.anythink.basead.d.g gVar = new com.anythink.basead.d.g(context, b.a.ADX_OFFER_REQUEST_TYPE, this.b);
        this.f8845a = gVar;
        gVar.a(new c.a().d(parseInt).e(parseInt2).f(i).a());
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        com.anythink.basead.d.g gVar = this.f8845a;
        if (gVar != null) {
            gVar.b();
            this.f8845a = null;
        }
        this.b = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get(g.k.f6515a);
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillSplashData();
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f8846c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        j jVar = this.b;
        return jVar != null ? jVar.b : "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        com.anythink.basead.d.g gVar = this.f8845a;
        boolean z = gVar != null && gVar.c();
        if (z && this.f8846c == null) {
            this.f8846c = com.anythink.basead.b.a(this.f8845a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        com.anythink.basead.d.g gVar = this.f8845a;
        return gVar != null && gVar.e();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        int parseInt = (!map.containsKey("orientation") || (obj2 = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj2.toString());
        int parseInt2 = (!map.containsKey("countdown") || (obj = map.get("countdown")) == null) ? 5 : Integer.parseInt(obj.toString()) * 1000;
        int i = 1;
        if (map.containsKey("allows_skip")) {
            Object obj3 = map.get("allows_skip");
            i = 1;
            if (obj3 != null) {
                i = Integer.parseInt(obj3.toString());
                if (i == 0) {
                    i = 1;
                } else if (i == 1) {
                    i = 0;
                }
            }
        }
        this.b = (j) map.get(g.k.f6515a);
        com.anythink.basead.d.g gVar = new com.anythink.basead.d.g(context, b.a.ADX_OFFER_REQUEST_TYPE, this.b);
        this.f8845a = gVar;
        gVar.a(new c.a().d(parseInt).e(parseInt2).f(i).a());
        this.f8845a.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.adx.AdxATSplashAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                AdxATSplashAdapter adxATSplashAdapter = AdxATSplashAdapter.this;
                adxATSplashAdapter.f8846c = com.anythink.basead.b.a(adxATSplashAdapter.f8845a);
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        com.anythink.basead.d.g gVar = this.f8845a;
        if (gVar != null) {
            gVar.a(new com.anythink.basead.e.e(gVar.d()) { // from class: com.anythink.network.adx.AdxATSplashAdapter.2
                @Override // com.anythink.basead.e.a
                public final void onAdClick(int i) {
                    com.anythink.core.common.e.e trackingInfo = AdxATSplashAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i);
                    }
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdClosed() {
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }
                }

                @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
                public final void onAdShow() {
                    super.onAdShow();
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdShow();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onDeeplinkCallback(boolean z) {
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onShowFailed(e eVar) {
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, eVar.a(), eVar.b()));
                    }
                }
            });
            if (isCustomSkipView()) {
                this.f8845a.a();
            }
            this.f8845a.a(viewGroup);
        }
    }
}
