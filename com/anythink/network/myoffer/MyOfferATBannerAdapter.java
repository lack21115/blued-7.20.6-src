package com.anythink.network.myoffer;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.e.a;
import com.anythink.basead.e.c;
import com.anythink.basead.f.b;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.g;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATBannerAdapter.class */
public class MyOfferATBannerAdapter extends CustomBannerAdapter {

    /* renamed from: a  reason: collision with root package name */
    String f6184a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Object> f6185c;
    private b d;
    private View e;
    private boolean f = false;

    private void a(Context context) {
        b bVar = new b(context, this.b, this.f6184a, this.f);
        this.d = bVar;
        bVar.a(new a() { // from class: com.anythink.network.myoffer.MyOfferATBannerAdapter.2
            public final void onAdClick(int i) {
                e trackingInfo = MyOfferATBannerAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i);
                }
                if (MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                    MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                }
            }

            public final void onAdClosed() {
                if (MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                    MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                }
            }

            public final void onAdShow() {
                if (MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                    MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                }
            }

            public final void onDeeplinkCallback(boolean z) {
            }

            public final void onShowFailed(com.anythink.basead.c.e eVar) {
            }
        });
    }

    public void destory() {
        this.e = null;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a((a) null);
            this.d.c();
            this.d = null;
        }
    }

    public View getBannerView() {
        b bVar;
        if (this.e == null && (bVar = this.d) != null && bVar.a()) {
            this.e = this.d.b();
            if (this.f6185c == null) {
                this.f6185c = com.anythink.basead.b.a(this.d);
            }
        }
        return this.e;
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.f6185c;
    }

    public String getNetworkName() {
        return "MyOffer";
    }

    public String getNetworkPlacementId() {
        return this.f6184a;
    }

    public String getNetworkSDKVersion() {
        return g.a();
    }

    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6184a = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.b = (j) map.get("basead_params");
        }
        if (map.containsKey("isDefaultOffer")) {
            this.f = ((Boolean) map.get("isDefaultOffer")).booleanValue();
        }
        a(context);
        return true;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6184a = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.b = (j) map.get("basead_params");
        }
        a(context);
        this.d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATBannerAdapter.1
            public final void onAdCacheLoaded() {
                MyOfferATBannerAdapter myOfferATBannerAdapter = MyOfferATBannerAdapter.this;
                myOfferATBannerAdapter.e = myOfferATBannerAdapter.d.b();
                MyOfferATBannerAdapter myOfferATBannerAdapter2 = MyOfferATBannerAdapter.this;
                myOfferATBannerAdapter2.f6185c = com.anythink.basead.b.a(myOfferATBannerAdapter2.d);
                if (MyOfferATBannerAdapter.this.mLoadListener != null) {
                    if (MyOfferATBannerAdapter.this.e != null) {
                        MyOfferATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    } else {
                        MyOfferATBannerAdapter.this.mLoadListener.onAdLoadError("", "MyOffer bannerView = null");
                    }
                }
            }

            public final void onAdDataLoaded() {
            }

            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (MyOfferATBannerAdapter.this.mLoadListener != null) {
                    MyOfferATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }
}
