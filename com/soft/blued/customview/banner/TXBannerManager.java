package com.soft.blued.customview.banner;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/banner/TXBannerManager.class */
public class TXBannerManager<V> extends BannerAdManagerAdapter {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.qq.e.ads.banner2.UnifiedBannerView, V] */
    @Override // com.soft.blued.customview.banner.BannerAdManagerAdapter, com.soft.blued.customview.banner.BannerAdManager
    public V a(Context context, String str, final BannerAdListener bannerAdListener) {
        ?? r0 = (V) new UnifiedBannerView((Activity) context, str, new UnifiedBannerADListener() { // from class: com.soft.blued.customview.banner.TXBannerManager.1
            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                bannerAdListener.b();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                bannerAdListener.c();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                bannerAdListener.d();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                bannerAdListener.a();
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError adError) {
                bannerAdListener.a(adError.getErrorCode(), adError.getErrorMsg());
                Log.v("drb", "banner广点通错误码：" + adError.getErrorCode() + adError.getErrorMsg());
            }
        });
        r0.setRefresh(0);
        return r0;
    }
}
