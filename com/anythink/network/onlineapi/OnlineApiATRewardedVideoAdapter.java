package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.f;
import com.anythink.basead.e.g;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.d;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATRewardedVideoAdapter.class */
public class OnlineApiATRewardedVideoAdapter extends CustomRewardVideoAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f6218a;
    f b;

    /* renamed from: c  reason: collision with root package name */
    String f6219c;
    Map<String, Object> d;

    private void a(Context context, Map<String, Object> map) {
        this.f6219c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
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
        this.f6218a = (j) map.get("basead_params");
        f fVar = new f(context, b.a.b, this.f6218a);
        this.b = fVar;
        fVar.a(new c.a().a(i).b(i2).a());
    }

    public void destory() {
        f fVar = this.b;
        if (fVar != null) {
            fVar.b();
            this.b = null;
        }
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkPlacementId() {
        return this.f6219c;
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        return true;
    }

    public boolean isAdReady() {
        f fVar = this.b;
        boolean z = fVar != null && fVar.c();
        if (z && this.d == null) {
            this.d = com.anythink.basead.b.a(this.b);
        }
        return z;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.2
            public final void onAdCacheLoaded() {
                OnlineApiATRewardedVideoAdapter onlineApiATRewardedVideoAdapter = OnlineApiATRewardedVideoAdapter.this;
                onlineApiATRewardedVideoAdapter.d = com.anythink.basead.b.a(onlineApiATRewardedVideoAdapter.b);
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            public final void onAdDataLoaded() {
                if (OnlineApiATRewardedVideoAdapter.this.mLoadListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

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
        hashMap.put("extra_orientation", Integer.valueOf(g));
        this.b.a(new g() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.1
            public final void onAdClick(int i) {
                com.anythink.core.common.e.e trackingInfo = OnlineApiATRewardedVideoAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i);
                }
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            public final void onAdClosed() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            public final void onAdShow() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            public final void onDeeplinkCallback(boolean z) {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onDeeplinkCallback(z);
                }
            }

            public final void onRewarded() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onReward();
                }
            }

            public final void onShowFailed(e eVar) {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed(eVar.a(), eVar.b());
                }
            }

            public final void onVideoAdPlayEnd() {
                if (OnlineApiATRewardedVideoAdapter.this.mImpressionListener != null) {
                    OnlineApiATRewardedVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            public final void onVideoAdPlayStart() {
            }
        });
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(activity, hashMap);
        }
    }
}
