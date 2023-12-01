package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.e.c;
import com.anythink.basead.e.g;
import com.anythink.basead.f.d;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.j;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATInterstitialAdapter.class */
public class MyOfferATInterstitialAdapter extends CustomInterstitialAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f6188a;
    Map<String, Object> b;
    private d d;

    /* renamed from: c  reason: collision with root package name */
    private String f6189c = "";
    private boolean e = false;

    private void a(Context context) {
        this.d = new d(context, this.f6188a, this.f6189c, this.e);
    }

    public void destory() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a((g) null);
            this.d = null;
        }
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
    }

    public String getNetworkName() {
        return "MyOffer";
    }

    public String getNetworkPlacementId() {
        return this.f6189c;
    }

    public String getNetworkSDKVersion() {
        return com.anythink.core.common.k.g.a();
    }

    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6189c = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.f6188a = (j) map.get("basead_params");
        }
        if (map.containsKey("isDefaultOffer")) {
            this.e = ((Boolean) map.get("isDefaultOffer")).booleanValue();
        }
        a(context);
        return true;
    }

    public boolean isAdReady() {
        d dVar = this.d;
        boolean z = dVar != null && dVar.a();
        if (z && this.b == null) {
            this.b = b.a(this.d);
        }
        return z;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6189c = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.f6188a = (j) map.get("basead_params");
        }
        a(context);
        this.d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATInterstitialAdapter.1
            public final void onAdCacheLoaded() {
                MyOfferATInterstitialAdapter myOfferATInterstitialAdapter = MyOfferATInterstitialAdapter.this;
                myOfferATInterstitialAdapter.b = b.a(myOfferATInterstitialAdapter.d);
                if (MyOfferATInterstitialAdapter.this.mLoadListener != null) {
                    MyOfferATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            public final void onAdDataLoaded() {
            }

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
            hashMap.put("extra_request_id", this.f6188a.d);
            hashMap.put("extra_scenario", this.mScenario);
            hashMap.put("extra_orientation", Integer.valueOf(g));
            this.d.a(new g() { // from class: com.anythink.network.myoffer.MyOfferATInterstitialAdapter.2
                public final void onAdClick(int i) {
                    com.anythink.core.common.e.e trackingInfo = MyOfferATInterstitialAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i);
                    }
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                    }
                }

                public final void onAdClosed() {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                    }
                }

                public final void onAdShow() {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                    }
                }

                public final void onDeeplinkCallback(boolean z) {
                }

                public final void onRewarded() {
                }

                public final void onShowFailed(e eVar) {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
                    }
                }

                public final void onVideoAdPlayEnd() {
                    if (MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                        MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
                    }
                }

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
