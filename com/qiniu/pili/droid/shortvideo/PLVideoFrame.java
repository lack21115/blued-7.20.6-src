package com.qiniu.pili.droid.shortvideo;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoFrame.class */
public class PLVideoFrame {
    private byte[] mData;
    private a mDataFormat;
    private int mHeight;
    private boolean mIsKeyFrame;
    private int mRotation;
    private long mTimestampMs;
    private int mWidth;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoFrame$a.class */
    public enum a {
        ARGB_8888,
        RGB_565
    }

    public byte[] getData() {
        return this.mData;
    }

    public a getDataFormat() {
        return this.mDataFormat;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public long getTimestampMs() {
        return this.mTimestampMs;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isKeyFrame() {
        return this.mIsKeyFrame;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setDataFormat(a aVar) {
        this.mDataFormat = aVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setIsKeyFrame(boolean z) {
        this.mIsKeyFrame = z;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setTimestampMs(long j) {
        this.mTimestampMs = j;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public Bitmap toBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, this.mDataFormat == a.ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(this.mData));
        return createBitmap;
    }
}
