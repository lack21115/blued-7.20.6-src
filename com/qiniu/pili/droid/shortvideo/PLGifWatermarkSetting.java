package com.qiniu.pili.droid.shortvideo;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLGifWatermarkSetting.class */
public class PLGifWatermarkSetting {
    private int mAlpha = 255;
    private long mDurationMs;
    private String mFilePath;
    private float mHeight;
    private int mRotation;
    private long mStartTimeMs;
    private float mWidth;
    private float mX;
    private float mY;

    public boolean equals(Object obj) {
        if (obj instanceof PLGifWatermarkSetting) {
            PLGifWatermarkSetting pLGifWatermarkSetting = (PLGifWatermarkSetting) obj;
            boolean z = false;
            if (this.mFilePath.equals(pLGifWatermarkSetting.getFilePath())) {
                z = false;
                if (this.mAlpha == pLGifWatermarkSetting.getAlpha()) {
                    z = false;
                    if (this.mX == pLGifWatermarkSetting.getX()) {
                        z = false;
                        if (this.mY == pLGifWatermarkSetting.getY()) {
                            z = false;
                            if (this.mWidth == pLGifWatermarkSetting.getWidth()) {
                                z = false;
                                if (this.mHeight == pLGifWatermarkSetting.getHeight()) {
                                    z = false;
                                    if (this.mStartTimeMs == pLGifWatermarkSetting.getStartTimeMs()) {
                                        z = false;
                                        if (this.mDurationMs == pLGifWatermarkSetting.getDurationMs()) {
                                            z = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public long getDurationMs() {
        return this.mDurationMs;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setAlpha(int i) {
        if (i >= 0 && i <= 255) {
            this.mAlpha = i;
            return;
        }
        throw new IllegalArgumentException("alpha value should be [0...255]:" + i);
    }

    public void setDisplayPeriod(long j, long j2) {
        this.mStartTimeMs = j;
        this.mDurationMs = j2;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public void setPosition(float f, float f2) {
        this.mX = f;
        this.mY = f2;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setSize(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
    }
}
