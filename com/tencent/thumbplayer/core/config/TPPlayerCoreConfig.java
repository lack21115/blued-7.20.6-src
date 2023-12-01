package com.tencent.thumbplayer.core.config;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/config/TPPlayerCoreConfig.class */
public class TPPlayerCoreConfig {
    private static boolean mCoreEventProcessEnable = false;
    private static boolean mMediaDrmReuseEnable = false;
    private static int mVideoMediaCodecCoexistMaxCnt = 0;
    private static String mWidevineProvisioningServerUrl = "";

    public static boolean getCoreEventProcessEnable() {
        return mCoreEventProcessEnable;
    }

    public static boolean getMediaDrmReuseEnable() {
        return mMediaDrmReuseEnable;
    }

    public static int getVideoMediaCodecCoexistMaxCnt() {
        return mVideoMediaCodecCoexistMaxCnt;
    }

    public static String getWidevineProvisioningServerUrl() {
        return mWidevineProvisioningServerUrl;
    }

    public static void setCoreEventProcessEnable(boolean z) {
        mCoreEventProcessEnable = z;
    }

    public static void setMediaDrmReuseEnable(boolean z) {
        mMediaDrmReuseEnable = z;
    }

    public static void setVideoMediaCodecCoexistMaxCnt(int i) {
        mVideoMediaCodecCoexistMaxCnt = i;
    }

    public static void setWidevineProvisioningServerUrl(String str) {
        mWidevineProvisioningServerUrl = str;
    }
}
