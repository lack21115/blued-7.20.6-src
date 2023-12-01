package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d.a;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATBannerAdapter.class */
public class OnlineApiATBannerAdapter extends CustomBannerAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f9047a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Object> f9048c;
    private a d;
    private View e;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATBannerAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATBannerAdapter$2.class */
    final class AnonymousClass2 implements com.anythink.basead.e.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(int i) {
            e trackingInfo = OnlineApiATBannerAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i);
            }
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow() {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                OnlineApiATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.a
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
        String obj3 = (!map.containsKey("size") || (obj = map.get("size")) == null) ? k.f6665a : obj.toString();
        this.f9047a = (j) map.get(g.k.f6515a);
        a aVar = new a(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.f9047a);
        this.d = aVar;
        aVar.a(new c.a().c(i).b(obj3).a());
        this.d.a(new AnonymousClass2());
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.e = null;
        a aVar = this.d;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.d.b();
            this.d = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        a aVar;
        if (this.e == null && (aVar = this.d) != null && aVar.c()) {
            this.e = this.d.a();
        }
        if (this.f9048c == null) {
            this.f9048c = com.anythink.basead.b.a(this.d);
        }
        return this.e;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f9048c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
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
        String obj3 = (!map.containsKey("size") || (obj = map.get("size")) == null) ? k.f6665a : obj.toString();
        this.f9047a = (j) map.get(g.k.f6515a);
        a aVar = new a(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.f9047a);
        this.d = aVar;
        aVar.a(new c.a().c(i).b(obj3).a());
        this.d.a(new AnonymousClass2());
        this.d.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATBannerAdapter.1
            @Override // com.anythink.basead.e.c
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

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    OnlineApiATBannerAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (OnlineApiATBannerAdapter.this.mLoadListener != null) {
                    OnlineApiATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }
}
