package com.soft.blued.ui.welcome.manager;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.blued.android.core.net.IRequestHost;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/TXSplashManager.class */
public class TXSplashManager extends SplashAdManagerAdapter {
    @Override // com.soft.blued.ui.welcome.manager.SplashAdManagerAdapter, com.soft.blued.ui.welcome.manager.SplashAdManager
    public void a(Context context, String str, ViewGroup viewGroup, IRequestHost iRequestHost, final SplashAdListener splashAdListener) {
        new SplashAD(context, str, new SplashADListener() { // from class: com.soft.blued.ui.welcome.manager.TXSplashManager.1
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                splashAdListener.c();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                splashAdListener.d();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long j) {
                splashAdListener.a();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                splashAdListener.b();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j) {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                Log.v("drb", "广点通回调 onNoAD:" + adError.getErrorMsg());
                splashAdListener.a(adError.getErrorCode(), adError.getErrorMsg());
            }
        }, 3000).fetchAndShowIn(viewGroup);
    }
}
