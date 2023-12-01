package com.soft.blued.customview.banner;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.banner.BannerView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/banner/HWBannerManager.class */
public class HWBannerManager<V> extends BannerAdManagerAdapter {
    /* JADX WARN: Type inference failed for: r0v3, types: [com.huawei.hms.ads.banner.BannerView, V] */
    @Override // com.soft.blued.customview.banner.BannerAdManagerAdapter, com.soft.blued.customview.banner.BannerAdManager
    public V a(Context context, String str, final BannerAdListener bannerAdListener) {
        ?? r0 = (V) ((BannerView) LayoutInflater.from(context).inflate(R.layout.hw_banner, (ViewGroup) null));
        r0.setAdId(str);
        r0.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
        r0.setAdListener(new AdListener() { // from class: com.soft.blued.customview.banner.HWBannerManager.1
            @Override // com.huawei.hms.ads.AdListener
            public void onAdClicked() {
                Log.v("drb", "华为banner广告 onAdClicked");
                bannerAdListener.b();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdClosed() {
                Log.v("drb", "华为banner广告 onAdClosed");
                bannerAdListener.c();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdFailed(int i) {
                Log.v("drb", "华为banner广告失败：" + i);
                bannerAdListener.a(i, "");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdImpression() {
                Log.v("drb", "华为banner广告 onAdImpression");
                bannerAdListener.d();
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLeave() {
                Log.v("drb", "华为banner广告 onAdLeave");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdLoaded() {
                Log.v("drb", "华为banner广告 onAdLoaded");
            }

            @Override // com.huawei.hms.ads.AdListener
            public void onAdOpened() {
                Log.v("drb", "华为banner广告 onAdOpened");
            }
        });
        return r0;
    }
}
