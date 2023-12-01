package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/VideoInfo.class */
public class VideoInfo implements Serializable {
    private static final long serialVersionUID = 5224357961234973073L;
    private Integer autoPlayAreaRatio;
    private Integer autoStopPlayAreaRatio;
    private int checkSha256Flag;
    @com.huawei.openalliance.ad.annotations.a
    private String originalDownloadUrl;
    private String sha256__;
    private float splashSwitchTime;
    @com.huawei.openalliance.ad.annotations.a
    private String videoDownloadUrl__;
    private int videoDuration__;
    private int videoFileSize__;
    private Float videoRatio;
    private String videoAutoPlayOnWifi = "y";
    private String videoAutoPlayWithSound__ = "n";
    private int timeBeforeVideoAutoPlay__ = 200;
    private int videoPlayMode__ = 1;
    private int downloadNetwork = 0;
    private String showSoundIcon = "y";

    public String B() {
        return this.videoAutoPlayOnWifi;
    }

    public String C() {
        return this.videoAutoPlayWithSound__;
    }

    public String Code() {
        return this.videoDownloadUrl__;
    }

    public void Code(float f) {
        this.splashSwitchTime = f;
    }

    public int D() {
        return this.videoPlayMode__;
    }

    public String F() {
        return this.sha256__;
    }

    public int I() {
        return this.videoDuration__;
    }

    public int L() {
        return this.checkSha256Flag;
    }

    public int S() {
        return this.timeBeforeVideoAutoPlay__;
    }

    public String V() {
        return this.originalDownloadUrl;
    }

    public int Z() {
        return this.videoFileSize__;
    }

    public Integer a() {
        return this.autoPlayAreaRatio;
    }

    public Integer b() {
        return this.autoStopPlayAreaRatio;
    }

    public int c() {
        return this.downloadNetwork;
    }

    public Float d() {
        return this.videoRatio;
    }

    public String e() {
        return this.showSoundIcon;
    }

    public float f() {
        return this.splashSwitchTime;
    }
}
