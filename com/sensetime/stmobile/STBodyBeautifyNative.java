package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STRect;
import com.sensetime.stmobile.model.STYuvImage;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STBodyBeautifyNative.class */
public class STBodyBeautifyNative {
    private long nativeHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int authorize();

    public native int createInstance(String str, int i);

    public native int createInstanceFromAssetFile(String str, int i, AssetManager assetManager);

    public native int createInstanceFromHandle(int i, long j);

    public native int destroyInstance();

    public native void enableRender(boolean z);

    public native int enableSkipFrameDetect(boolean z);

    public native int enableSmoothOnChangeParam(boolean z);

    public native STHumanAction getBodyInfo();

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    public native void getProcessTime();

    public native int prepareGlResource();

    public native int processBufferInGLContext(byte[] bArr, int i, int i2, int i3, int i4, STRect sTRect, byte[] bArr2, int i5, STBodyBeautifyResult sTBodyBeautifyResult);

    public native int processTextureAndOutputBuffer(int i, byte[] bArr, int i2, int i3, int i4, int i5, STRect sTRect, int i6, byte[] bArr2, int i7, STBodyBeautifyResult sTBodyBeautifyResult);

    public native int processTextureEx(STYuvImage sTYuvImage, int i, int i2, int i3, int i4, int i5, STBodyBeautifyResult sTBodyBeautifyResult);

    public native int releaseGLResource(boolean z);

    public native void reset();

    public native int setBodyRefType(int i);

    public native void setInputSource(int i);

    public native int setParam(int i, float f);

    public native int setTextureFormat(int i);
}
