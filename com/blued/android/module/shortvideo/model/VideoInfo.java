package com.blued.android.module.shortvideo.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/VideoInfo.class */
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
