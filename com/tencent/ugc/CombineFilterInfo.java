package com.tencent.ugc;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/CombineFilterInfo.class */
public class CombineFilterInfo {
    private Bitmap mLeftBitmap;
    private float mLeftRatio;
    private float mLeftSpecialRatio;
    private Bitmap mRightBitmap;
    private float mRightSpecialRatio;

    public CombineFilterInfo() {
    }

    public CombineFilterInfo(float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        this.mLeftRatio = f;
        this.mLeftBitmap = bitmap;
        this.mRightBitmap = bitmap2;
        this.mLeftSpecialRatio = f2;
        this.mRightSpecialRatio = f3;
    }

    public Bitmap getLeftBitmap() {
        return this.mLeftBitmap;
    }

    public float getLeftRatio() {
        return this.mLeftRatio;
    }

    public float getLeftSpecialRatio() {
        return this.mLeftSpecialRatio;
    }

    public Bitmap getRightBitmap() {
        return this.mRightBitmap;
    }

    public float getRightSpecialRatio() {
        return this.mRightSpecialRatio;
    }

    public void release() {
        Bitmap bitmap = this.mLeftBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mLeftBitmap.recycle();
            this.mLeftBitmap = null;
        }
        Bitmap bitmap2 = this.mRightBitmap;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.mRightBitmap.recycle();
        this.mRightBitmap = null;
    }

    public void setLeftBitmap(Bitmap bitmap) {
        this.mLeftBitmap = bitmap;
    }

    public void setLeftRatio(float f) {
        this.mLeftRatio = f;
    }

    public void setLeftSpecialRatio(float f) {
        this.mLeftSpecialRatio = f;
    }

    public void setRightBitmap(Bitmap bitmap) {
        this.mRightBitmap = bitmap;
    }

    public void setRightSpecialRatio(float f) {
        this.mRightSpecialRatio = f;
    }
}
