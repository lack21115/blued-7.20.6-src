package com.bytedance.sdk.openadsdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTFeedAd.class */
public interface TTFeedAd extends TTNativeAd {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTFeedAd$CustomizeVideo.class */
    public interface CustomizeVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTFeedAd$VideoAdListener.class */
    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete(TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i, int i2);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTFeedAd$VideoRewardListener.class */
    public interface VideoRewardListener {
        void onFeedRewardCountDown(int i);
    }

    int getAdViewHeight();

    int getAdViewWidth();

    CustomizeVideo getCustomVideo();

    double getVideoDuration();

    void setVideoAdListener(VideoAdListener videoAdListener);

    void setVideoRewardListener(VideoRewardListener videoRewardListener);
}
