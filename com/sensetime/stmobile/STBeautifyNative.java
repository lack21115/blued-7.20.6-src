package com.sensetime.stmobile;

import com.sensetime.stmobile.model.STHumanAction;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STBeautifyNative.class */
public class STBeautifyNative {
    private long nativeBeautyOutHumanActionPtr;
    private long nativeHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int createInstance();

    public native void destroyBeautify();

    public native long getDetectConfig();

    public long getNativeBeautyOutHumanActionPtr() {
        return this.nativeBeautyOutHumanActionPtr;
    }

    public native int processBuffer(byte[] bArr, int i, int i2, int i3, int i4, STHumanAction sTHumanAction, byte[] bArr2, int i5, STHumanAction sTHumanAction2);

    public native int processBufferNative(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, long j);

    public native int processPicture(byte[] bArr, int i, int i2, int i3, int i4, STHumanAction sTHumanAction, byte[] bArr2, int i5, STHumanAction sTHumanAction2);

    public native int processPictureNative(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, long j);

    public native int processTexture(int i, int i2, int i3, int i4, STHumanAction sTHumanAction, int i5, STHumanAction sTHumanAction2);

    public native int processTextureAndOutputBuffer(int i, int i2, int i3, int i4, STHumanAction sTHumanAction, int i5, byte[] bArr, int i6, STHumanAction sTHumanAction2);

    public native int processTextureAndOutputBufferNative(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, long j);

    public native int processTextureNative(int i, int i2, int i3, int i4, int i5, long j);

    public native int setParam(int i, float f);
}
