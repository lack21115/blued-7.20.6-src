package com.zego.zegoliveroom.constants;

import com.huawei.openalliance.ad.constant.t;
import com.sobot.chat.camera.StCameraView;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/constants/ZegoAvConfig.class */
public final class ZegoAvConfig {
    private int mVideoBitrate;
    private int mVideoCaptureResolutionHeight;
    private int mVideoCaptureResolutionWidth;
    private int mVideoEncodeResolutionHeight;
    private int mVideoEncodeResolutionWidth;
    private int mVideoFPS;
    public static final int[] VIDEO_FPSS = {5, 10, 15, 20, 25, 30};
    public static final int[] VIDEO_BITRATES = {300000, StCameraView.MEDIA_QUALITY_FUNNY, t.Y, StCameraView.MEDIA_QUALITY_LOW, 1500000, 3000000};

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/constants/ZegoAvConfig$Level.class */
    public static final class Level {
        public static final int Generic = 2;
        public static final int High = 3;
        public static final int Low = 1;
        public static final int SuperHigh = 5;
        public static final int VeryHigh = 4;
        public static final int VeryLow = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r5 > 5) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ZegoAvConfig(int r5) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoliveroom.constants.ZegoAvConfig.<init>(int):void");
    }

    public int getVideoBitrate() {
        return this.mVideoBitrate;
    }

    public int getVideoCaptureResolutionHeight() {
        return this.mVideoCaptureResolutionHeight;
    }

    public int getVideoCaptureResolutionWidth() {
        return this.mVideoCaptureResolutionWidth;
    }

    public int getVideoEncodeResolutionHeight() {
        return this.mVideoEncodeResolutionHeight;
    }

    public int getVideoEncodeResolutionWidth() {
        return this.mVideoEncodeResolutionWidth;
    }

    public int getVideoFPS() {
        return this.mVideoFPS;
    }

    public void setVideoBitrate(int i) {
        this.mVideoBitrate = i;
    }

    public void setVideoCaptureResolution(int i, int i2) {
        this.mVideoCaptureResolutionWidth = i;
        this.mVideoCaptureResolutionHeight = i2;
    }

    public void setVideoEncodeResolution(int i, int i2) {
        this.mVideoEncodeResolutionWidth = i;
        this.mVideoEncodeResolutionHeight = i2;
    }

    public void setVideoFPS(int i) {
        this.mVideoFPS = i;
    }
}
