package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.e.c;
import com.anythink.basead.e.g;
import com.anythink.basead.f.d;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.s;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATInterstitialAdapter.class */
public class MyOfferATInterstitialAdapter extends CustomInterstitialAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f9028a;
    Map<String, Object> b;
    private d d;

    /* renamed from: c  reason: collision with root package name */
    private String f9029c = "";
    private boolean e = false;

    private void a(Context context) {
        this.d = new d(context, this.f9028a, this.f9029c, this.e);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a((g) null);
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f9029c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return com.anythink.core.common.k.g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f9029c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.f6515a)) {
            this.f9028a = (j) map.get(g.k.f6515a);
        }
        if (map.containsKey(s.b)) {
            this.e = ((Boolean) map.get(s.b)).booleanValue();
        }
        a(context);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        d dVar = this.d;
        boolean z = dVar != null && dVar.a();
        if (z && this.b == null) {
            this.b = b.a(this.d);
        }
        return z;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f9029c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.f6515a)) {
            this.f9028a = (j) map.get(g.k.f6515a);
        }
        a(context);
        this.d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATInterstitialAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                MyOfferATInterstitialAdapter myOfferATInterstitialAdapter = MyOfferATInterstitialAdapter.this;
                myOfferATInterstitialAdapter.b = b.a(myOfferATInterstitialAdapter.d);
                if (MyOfferATInterstitialAdapter.this.mLoadListener != null) {
                    MyOfferATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (MyOfferATInterstitialAdapter.this.mLoadListener != null) {
                    MyOfferATInterstitialAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        if (isAdReady()) {
            HashMap hashMap = new HashMap(1);
            int g = com.anythink.core.common.k.d.g(activity);
            hashMap.put(com.anythink.basead.f.c.h, this.f9028a.d);
            hashMap.put("extra_scenario", this.mScenario);
            hashMap.put(com.anythink.basead.f.c.j, Integer.valueOf(g));
            this.d.a(new com.anythink.basead.e.g() { // from class: com.anythink.network.myoffer.MyOfferATInterstitialAdapter.2
                @Override // com.anythink.basead.e.a
                public final void onAdClick(int i) {
                    com.anythink.core.common.e.e trackingInfo = MyOfferATInterstitialAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i);
                    }
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdClosed() {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdShow() {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onDeeplinkCallback(boolean z) {
                }

                @Override // com.anythink.basead.e.g
                public final void onRewarded() {
                }

                @Override // com.anythink.basead.e.a
                public final void onShowFailed(e eVar) {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
                    }
                }

                @Override // com.anythink.basead.e.g
                public final void onVideoAdPlayEnd() {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                    }
                }

                @Override // com.anythink.basead.e.g
                public final void onVideoAdPlayStart() {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
                    }
                }
            });
            this.d.a(activity, hashMap);
        }
    }
}
