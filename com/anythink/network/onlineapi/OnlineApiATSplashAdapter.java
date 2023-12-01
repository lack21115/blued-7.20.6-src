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
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATSplashAdapter.class */
public class OnlineApiATSplashAdapter extends CustomSplashAdapter {

    /* renamed from: a  reason: collision with root package name */
    g f6222a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    String f6223c;
    Map<String, Object> d;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATSplashAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/onlineapi/OnlineApiATSplashAdapter$2.class */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        public final void onAdClick(int i) {
            e trackingInfo = OnlineApiATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i);
            }
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        public final void onAdClosed() {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        public final void onAdShow() {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdShow();
            }
        }

        public final void onDeeplinkCallback(boolean z) {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onDeeplinkCallback(z);
            }
        }

        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (OnlineApiATSplashAdapter.this.mImpressionListener != null) {
                OnlineApiATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode("4006", eVar.a(), eVar.b()));
            }
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        this.f6223c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
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
        this.b = (j) map.get("basead_params");
        g gVar = new g(context, b.a.b, this.b);
        this.f6222a = gVar;
        gVar.a(new c.a().d(parseInt).e(i).f(i2).a());
        this.f6222a.a(new AnonymousClass2());
    }

    public void destory() {
        g gVar = this.f6222a;
        if (gVar != null) {
            gVar.b();
            this.f6222a = null;
        }
        this.b = null;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkPlacementId() {
        return this.f6223c;
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    public boolean isAdReady() {
        g gVar = this.f6222a;
        boolean z = gVar != null && gVar.c();
        if (z && this.d == null) {
            this.d = com.anythink.basead.b.a(this.f6222a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        this.f6223c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
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
        this.b = (j) map.get("basead_params");
        g gVar = new g(context, b.a.b, this.b);
        this.f6222a = gVar;
        gVar.a(new c.a().d(parseInt).e(i).f(i2).a());
        this.f6222a.a(new AnonymousClass2());
        this.f6222a.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATSplashAdapter.1
            public final void onAdCacheLoaded() {
                OnlineApiATSplashAdapter onlineApiATSplashAdapter = OnlineApiATSplashAdapter.this;
                onlineApiATSplashAdapter.d = com.anythink.basead.b.a(onlineApiATSplashAdapter.f6222a);
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            public final void onAdDataLoaded() {
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (OnlineApiATSplashAdapter.this.mLoadListener != null) {
                    OnlineApiATSplashAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.f6222a != null) {
            if (isCustomSkipView()) {
                this.f6222a.a();
            }
            this.f6222a.a(viewGroup);
        }
    }
}
