package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.e.c;
import com.anythink.basead.e.g;
import com.anythink.basead.f.f;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.d;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATRewardedVideoAdapter.class */
public class MyOfferATRewardedVideoAdapter extends CustomRewardVideoAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f6195a;
    Map<String, Object> b;
    private f d;

    /* renamed from: c  reason: collision with root package name */
    private String f6196c = "";
    private boolean e = false;

    private void a(Context context) {
        this.d = new f(context, this.f6195a, this.f6196c, this.e);
    }

    public void destory() {
        f fVar = this.d;
        if (fVar != null) {
            fVar.a((g) null);
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
        return this.f6196c;
    }

    public String getNetworkSDKVersion() {
        return com.anythink.core.common.k.g.a();
    }

    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6196c = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.f6195a = (j) map.get("basead_params");
        }
        if (map.containsKey("isDefaultOffer")) {
            this.e = ((Boolean) map.get("isDefaultOffer")).booleanValue();
        }
        a(context);
        return true;
    }

    public boolean isAdReady() {
        f fVar = this.d;
        boolean z = fVar != null && fVar.a();
        if (z && this.b == null) {
            this.b = b.a(this.d);
        }
        return z;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6196c = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.f6195a = (j) map.get("basead_params");
        }
        a(context);
        this.d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATRewardedVideoAdapter.1
            public final void onAdCacheLoaded() {
                MyOfferATRewardedVideoAdapter myOfferATRewardedVideoAdapter = MyOfferATRewardedVideoAdapter.this;
                myOfferATRewardedVideoAdapter.b = b.a(myOfferATRewardedVideoAdapter.d);
                if (MyOfferATRewardedVideoAdapter.this.mLoadListener != null) {
                    MyOfferATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            public final void onAdDataLoaded() {
            }

            public final void onAdLoadFailed(e eVar) {
                if (MyOfferATRewardedVideoAdapter.this.mLoadListener != null) {
                    MyOfferATRewardedVideoAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        int g = d.g(activity);
        if (isAdReady()) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("extra_request_id", this.f6195a.d);
            hashMap.put("extra_scenario", this.mScenario);
            hashMap.put("extra_orientation", Integer.valueOf(g));
            this.d.a(new g() { // from class: com.anythink.network.myoffer.MyOfferATRewardedVideoAdapter.2
                public final void onAdClick(int i) {
                    com.anythink.core.common.e.e trackingInfo = MyOfferATRewardedVideoAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i);
                    }
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }

                public final void onAdClosed() {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                public final void onAdShow() {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                    }
                }

                public final void onDeeplinkCallback(boolean z) {
                }

                public final void onRewarded() {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onReward();
                    }
                }

                public final void onShowFailed(e eVar) {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(eVar.a(), eVar.b());
                    }
                }

                public final void onVideoAdPlayEnd() {
                    if (MyOfferATRewardedVideoAdapter.this.mImpressionListener != null) {
                        MyOfferATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                public final void onVideoAdPlayStart() {
                }
            });
            this.d.a(activity, hashMap);
        }
    }
}
