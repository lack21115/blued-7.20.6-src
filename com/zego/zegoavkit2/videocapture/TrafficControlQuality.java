package com.zego.zegoavkit2.videocapture;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videocapture/TrafficControlQuality.class */
public class TrafficControlQuality {
    private int videoBitrate;
    private int videoFrameRate;
    private int videoHeight;
    private int videoWidth;

    TrafficControlQuality(int i, int i2, int i3, int i4) {
        this.videoBitrate = i;
        this.videoFrameRate = i2;
        this.videoWidth = i3;
        this.videoHeight = i4;
    }

    public int getVideoBitrate() {
        return this.videoBitrate;
    }

    public int getVideoFrameRate() {
        return this.videoFrameRate;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }
}
