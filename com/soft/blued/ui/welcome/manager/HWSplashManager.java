package com.soft.blued.ui.welcome.manager;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.splash.SplashView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/HWSplashManager.class */
public class HWSplashManager extends SplashAdManagerAdapter {
    @Override // com.soft.blued.ui.welcome.manager.SplashAdManagerAdapter, com.soft.blued.ui.welcome.manager.SplashAdManager
    public void a(Context context, String str, ViewGroup viewGroup, IRequestHost iRequestHost, final SplashAdListener splashAdListener) {
        AdParam build = new AdParam.Builder().build();
        SplashView.SplashAdLoadListener splashAdLoadListener = new SplashView.SplashAdLoadListener() { // from class: com.soft.blued.ui.welcome.manager.HWSplashManager.1
            @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
            public void onAdDismissed() {
                splashAdListener.d();
            }

            @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
            public void onAdFailedToLoad(int i) {
                Log.v("drn", "华为广告失败错误码：" + i);
                splashAdListener.a(i, "");
            }

            @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
            public void onAdLoaded() {
                splashAdListener.a();
                splashAdListener.b();
            }
        };
        SplashView splashView = new SplashView(context);
        splashView.setAudioFocusType(1);
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (viewGroup != null && fragmentActivity != null && !fragmentActivity.isFinishing()) {
            viewGroup.removeAllViews();
            viewGroup.addView(splashView);
        }
        splashView.load(str, 1, build, splashAdLoadListener);
    }
}
