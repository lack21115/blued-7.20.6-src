package com.soft.blued.customview.banner;

import android.content.Context;
import android.util.Log;
import com.anythink.banner.api.ATBannerListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.blued.android.framework.utils.DensityUtils;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/banner/TOPBannerManager.class */
public class TOPBannerManager<V> extends BannerAdManagerAdapter {
    /* JADX WARN: Type inference failed for: r0v7, types: [com.anythink.banner.api.ATBannerView, V] */
    @Override // com.soft.blued.customview.banner.BannerAdManagerAdapter, com.soft.blued.customview.banner.BannerAdManager
    public V a(Context context, String str, int i, final BannerAdListener bannerAdListener) {
        Log.v("drb", "banner1 setPlacementId：" + str);
        ?? r0 = (V) new ATBannerView(context);
        r0.setPlacementId(str);
        float f = (float) i;
        int a2 = DensityUtils.a(context, f);
        int round = Math.round(a2 / 4.0f);
        HashMap hashMap = new HashMap();
        hashMap.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(a2));
        hashMap.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(round));
        r0.setLocalExtra(hashMap);
        Log.v("drb", "width:" + a2 + " -- height:" + round + " -- width/4:" + (a2 / 4) + " -- bannerWidthUnitDP:" + DensityUtils.a(context, f));
        r0.setBannerAdListener(new ATBannerListener() { // from class: com.soft.blued.customview.banner.TOPBannerManager.1
            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerAutoRefreshFail(AdError adError) {
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerAutoRefreshed(ATAdInfo aTAdInfo) {
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerClicked(ATAdInfo aTAdInfo) {
                bannerAdListener.b();
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerClose(ATAdInfo aTAdInfo) {
                bannerAdListener.c();
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerFailed(AdError adError) {
                Log.v("drb", "banner1 topon onBannerFailed:" + adError.toString());
                try {
                    bannerAdListener.a(Integer.parseInt(adError.getCode()), adError.getDesc());
                } catch (Exception e) {
                }
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerLoaded() {
                Log.v("drb", "banner1 topon onBannerLoaded");
                bannerAdListener.a();
            }

            @Override // com.anythink.banner.api.ATBannerListener
            public void onBannerShow(ATAdInfo aTAdInfo) {
                Log.v("drb", "banner1 topon onBannerShow");
                bannerAdListener.d();
            }
        });
        return r0;
    }
}
