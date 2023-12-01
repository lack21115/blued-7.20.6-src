package com.qiniu.pili.droid.shortvideo;

import android.net.Uri;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLImageRotateSetting.class */
public class PLImageRotateSetting {
    private Uri mBackgroundImageUri;
    private Uri mRotateImageUri;
    private int mRotateImageWidth = 100;
    private int mRotateImageHeight = 100;
    private long mCircleTimeMs = 10000;

    public Uri getBackgroundImageUri() {
        return this.mBackgroundImageUri;
    }

    public long getCircleTimeMs() {
        return this.mCircleTimeMs;
    }

    public int getRotateImageHeight() {
        return this.mRotateImageHeight;
    }

    public Uri getRotateImageUri() {
        return this.mRotateImageUri;
    }

    public int getRotateImageWidth() {
        return this.mRotateImageWidth;
    }

    public PLImageRotateSetting setBackgroundImageUri(Uri uri) {
        this.mBackgroundImageUri = uri;
        return this;
    }

    public PLImageRotateSetting setCircleTimeMs(long j) {
        this.mCircleTimeMs = j;
        return this;
    }

    public PLImageRotateSetting setRotateImageHeight(int i) {
        this.mRotateImageHeight = i;
        return this;
    }

    public PLImageRotateSetting setRotateImageUri(Uri uri) {
        this.mRotateImageUri = uri;
        return this;
    }

    public PLImageRotateSetting setRotateImageWidth(int i) {
        this.mRotateImageWidth = i;
        return this;
    }
}
