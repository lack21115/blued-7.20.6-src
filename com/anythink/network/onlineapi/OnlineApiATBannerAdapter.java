package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d.a;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.cdo.oaps.ad.OapsKey;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATBannerAdapter.class */
public class OnlineApiATBannerAdapter extends CustomBannerAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f6207a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Object> f6208c;
    private a d;
    private View e;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATBannerAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATBannerAdapter$2.class */
    final class AnonymousClass2 implements com.anythink.basead.e.a {
        AnonymousClass2() {
        }

        public final void onAdClick(int i) {
            e trackingInfo = OnlineApiATBannerAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i);
            }
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        public final void onAdClosed() {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        public final void onAdShow() {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        public final void onDeeplinkCallback(boolean z) {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
            }
        }

        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = 0;
        if (map.containsKey("close_button")) {
            Object obj2 = map.get("close_button");
            i = 0;
            if (obj2 != null) {
                i = Integer.parseInt(obj2.toString());
            }
        }
        String obj3 = (!map.containsKey(OapsKey.KEY_SIZE) || (obj = map.get(OapsKey.KEY_SIZE)) == null) ? "320x50" : obj.toString();
        this.f6207a = (j) map.get("basead_params");
        a aVar = new a(context, b.a.b, this.f6207a);
        this.d = aVar;
        aVar.a(new c.a().c(i).b(obj3).a());
        this.d.a(new AnonymousClass2());
    }

    public void destory() {
        this.e = null;
        a aVar = this.d;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.d.b();
            this.d = null;
        }
    }

    public View getBannerView() {
        a aVar;
        if (this.e == null && (aVar = this.d) != null && aVar.c()) {
            this.e = this.d.a();
        }
        if (this.f6208c == null) {
            this.f6208c = com.anythink.basead.b.a(this.d);
        }
        return this.e;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.f6208c;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkPlacementId() {
        return this.b;
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = 0;
        if (map.containsKey("close_button")) {
            Object obj2 = map.get("close_button");
            i = 0;
            if (obj2 != null) {
                i = Integer.parseInt(obj2.toString());
            }
        }
        String obj3 = (!map.containsKey(OapsKey.KEY_SIZE) || (obj = map.get(OapsKey.KEY_SIZE)) == null) ? "320x50" : obj.toString();
        this.f6207a = (j) map.get("basead_params");
        a aVar = new a(context, b.a.b, this.f6207a);
        this.d = aVar;
        aVar.a(new c.a().c(i).b(obj3).a());
        this.d.a(new AnonymousClass2());
        this.d.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATBannerAdapter.1
            public final void onAdCacheLoaded() {
                OnlineApiATBannerAdapter onlineApiATBannerAdapter = OnlineApiATBannerAdapter.this;
                onlineApiATBannerAdapter.e = onlineApiATBannerAdapter.d.a();
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    if (OnlineApiATBannerAdapter.this.e != null) {
                        OnlineApiATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    } else {
                        OnlineApiATBannerAdapter.this.mLoadListener.onAdLoadError("", "Online bannerView = null");
                    }
                }
            }

            public final void onAdDataLoaded() {
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    OnlineApiATBannerAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    OnlineApiATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }
}
