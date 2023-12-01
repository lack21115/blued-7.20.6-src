package com.soft.blued.customview.banner;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.soft.blued.utils.third.TTADUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/banner/TTBannerManager.class */
public class TTBannerManager<V> extends BannerAdManagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private TTFeedAd f28553a;

    @Override // com.soft.blued.customview.banner.BannerAdManagerAdapter, com.soft.blued.customview.banner.BannerAdManager
    public V a(Context context, String str, final BannerAdListener bannerAdListener) {
        TTADUtils.a(context, str, new TTADUtils.TTGetAdListener() { // from class: com.soft.blued.customview.banner.TTBannerManager.1
            @Override // com.soft.blued.utils.third.TTADUtils.TTGetAdListener
            public void a() {
                bannerAdListener.e();
            }

            @Override // com.soft.blued.utils.third.TTADUtils.TTGetAdListener
            public void a(int i, String str2) {
                bannerAdListener.a(i, str2);
            }

            @Override // com.soft.blued.utils.third.TTADUtils.TTGetAdListener
            public void a(TTFeedAd tTFeedAd) {
                TTBannerManager.this.f28553a = tTFeedAd;
                bannerAdListener.a(tTFeedAd);
            }
        });
        return (V) this.f28553a;
    }
}
