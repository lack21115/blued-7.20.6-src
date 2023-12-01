package com.baidu.mobads.sdk.api;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeH5AdViewManager.class */
public class BaiduNativeH5AdViewManager {
    private static BaiduNativeH5AdViewManager theInstance;

    private BaiduNativeH5AdViewManager() {
    }

    public static BaiduNativeH5AdViewManager getInstance() {
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        synchronized (BaiduNativeH5AdViewManager.class) {
            try {
                if (theInstance == null) {
                    theInstance = new BaiduNativeH5AdViewManager();
                }
                baiduNativeH5AdViewManager = theInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return baiduNativeH5AdViewManager;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        BaiduNativeH5AdView adView = baiduNativeAdPlacement.getAdView();
        if (baiduNativeAdPlacement.getAdView() == null) {
            adView = new BaiduNativeH5AdView(context, i);
            adView.setAdPlacement(baiduNativeAdPlacement);
            baiduNativeAdPlacement.setAdView(adView);
        }
        return adView;
    }
}
