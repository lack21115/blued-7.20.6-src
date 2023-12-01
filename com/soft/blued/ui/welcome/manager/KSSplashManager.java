package com.soft.blued.ui.welcome.manager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.net.IRequestHost;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/KSSplashManager.class */
public class KSSplashManager extends SplashAdManagerAdapter {
    @Override // com.soft.blued.ui.welcome.manager.SplashAdManagerAdapter, com.soft.blued.ui.welcome.manager.SplashAdManager
    public void a(final Context context, String str, final ViewGroup viewGroup, IRequestHost iRequestHost, final SplashAdListener splashAdListener) {
        KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(str)).build(), new KsLoadManager.SplashScreenAdListener() { // from class: com.soft.blued.ui.welcome.manager.KSSplashManager.1
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i, String str2) {
                Log.v("drb", "快手开机图 onError：" + i + " msg " + str2);
                splashAdListener.a(i, str2);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i) {
                splashAdListener.a();
                Log.v("drb", "快手开机图 onRequestResult:" + i);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                View view = ksSplashScreenAd.getView(context, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.soft.blued.ui.welcome.manager.KSSplashManager.1.1
                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdClicked() {
                        Log.v("drb", "快手开机图 onAdClicked");
                        splashAdListener.c();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdShowEnd() {
                        Log.v("drb", "快手开机图 onAdShowEnd");
                        splashAdListener.e();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdShowError(int i, String str2) {
                        Log.v("drb", "快手开机图 onAdShowError：" + i + " extra " + str2);
                        splashAdListener.a(i, str2);
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdShowStart() {
                        Log.v("drb", "快手开机图 onAdShowStart");
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onDownloadTipsDialogCancel() {
                        Log.v("drb", "开屏广告取消下载合规弹窗");
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                        Log.v("drb", "开屏广告关闭下载合规弹窗");
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onDownloadTipsDialogShow() {
                        Log.v("drb", "开屏广告显示下载合规弹窗");
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onSkippedAd() {
                        Log.v("drb", "快手开机图 onSkippedAd");
                        splashAdListener.d();
                    }
                });
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewGroup.addView(view);
            }
        });
    }
}
