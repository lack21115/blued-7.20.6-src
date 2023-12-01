package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.f;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.d;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATRewardedVideoAdapter.class */
public class OnlineApiATRewardedVideoAdapter extends CustomRewardVideoAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f9058a;
    f b;

    /* renamed from: c  reason: collision with root package name */
    String f9059c;
    Map<String, Object> d;

    private void a(Context context, Map<String, Object> map) {
        this.f9059c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = 0;
        if (map.containsKey("v_m")) {
            Object obj = map.get("v_m");
            i = 0;
            if (obj != null) {
                i = Integer.parseInt(obj.toString());
            }
        }
        int i2 = -1;
        if (map.containsKey("s_c_t")) {
            Object obj2 = map.get("s_c_t");
            i2 = -1;
            if (obj2 != null) {
                i2 = Integer.parseInt(obj2.toString());
            }
        }
        this.f9058a = (j) map.get(g.k.f6515a);
        f fVar = new f(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.f9058a);
        this.b = fVar;
        fVar.a(new c.a().a(i).b(i2).a());
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        f fVar = this.b;
        if (fVar != null) {
            fVar.b();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f9059c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        f fVar = this.b;
        boolean z = fVar != null && fVar.c();
        if (z && this.d == null) {
            this.d = com.anythink.basead.b.a(this.b);
        }
        return z;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.2
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                OnlineApiATRewardedVideoAdapter onlineApiATRewardedVideoAdapter = OnlineApiATRewardedVideoAdapter.this;
                onlineApiATRewardedVideoAdapter.d = com.anythink.basead.b.a(onlineApiATRewardedVideoAdapter.b);
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        int g = d.g(activity);
        HashMap hashMap = new HashMap(1);
        hashMap.put("extra_scenario", this.mScenario);
        hashMap.put(com.anythink.basead.f.c.j, Integer.valueOf(g));
        this.b.a(new com.anythink.basead.e.g() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i) {
                com.anythink.core.common.e.e trackingInfo = OnlineApiATRewardedVideoAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i);
                }
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z) {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onDeeplinkCallback(z);
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onRewarded() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onReward();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(e eVar) {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(eVar.a(), eVar.b());
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayEnd() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayStart() {
            }
        });
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(activity, hashMap);
        }
    }
}
