package com.soft.blued.ui.welcome.manager;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashAdListener;
import com.blued.android.core.net.IRequestHost;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/TOPSplashManager.class */
public class TOPSplashManager extends SplashAdManagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ATSplashAd f34655a;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    @Override // com.soft.blued.ui.welcome.manager.SplashAdManagerAdapter, com.soft.blued.ui.welcome.manager.SplashAdManager
    public void a(final Context context, String str, final ViewGroup viewGroup, IRequestHost iRequestHost, final SplashAdListener splashAdListener) {
        ATSplashAd aTSplashAd = new ATSplashAd(context, str, new ATSplashAdListener() { // from class: com.soft.blued.ui.welcome.manager.TOPSplashManager.1
            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdClick(ATAdInfo aTAdInfo) {
                splashAdListener.c();
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
                splashAdListener.d();
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdLoadTimeout() {
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdLoaded(boolean z) {
                try {
                    if (context != null) {
                        TOPSplashManager.this.f34655a.show((Activity) context, viewGroup);
                    }
                } catch (Exception e) {
                    splashAdListener.a(0, e.toString());
                }
                splashAdListener.a();
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdShow(ATAdInfo aTAdInfo) {
                splashAdListener.b();
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onNoAdError(AdError adError) {
                splashAdListener.a(TOPSplashManager.this.a(adError.getCode()) ? Integer.parseInt(adError.getCode()) : 0, adError.getFullErrorInfo());
                Log.v("drb", "topon广告载入失败：" + adError.getFullErrorInfo());
            }
        });
        this.f34655a = aTSplashAd;
        if (aTSplashAd.isAdReady()) {
            this.f34655a.show((Activity) context, viewGroup);
        } else {
            this.f34655a.loadAd();
        }
    }
}
