package com.anythink.network.adx;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d.a;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.e.e;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.j;
import com.cdo.oaps.ad.OapsKey;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATBannerAdapter.class */
public class AdxATBannerAdapter extends CustomBannerAdapter {

    /* renamed from: a  reason: collision with root package name */
    j f5991a;
    Map<String, Object> b;

    /* renamed from: c  reason: collision with root package name */
    private a f5992c;
    private View d;

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        int parseInt = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : Integer.parseInt(obj2.toString());
        String obj3 = (!map.containsKey(OapsKey.KEY_SIZE) || (obj = map.get(OapsKey.KEY_SIZE)) == null) ? "320x50" : obj.toString();
        int i = 0;
        if (map2 != null) {
            i = 0;
            if (map2.containsKey("key_height")) {
                try {
                    i = (int) Double.parseDouble(map2.get("key_height").toString());
                } catch (Throwable th) {
                    th.printStackTrace();
                    i = 0;
                }
            }
        }
        this.f5991a = (j) map.get("basead_params");
        a aVar = new a(context, b.a.a, this.f5991a);
        this.f5992c = aVar;
        aVar.a(new c.a().c(parseInt).b(obj3).g(i).a());
    }

    public void destory() {
        this.d = null;
        a aVar = this.f5992c;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.f5992c.b();
            this.f5992c = null;
        }
    }

    public View getBannerView() {
        return this.d;
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get("basead_params");
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillBannerData(map);
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
    }

    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        j jVar = this.f5991a;
        return jVar != null ? jVar.b : "";
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        int parseInt = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : Integer.parseInt(obj2.toString());
        String obj3 = (!map.containsKey(OapsKey.KEY_SIZE) || (obj = map.get(OapsKey.KEY_SIZE)) == null) ? "320x50" : obj.toString();
        int i = 0;
        if (map2 != null) {
            i = 0;
            if (map2.containsKey("key_height")) {
                try {
                    i = (int) Double.parseDouble(map2.get("key_height").toString());
                } catch (Throwable th) {
                    th.printStackTrace();
                    i = 0;
                }
            }
        }
        this.f5991a = (j) map.get("basead_params");
        a aVar = new a(context, b.a.a, this.f5991a);
        this.f5992c = aVar;
        aVar.a(new c.a().c(parseInt).b(obj3).g(i).a());
        this.f5992c.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.adx.AdxATBannerAdapter.1
            public final void onAdCacheLoaded() {
                if (AdxATBannerAdapter.this.f5992c == null || AdxATBannerAdapter.this.mLoadListener == null) {
                    return;
                }
                AdxATBannerAdapter adxATBannerAdapter = AdxATBannerAdapter.this;
                adxATBannerAdapter.b = com.anythink.basead.b.a(adxATBannerAdapter.f5992c);
                AdxATBannerAdapter.this.f5992c.a(new e(AdxATBannerAdapter.this.f5992c.d()) { // from class: com.anythink.network.adx.AdxATBannerAdapter.1.1
                    public final void onAdClick(int i2) {
                        com.anythink.core.common.e.e trackingInfo = AdxATBannerAdapter.this.getTrackingInfo();
                        if (trackingInfo != null) {
                            trackingInfo.x(i2);
                        }
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                        }
                    }

                    public final void onAdClosed() {
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                        }
                    }

                    public final void onAdShow() {
                        super.onAdShow();
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                        }
                    }

                    public final void onDeeplinkCallback(boolean z) {
                        if (AdxATBannerAdapter.this.mImpressionEventListener != null) {
                            AdxATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
                        }
                    }

                    public final void onShowFailed(com.anythink.basead.c.e eVar) {
                    }
                });
                AdxATBannerAdapter adxATBannerAdapter2 = AdxATBannerAdapter.this;
                adxATBannerAdapter2.d = adxATBannerAdapter2.f5992c.a();
                if (AdxATBannerAdapter.this.d != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                } else {
                    AdxATBannerAdapter.this.mLoadListener.onAdLoadError("", "Adx bannerView = null");
                }
            }

            public final void onAdDataLoaded() {
                if (AdxATBannerAdapter.this.mLoadListener != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdDataLoaded();
                }
            }

            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (AdxATBannerAdapter.this.mLoadListener != null) {
                    AdxATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }
}
