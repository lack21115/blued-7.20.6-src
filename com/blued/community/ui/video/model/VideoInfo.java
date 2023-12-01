package com.blued.community.ui.video.model;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/model/VideoInfo.class */
public class VideoInfo {
    public long mDuration;
    public boolean mFullScreen;
    public String mVideoUrl;

    public VideoInfo(String str, boolean z, long j) {
        this.mVideoUrl = str;
        this.mFullScreen = z;
        this.mDuration = j;
    }
}
