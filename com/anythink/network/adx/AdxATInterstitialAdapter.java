package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.d;
import com.anythink.basead.e.f;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.j;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATInterstitialAdapter.class */
public class AdxATInterstitialAdapter extends CustomInterstitialAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected j f5995a;
    protected d b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Object> f5996c;

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        Object obj3;
        int parseInt = (!map.containsKey("v_m") || (obj3 = map.get("v_m")) == null) ? 0 : Integer.parseInt(obj3.toString());
        int parseInt2 = (!map.containsKey("s_c_t") || (obj2 = map.get("s_c_t")) == null) ? -1 : Integer.parseInt(obj2.toString());
        this.f5995a = (j) map.get("basead_params");
        this.b = new d(context, b.a.a, this.f5995a);
        this.b.a(new c.a().a((!map.containsKey("inter_type") || (obj = map.get("inter_type")) == null) ? "1" : obj.toString()).a(parseInt).b(parseInt2).a());
    }

    public void destory() {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            this.b = null;
        }
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get("basead_params");
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillInterstitial(map);
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.f5996c;
    }

    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        j jVar = this.f5995a;
        return jVar != null ? jVar.b : "";
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        return true;
    }

    public boolean isAdReady() {
        d dVar = this.b;
        boolean z = dVar != null && dVar.c();
        if (z && this.f5996c == null) {
            this.f5996c = com.anythink.basead.b.a(this.b);
        }
        return z;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.adx.AdxATInterstitialAdapter.2
            public final void onAdCacheLoaded() {
                AdxATInterstitialAdapter adxATInterstitialAdapter = AdxATInterstitialAdapter.this;
                adxATInterstitialAdapter.f5996c = com.anythink.basead.b.a(adxATInterstitialAdapter.b);
                if (AdxATInterstitialAdapter.this.mLoadListener != null) {
                    AdxATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            public final void onAdDataLoaded() {
                if (AdxATInterstitialAdapter.this.mLoadListener != null) {
                    AdxATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            public final void onAdLoadFailed(e eVar) {
                if (AdxATInterstitialAdapter.this.mLoadListener != null) {
                    AdxATInterstitialAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        int g = com.anythink.core.common.k.d.g(activity);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extra_scenario", this.mScenario);
        hashMap.put("extra_orientation", Integer.valueOf(g));
        d dVar = this.b;
        dVar.a(new f(dVar.d()) { // from class: com.anythink.network.adx.AdxATInterstitialAdapter.1
            public final void onAdClick(int i) {
                com.anythink.core.common.e.e trackingInfo = AdxATInterstitialAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i);
                }
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            public final void onAdClosed() {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                }
            }

            public final void onAdShow() {
                super.onAdShow();
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                }
            }

            public final void onDeeplinkCallback(boolean z) {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onDeeplinkCallback(z);
                }
            }

            public final void onRewarded() {
            }

            public final void onShowFailed(e eVar) {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
                }
            }

            public final void onVideoAdPlayEnd() {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            public final void onVideoAdPlayStart() {
                if (AdxATInterstitialAdapter.this.mImpressListener != null) {
                    AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                }
            }
        });
        d dVar2 = this.b;
        if (dVar2 != null) {
            dVar2.a(activity, hashMap);
        }
    }
}
