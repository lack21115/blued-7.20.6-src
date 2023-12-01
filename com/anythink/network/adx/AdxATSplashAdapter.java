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
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATSplashAdapter.class */
public class AdxATSplashAdapter extends CustomSplashAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f6005a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Object> f6006c;

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
        this.b = (j) map.get("basead_params");
        g gVar = new g(context, b.a.a, this.b);
        this.f6005a = gVar;
        gVar.a(new c.a().d(parseInt).e(parseInt2).f(i).a());
    }

    public void destory() {
        g gVar = this.f6005a;
        if (gVar != null) {
            gVar.b();
            this.f6005a = null;
        }
        this.b = null;
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get("basead_params");
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillSplashData();
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.f6006c;
    }

    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        j jVar = this.b;
        return jVar != null ? jVar.b : "";
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    public boolean isAdReady() {
        g gVar = this.f6005a;
        boolean z = gVar != null && gVar.c();
        if (z && this.f6006c == null) {
            this.f6006c = com.anythink.basead.b.a(this.f6005a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        g gVar = this.f6005a;
        return gVar != null && gVar.e();
    }

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
        this.b = (j) map.get("basead_params");
        g gVar = new g(context, b.a.a, this.b);
        this.f6005a = gVar;
        gVar.a(new c.a().d(parseInt).e(parseInt2).f(i).a());
        this.f6005a.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.adx.AdxATSplashAdapter.1
            public final void onAdCacheLoaded() {
                AdxATSplashAdapter adxATSplashAdapter = AdxATSplashAdapter.this;
                adxATSplashAdapter.f6006c = com.anythink.basead.b.a(adxATSplashAdapter.f6005a);
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            public final void onAdDataLoaded() {
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            public final void onAdLoadFailed(e eVar) {
                if (AdxATSplashAdapter.this.mLoadListener != null) {
                    AdxATSplashAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        g gVar = this.f6005a;
        if (gVar != null) {
            gVar.a(new com.anythink.basead.e.e(gVar.d()) { // from class: com.anythink.network.adx.AdxATSplashAdapter.2
                public final void onAdClick(int i) {
                    com.anythink.core.common.e.e trackingInfo = AdxATSplashAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i);
                    }
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
                    }
                }

                public final void onAdClosed() {
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                    }
                }

                public final void onAdShow() {
                    super.onAdShow();
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdShow();
                    }
                }

                public final void onDeeplinkCallback(boolean z) {
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onDeeplinkCallback(z);
                    }
                }

                public final void onShowFailed(e eVar) {
                    if (AdxATSplashAdapter.this.mImpressionListener != null) {
                        AdxATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode("4006", eVar.a(), eVar.b()));
                    }
                }
            });
            if (isCustomSkipView()) {
                this.f6005a.a();
            }
            this.f6005a.a(viewGroup);
        }
    }
}
