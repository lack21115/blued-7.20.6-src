package com.qiniu.pili.droid.shortvideo;

import android.graphics.Bitmap;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLWatermarkSetting.class */
public class PLWatermarkSetting {
    private int mAlpha = 255;
    private Bitmap mBitmap;
    private float mHeight;
    private int mResourceId;
    private float mWidth;
    private float mX;
    private float mY;

    public static PLWatermarkSetting fromSetting(PLWatermarkSetting pLWatermarkSetting) {
        PLWatermarkSetting pLWatermarkSetting2 = new PLWatermarkSetting();
        pLWatermarkSetting2.setAlpha(pLWatermarkSetting.mAlpha);
        pLWatermarkSetting2.setBitmap(pLWatermarkSetting.mBitmap);
        pLWatermarkSetting2.setPosition(pLWatermarkSetting.mX, pLWatermarkSetting.mY);
        pLWatermarkSetting2.setResourceId(pLWatermarkSetting.mResourceId);
        pLWatermarkSetting2.setSize(pLWatermarkSetting.mWidth, pLWatermarkSetting.mHeight);
        return pLWatermarkSetting2;
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public int getResourceId() {
        return this.mResourceId;
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

    public void setAlpha(int i) {
        if (i >= 0 && i <= 255) {
            this.mAlpha = i;
            return;
        }
        throw new IllegalArgumentException("alpha value should be [0...255]:" + i);
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setPosition(float f, float f2) {
        this.mX = f;
        this.mY = f2;
    }

    public void setResourceId(int i) {
        this.mResourceId = i;
    }

    public void setSize(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
    }
}
