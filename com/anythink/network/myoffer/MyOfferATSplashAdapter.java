package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.b;
import com.anythink.basead.e.a;
import com.anythink.basead.e.c;
import com.anythink.basead.f.g;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATSplashAdapter.class */
public class MyOfferATSplashAdapter extends CustomSplashAdapter {

    /* renamed from: a  reason: collision with root package name */
    String f6199a;
    g b;

    /* renamed from: c  reason: collision with root package name */
    j f6200c;
    Map<String, Object> d;

    /* renamed from: com.anythink.network.myoffer.MyOfferATSplashAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATSplashAdapter$2.class */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        public final void onAdClick(int i) {
            e trackingInfo = MyOfferATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i);
            }
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        public final void onAdClosed() {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        public final void onAdShow() {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdShow();
            }
        }

        public final void onDeeplinkCallback(boolean z) {
        }

        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode("4006", eVar.a(), eVar.b()));
            }
        }
    }

    private void a(Context context) {
        g gVar = new g(context, this.f6200c, this.f6199a);
        this.b = gVar;
        gVar.a(new AnonymousClass2());
    }

    public void destory() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.f();
            this.b = null;
        }
        this.f6200c = null;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    public String getNetworkName() {
        return "MyOffer";
    }

    public String getNetworkPlacementId() {
        return this.f6199a;
    }

    public String getNetworkSDKVersion() {
        return com.anythink.core.common.k.g.a();
    }

    public boolean isAdReady() {
        g gVar = this.b;
        boolean z = gVar != null && gVar.a();
        if (z && this.d == null) {
            this.d = b.a(this.b);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6199a = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.f6200c = (j) map.get("basead_params");
        }
        g gVar = new g(context, this.f6200c, this.f6199a);
        this.b = gVar;
        gVar.a(new AnonymousClass2());
        this.b.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATSplashAdapter.1
            public final void onAdCacheLoaded() {
                if (MyOfferATSplashAdapter.this.mLoadListener != null) {
                    MyOfferATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            public final void onAdDataLoaded() {
            }

            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (MyOfferATSplashAdapter.this.mLoadListener != null) {
                    MyOfferATSplashAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.b != null) {
            if (isCustomSkipView()) {
                this.b.b();
            }
            this.b.a(viewGroup);
        }
    }
}
