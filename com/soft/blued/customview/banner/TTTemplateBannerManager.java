package com.soft.blued.customview.banner;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.soft.blued.utils.third.TTADUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/banner/TTTemplateBannerManager.class */
public class TTTemplateBannerManager<V> extends TTBannerManager {

    /* renamed from: a  reason: collision with root package name */
    private TTNativeExpressAd f28555a;

    @Override // com.soft.blued.customview.banner.TTBannerManager, com.soft.blued.customview.banner.BannerAdManagerAdapter, com.soft.blued.customview.banner.BannerAdManager
    public V a(Context context, String str, final BannerAdListener bannerAdListener) {
        TTADUtils.a(context, str, new TTADUtils.TTGetAdTemplateListener() { // from class: com.soft.blued.customview.banner.TTTemplateBannerManager.1
            @Override // com.soft.blued.utils.third.TTADUtils.TTGetAdTemplateListener
            public void a() {
                bannerAdListener.e();
            }

            @Override // com.soft.blued.utils.third.TTADUtils.TTGetAdTemplateListener
            public void a(int i, String str2) {
                bannerAdListener.a(i, str2);
            }

            @Override // com.soft.blued.utils.third.TTADUtils.TTGetAdTemplateListener
            public void a(TTNativeExpressAd tTNativeExpressAd) {
                TTTemplateBannerManager.this.f28555a = tTNativeExpressAd;
                bannerAdListener.a(tTNativeExpressAd);
            }
        });
        return (V) this.f28555a;
    }
}
