package com.bytedance.sdk.openadsdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdSlot.class */
public interface TTAdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    public static final int TYPE_STREAM = 6;

    int getAdCount();

    String getAdId();

    TTAdLoadType getAdLoadType();

    int getAdType();

    int getAdloadSeq();

    String getBidAdm();

    String getCodeId();

    String getCreativeId();

    int getDurationSlotType();

    float getExpressViewAcceptedHeight();

    float getExpressViewAcceptedWidth();

    String getExt();

    int[] getExternalABVid();

    String getExtraSmartLookParam();

    int getImgAcceptedHeight();

    int getImgAcceptedWidth();

    String getMediaExtra();

    @Deprecated
    int getNativeAdType();

    int getOrientation();

    String getPrimeRit();

    String getUserData();

    String getUserID();

    boolean isAutoPlay();

    boolean isSupportDeepLink();

    boolean isSupportRenderConrol();

    void setAdCount(int i);

    void setDurationSlotType(int i);

    @Deprecated
    void setNativeAdType(int i);
}
