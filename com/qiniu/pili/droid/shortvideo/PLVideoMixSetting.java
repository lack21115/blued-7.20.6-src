package com.qiniu.pili.droid.shortvideo;

import android.graphics.Rect;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoMixSetting.class */
public class PLVideoMixSetting {
    private String mCameraRecodingCachePath;
    private Rect mCameraVideoRect;
    private boolean mIsCameraAboveSample;
    private PLDisplayMode mSampleDisplayMode;
    private String mSampleVideoPath;
    private Rect mSampleVideoRect;

    public PLVideoMixSetting(Rect rect, Rect rect2, String str, PLDisplayMode pLDisplayMode, String str2) {
        this(rect, rect2, str, pLDisplayMode, false, str2);
    }

    public PLVideoMixSetting(Rect rect, Rect rect2, String str, PLDisplayMode pLDisplayMode, boolean z, String str2) {
        this.mSampleDisplayMode = PLDisplayMode.FIT;
        this.mCameraVideoRect = rect;
        this.mSampleVideoRect = rect2;
        this.mSampleVideoPath = str;
        this.mCameraRecodingCachePath = str2;
        this.mSampleDisplayMode = pLDisplayMode;
        this.mIsCameraAboveSample = z;
    }

    public PLVideoMixSetting(Rect rect, Rect rect2, String str, String str2) {
        this(rect, rect2, str, PLDisplayMode.FIT, str2);
    }

    public String getCameraRecodingCachePath() {
        return this.mCameraRecodingCachePath;
    }

    public Rect getCameraVideoRect() {
        return this.mCameraVideoRect;
    }

    public PLDisplayMode getSampleDisplayMode() {
        return this.mSampleDisplayMode;
    }

    public String getSampleVideoPath() {
        return this.mSampleVideoPath;
    }

    public Rect getSampleVideoRect() {
        return this.mSampleVideoRect;
    }

    public boolean isCameraAboveSample() {
        return this.mIsCameraAboveSample;
    }
}
