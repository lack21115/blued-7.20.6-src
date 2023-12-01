package com.soft.blued.ui.welcome.manager;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blued.android.core.net.IRequestHost;
import com.heytap.msp.mobad.api.ad.HotSplashAd;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/OppoSplashManager.class */
public class OppoSplashManager extends SplashAdManagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private HotSplashAd f34648a;

    @Override // com.soft.blued.ui.welcome.manager.SplashAdManagerAdapter, com.soft.blued.ui.welcome.manager.SplashAdManager
    public void a(final Context context, String str, ViewGroup viewGroup, IRequestHost iRequestHost, final SplashAdListener splashAdListener) {
        HotSplashAd hotSplashAd = this.f34648a;
        if (hotSplashAd != null) {
            hotSplashAd.destroyAd();
        }
        this.f34648a = new HotSplashAd(context, str, new IHotSplashListener() { // from class: com.soft.blued.ui.welcome.manager.OppoSplashManager.1
            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdClick() {
                Log.v("drb", "oppo开机图 onAdClick");
                splashAdListener.c();
            }

            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdDismissed() {
                Log.v("drb", "oppo开机图 onAdDismissed");
                splashAdListener.d();
                HotSplashAd hotSplashAd2 = OppoSplashManager.this.f34648a;
                if (hotSplashAd2 != null) {
                    hotSplashAd2.destroyAd();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdFailed(int i, String str2) {
                Log.v("drb", "oppo开机图 onAdFailed：" + i + " -- " + str2);
                splashAdListener.a(i, str2);
            }

            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdReady() {
                Log.v("drb", "oppo开机图 onAdReady");
                splashAdListener.a();
                OppoSplashManager.this.f34648a.showAd((Activity) context);
            }

            @Override // com.heytap.msp.mobad.api.listener.IHotSplashListener
            public void onAdShow(String str2) {
                Log.v("drb", "oppo开机图 onAdShow");
                splashAdListener.b();
            }
        }, new SplashAdParams.Builder().setFetchTimeout(5000L).setShowPreLoadPage(true).setBottomArea(LayoutInflater.from(context).inflate(R.layout.hot_splash_bottom_area, (ViewGroup) null)).build());
    }
}
