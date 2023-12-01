package com.qiniu.pili.droid.shortvideo;

import android.graphics.Rect;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoMixItem.class */
public class PLVideoMixItem {
    private boolean mLooping;
    private int mStartTimeMs;
    private String mVideoPath;
    private Rect mVideoRect;
    private float mVolume = 1.0f;
    private PLDisplayMode mDisplayMode = PLDisplayMode.FULL;

    public PLDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public int getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public Rect getVideoRect() {
        return this.mVideoRect;
    }

    public float getVolume() {
        return this.mVolume;
    }

    public boolean isLooping() {
        return this.mLooping;
    }

    public PLVideoMixItem setDisplayMode(PLDisplayMode pLDisplayMode) {
        this.mDisplayMode = pLDisplayMode;
        return this;
    }

    public PLVideoMixItem setLooping(boolean z) {
        this.mLooping = z;
        return this;
    }

    public PLVideoMixItem setStartTimeMs(int i) {
        this.mStartTimeMs = i;
        return this;
    }

    public PLVideoMixItem setVideoPath(String str) {
        this.mVideoPath = str;
        return this;
    }

    public PLVideoMixItem setVideoRect(Rect rect) {
        this.mVideoRect = rect;
        return this;
    }

    public PLVideoMixItem setVolume(float f) {
        this.mVolume = f;
        return this;
    }
}
