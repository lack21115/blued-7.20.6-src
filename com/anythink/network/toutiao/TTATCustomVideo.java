package com.anythink.network.toutiao;

import com.anythink.core.api.ATCustomVideo;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATCustomVideo.class */
public class TTATCustomVideo implements ATCustomVideo {

    /* renamed from: a  reason: collision with root package name */
    TTFeedAd.CustomizeVideo f6259a;

    public TTATCustomVideo(TTFeedAd.CustomizeVideo customizeVideo) {
        this.f6259a = customizeVideo;
    }

    public String getVideoUrl() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            return customizeVideo.getVideoUrl();
        }
        return null;
    }

    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    public void reportVideoBreak(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    public void reportVideoContinue(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    public void reportVideoError(long j, int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i, i2);
        }
    }

    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    public void reportVideoPause(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    public void reportVideoStartError(int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f6259a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i, i2);
        }
    }
}
