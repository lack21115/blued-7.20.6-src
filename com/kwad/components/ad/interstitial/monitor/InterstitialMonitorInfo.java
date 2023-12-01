package com.kwad.components.ad.interstitial.monitor;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/monitor/InterstitialMonitorInfo.class */
public class InterstitialMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final int DOWNLOAD_STATUS_ERROR = 2;
    public static final int DOWNLOAD_STATUS_START = 1;
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_AD_SHOWN = 4;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 5;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_SHOW_AD_CALL = 6;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int TYPE_H5 = 2;
    public static final int TYPE_NATIVE = 1;
    public static final int TYPE_TK = 3;
    public static final int VIDEO_PLAY_ERROR = 2;
    public static final int VIDEO_PLAY_START = 1;
    private static final long serialVersionUID = 6882024284587637114L;
    public long creativeId;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int errorCode;
    public String errorMsg;
    public int expectedRenderType;
    public long loadDataTime;
    public int materialType;
    public long posId;
    public long renderDuration;
    public int renderType;
    public int status;
    public int type;
    public long videoDuration;
    public String videoUrl;

    public InterstitialMonitorInfo(long j) {
        this.posId = j;
    }

    public InterstitialMonitorInfo setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public InterstitialMonitorInfo setDownloadDuration(long j) {
        this.downloadDuration = j;
        return this;
    }

    public InterstitialMonitorInfo setDownloadSize(long j) {
        this.downloadSize = j;
        return this;
    }

    public InterstitialMonitorInfo setDownloadType(int i) {
        this.downloadType = i;
        return this;
    }

    public InterstitialMonitorInfo setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public InterstitialMonitorInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public InterstitialMonitorInfo setExpectedRenderType(int i) {
        int i2;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            return this;
        } else {
            i2 = 3;
        }
        this.expectedRenderType = i2;
        return this;
    }

    public InterstitialMonitorInfo setLoadDataTime(long j) {
        this.loadDataTime = j;
        return this;
    }

    public InterstitialMonitorInfo setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public InterstitialMonitorInfo setRenderDuration(long j) {
        this.renderDuration = j;
        return this;
    }

    public InterstitialMonitorInfo setRenderType(int i) {
        this.renderType = i;
        return this;
    }

    public InterstitialMonitorInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public InterstitialMonitorInfo setType(int i) {
        this.type = i;
        return this;
    }

    public InterstitialMonitorInfo setVideoDuration(long j) {
        this.videoDuration = j;
        return this;
    }

    public InterstitialMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }
}
