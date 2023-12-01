package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/CSJSplashAd.class */
public interface CSJSplashAd extends TTClientBidding {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/CSJSplashAd$SplashAdListener.class */
    public interface SplashAdListener {
        void onSplashAdClick(CSJSplashAd cSJSplashAd);

        void onSplashAdClose(CSJSplashAd cSJSplashAd, int i);

        void onSplashAdShow(CSJSplashAd cSJSplashAd);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/CSJSplashAd$SplashCardListener.class */
    public interface SplashCardListener {
        void onSplashCardClick();

        void onSplashCardClose();

        void onSplashCardReadyToShow(CSJSplashAd cSJSplashAd);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/CSJSplashAd$SplashClickEyeListener.class */
    public interface SplashClickEyeListener {
        void onSplashClickEyeClick();

        void onSplashClickEyeClose();

        void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd);
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    View getSplashCardView();

    int[] getSplashClickEyeSizeToDp();

    View getSplashClickEyeView();

    View getSplashView();

    void hideSkipButton();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setSplashAdListener(SplashAdListener splashAdListener);

    void setSplashCardListener(SplashCardListener splashCardListener);

    void setSplashClickEyeListener(SplashClickEyeListener splashClickEyeListener);

    void showSplashCardView(ViewGroup viewGroup, Activity activity);

    void showSplashClickEyeView(ViewGroup viewGroup);

    void showSplashView(ViewGroup viewGroup);

    void startClickEye();
}
