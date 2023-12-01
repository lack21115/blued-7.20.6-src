package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.common.CommonListener;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative.class */
public interface TTAdNative {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$BannerAdListener.class */
    public interface BannerAdListener extends CommonListener {
        void onBannerAdLoad(TTBannerAd tTBannerAd);

        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$CSJSplashAdListener.class */
    public interface CSJSplashAdListener {
        void onSplashLoadFail(CSJAdError cSJAdError);

        void onSplashLoadSuccess();

        void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError);

        void onSplashRenderSuccess(CSJSplashAd cSJSplashAd);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$DrawFeedAdListener.class */
    public interface DrawFeedAdListener extends CommonListener {
        void onDrawFeedAdLoad(List<TTDrawFeedAd> list);

        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$FeedAdListener.class */
    public interface FeedAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);

        void onFeedAdLoad(List<TTFeedAd> list);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$FullScreenVideoAdListener.class */
    public interface FullScreenVideoAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);

        void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd);

        @Deprecated
        void onFullScreenVideoCached();

        void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$InteractionAdListener.class */
    public interface InteractionAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);

        void onInteractionAdLoad(TTInteractionAd tTInteractionAd);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$NativeAdListener.class */
    public interface NativeAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);

        void onNativeAdLoad(List<TTNativeAd> list);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$NativeExpressAdListener.class */
    public interface NativeExpressAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);

        void onNativeExpressAdLoad(List<TTNativeExpressAd> list);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$RewardVideoAdListener.class */
    public interface RewardVideoAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);

        void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd);

        @Deprecated
        void onRewardVideoCached();

        void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener.class */
    public interface SplashAdListener extends CommonListener {
        @Override // com.bytedance.sdk.openadsdk.common.CommonListener
        void onError(int i, String str);

        void onSplashAdLoad(TTSplashAd tTSplashAd);

        void onTimeout();
    }

    void loadBannerExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadDrawFeedAd(AdSlot adSlot, DrawFeedAdListener drawFeedAdListener);

    void loadExpressDrawFeedAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadFeedAd(AdSlot adSlot, FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(AdSlot adSlot, FullScreenVideoAdListener fullScreenVideoAdListener);

    @Deprecated
    void loadInteractionExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadNativeAd(AdSlot adSlot, NativeAdListener nativeAdListener);

    void loadNativeExpressAd(AdSlot adSlot, NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(AdSlot adSlot, RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(AdSlot adSlot, CSJSplashAdListener cSJSplashAdListener, int i);

    @Deprecated
    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener);

    @Deprecated
    void loadSplashAd(AdSlot adSlot, SplashAdListener splashAdListener, int i);

    void loadStream(AdSlot adSlot, FeedAdListener feedAdListener);
}
