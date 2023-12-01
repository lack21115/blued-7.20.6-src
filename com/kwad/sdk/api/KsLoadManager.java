package com.kwad.sdk.api;

import android.app.Activity;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager.class */
public interface KsLoadManager {

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager$DrawAdListener.class */
    public interface DrawAdListener {
        @KsAdSdkApi
        void onDrawAdLoad(List<KsDrawAd> list);

        @KsAdSdkApi
        void onError(int i, String str);
    }

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager$FeedAdListener.class */
    public interface FeedAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onFeedAdLoad(List<KsFeedAd> list);
    }

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager$FullScreenVideoAdListener.class */
    public interface FullScreenVideoAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list);

        @KsAdSdkApi
        void onFullScreenVideoResult(List<KsFullScreenVideoAd> list);
    }

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager$InterstitialAdListener.class */
    public interface InterstitialAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onInterstitialAdLoad(List<KsInterstitialAd> list);

        @KsAdSdkApi
        void onRequestResult(int i);
    }

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager$NativeAdListener.class */
    public interface NativeAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onNativeAdLoad(List<KsNativeAd> list);
    }

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager$RewardVideoAdListener.class */
    public interface RewardVideoAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onRewardVideoAdLoad(List<KsRewardVideoAd> list);

        @KsAdSdkApi
        void onRewardVideoResult(List<KsRewardVideoAd> list);
    }

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsLoadManager$SplashScreenAdListener.class */
    public interface SplashScreenAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onRequestResult(int i);

        @KsAdSdkApi
        void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd);
    }

    @KsAdSdkApi
    String getBidRequestToken(KsScene ksScene);

    @KsAdSdkApi
    String getBidRequestTokenV2(KsScene ksScene);

    @KsAdSdkApi
    void loadConfigFeedAd(KsScene ksScene, FeedAdListener feedAdListener);

    @KsAdSdkApi
    void loadDrawAd(KsScene ksScene, DrawAdListener drawAdListener);

    @KsAdSdkApi
    @Deprecated
    void loadFeedAd(KsScene ksScene, FeedAdListener feedAdListener);

    @KsAdSdkApi
    void loadFullScreenVideoAd(KsScene ksScene, FullScreenVideoAdListener fullScreenVideoAdListener);

    @KsAdSdkApi
    void loadInterstitialAd(KsScene ksScene, InterstitialAdListener interstitialAdListener);

    @KsAdSdkApi
    void loadNativeAd(KsScene ksScene, NativeAdListener nativeAdListener);

    @KsAdSdkApi
    void loadNativeAd(String str, NativeAdListener nativeAdListener);

    @KsAdSdkApi
    void loadRewardVideoAd(KsScene ksScene, RewardVideoAdListener rewardVideoAdListener);

    @KsAdSdkApi
    void loadSplashScreenAd(KsScene ksScene, SplashScreenAdListener splashScreenAdListener);

    boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener);
}
