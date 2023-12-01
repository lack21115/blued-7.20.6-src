package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.g;
import com.anythink.basead.e.a;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATSplashAdapter.class */
public class OnlineApiATSplashAdapter extends CustomSplashAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f9062a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    String f9063c;
    Map<String, Object> d;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATSplashAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATSplashAdapter$2.class */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(int i) {
            e trackingInfo = OnlineApiATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i);
            }
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow() {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, eVar.a(), eVar.b()));
            }
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        this.f9063c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int parseInt = (!map.containsKey("orientation") || (obj = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj.toString());
        int i = 5;
        if (map.containsKey("countdown")) {
            Object obj2 = map.get("countdown");
            i = 5;
            if (obj2 != null) {
                i = Integer.parseInt(obj2.toString()) * 1000;
            }
        }
        int i2 = 1;
        if (map.containsKey("allows_skip")) {
            Object obj3 = map.get("allows_skip");
            i2 = 1;
            if (obj3 != null) {
                i2 = Integer.parseInt(obj3.toString());
                if (i2 == 0) {
                    i2 = 1;
                } else if (i2 == 1) {
                    i2 = 0;
                }
            }
        }
        this.b = (j) map.get(g.k.f6515a);
        com.anythink.basead.d.g gVar = new com.anythink.basead.d.g(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
        this.f9062a = gVar;
        gVar.a(new c.a().d(parseInt).e(i).f(i2).a());
        this.f9062a.a(new AnonymousClass2());
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        com.anythink.basead.d.g gVar = this.f9062a;
        if (gVar != null) {
            gVar.b();
            this.f9062a = null;
        }
        this.b = null;
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
        return this.f9063c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        com.anythink.basead.d.g gVar = this.f9062a;
        boolean z = gVar != null && gVar.c();
        if (z && this.d == null) {
            this.d = com.anythink.basead.b.a(this.f9062a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        this.f9063c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int parseInt = (!map.containsKey("orientation") || (obj = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj.toString());
        int i = 5;
        if (map.containsKey("countdown")) {
            Object obj2 = map.get("countdown");
            i = 5;
            if (obj2 != null) {
                i = Integer.parseInt(obj2.toString()) * 1000;
            }
        }
        int i2 = 1;
        if (map.containsKey("allows_skip")) {
            Object obj3 = map.get("allows_skip");
            i2 = 1;
            if (obj3 != null) {
                i2 = Integer.parseInt(obj3.toString());
                if (i2 == 0) {
                    i2 = 1;
                } else if (i2 == 1) {
                    i2 = 0;
                }
            }
        }
        this.b = (j) map.get(g.k.f6515a);
        com.anythink.basead.d.g gVar = new com.anythink.basead.d.g(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
        this.f9062a = gVar;
        gVar.a(new c.a().d(parseInt).e(i).f(i2).a());
        this.f9062a.a(new AnonymousClass2());
        this.f9062a.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATSplashAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                OnlineApiATSplashAdapter onlineApiATSplashAdapter = OnlineApiATSplashAdapter.this;
                onlineApiATSplashAdapter.d = com.anythink.basead.b.a(onlineApiATSplashAdapter.f9062a);
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.f9062a != null) {
            if (isCustomSkipView()) {
                this.f9062a.a();
            }
            this.f9062a.a(viewGroup);
        }
    }
}
