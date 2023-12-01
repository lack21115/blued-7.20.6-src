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
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATSplashAdapter.class */
public class MyOfferATSplashAdapter extends CustomSplashAdapter {

    /* renamed from: a  reason: collision with root package name */
    String f9039a;
    g b;

    /* renamed from: c  reason: collision with root package name */
    j f9040c;
    Map<String, Object> d;

    /* renamed from: com.anythink.network.myoffer.MyOfferATSplashAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATSplashAdapter$2.class */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(int i) {
            e trackingInfo = MyOfferATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i);
            }
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow() {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (MyOfferATSplashAdapter.this.mImpressionListener != null) {
                MyOfferATSplashAdapter.this.mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, eVar.a(), eVar.b()));
            }
        }
    }

    private void a(Context context) {
        g gVar = new g(context, this.f9040c, this.f9039a);
        this.b = gVar;
        gVar.a(new AnonymousClass2());
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.f();
            this.b = null;
        }
        this.f9040c = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f9039a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return com.anythink.core.common.k.g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
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

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f9039a = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.f6515a)) {
            this.f9040c = (j) map.get(g.k.f6515a);
        }
        com.anythink.basead.f.g gVar = new com.anythink.basead.f.g(context, this.f9040c, this.f9039a);
        this.b = gVar;
        gVar.a(new AnonymousClass2());
        this.b.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATSplashAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                if (MyOfferATSplashAdapter.this.mLoadListener != null) {
                    MyOfferATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
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
