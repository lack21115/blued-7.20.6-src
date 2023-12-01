package com.anythink.network.adx;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d.a;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.e.e;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATBannerAdapter.class */
public class AdxATBannerAdapter extends CustomBannerAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f8831a;
    Map<String, Object> b;

    /* renamed from: c  reason: collision with root package name */
    private a f8832c;
    private View d;

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        int parseInt = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : Integer.parseInt(obj2.toString());
        String obj3 = (!map.containsKey("size") || (obj = map.get("size")) == null) ? k.f6665a : obj.toString();
        int i = 0;
        if (map2 != null) {
            i = 0;
            if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                try {
                    i = (int) Double.parseDouble(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
                } catch (Throwable th) {
                    th.printStackTrace();
                    i = 0;
                }
            }
        }
        this.f8831a = (j) map.get(g.k.f6515a);
        a aVar = new a(context, b.a.ADX_OFFER_REQUEST_TYPE, this.f8831a);
        this.f8832c = aVar;
        aVar.a(new c.a().c(parseInt).b(obj3).g(i).a());
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.d = null;
        a aVar = this.f8832c;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.f8832c.b();
            this.f8832c = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get(g.k.f6515a);
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillBannerData(map);
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        j jVar = this.f8831a;
        return jVar != null ? jVar.b : "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        int parseInt = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : Integer.parseInt(obj2.toString());
        String obj3 = (!map.containsKey("size") || (obj = map.get("size")) == null) ? k.f6665a : obj.toString();
        int i = 0;
        if (map2 != null) {
            i = 0;
            if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                try {
                    i = (int) Double.parseDouble(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
                } catch (Throwable th) {
                    th.printStackTrace();
                    i = 0;
                }
            }
        }
        this.f8831a = (j) map.get(g.k.f6515a);
        a aVar = new a(context, b.a.ADX_OFFER_REQUEST_TYPE, this.f8831a);
        this.f8832c = aVar;
        aVar.a(new c.a().c(parseInt).b(obj3).g(i).a());
        this.f8832c.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.adx.AdxATBannerAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                if (AdxATBannerAdapter.this.f8832c == null || AdxATBannerAdapter.this.mLoadListener == null) {
                    return;
                }
                AdxATBannerAdapter adxATBannerAdapter = AdxATBannerAdapter.this;
                adxATBannerAdapter.b = com.anythink.basead.b.a(adxATBannerAdapter.f8832c);
                AdxATBannerAdapter.this.f8832c.a(new e(AdxATBannerAdapter.this.f8832c.d()) { // from class: com.anythink.network.adx.AdxATBannerAdapter.1.1
                    @Override // com.anythink.basead.e.a
                    public final void onAdClick(int i2) {
                        com.anythink.core.common.e.e trackingInfo = AdxATBannerAdapter.this.getTrackingInfo();
                        if (trackingInfo != null) {
                            trackingInfo.x(i2);
                        }
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                        }
                    }

                    @Override // com.anythink.basead.e.a
                    public final void onAdClosed() {
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                        }
                    }

                    @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
                    public final void onAdShow() {
                        super.onAdShow();
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                        }
                    }

                    @Override // com.anythink.basead.e.a
                    public final void onDeeplinkCallback(boolean z) {
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
                        }
                    }

                    @Override // com.anythink.basead.e.a
                    public final void onShowFailed(com.anythink.basead.c.e eVar) {
                    }
                });
                AdxATBannerAdapter adxATBannerAdapter2 = AdxATBannerAdapter.this;
                adxATBannerAdapter2.d = adxATBannerAdapter2.f8832c.a();
                if (AdxATBannerAdapter.this.d != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                } else {
                    AdxATBannerAdapter.this.mLoadListener.onAdLoadError("", "Adx bannerView = null");
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (AdxATBannerAdapter.this.mLoadListener != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (AdxATBannerAdapter.this.mLoadListener != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }
}
