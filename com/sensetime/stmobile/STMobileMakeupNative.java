package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STImage;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileMakeupNative.class */
public class STMobileMakeupNative {
    private long nativeMakeupHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int addMakeupForType(int i, String str);

    public native int addMakeupForTypeFromAssetsFile(int i, String str, AssetManager assetManager);

    public native void clearMakeups();

    public native int createInstance();

    public native int destroyInstance();

    public native long getTriggerAction();

    public native int prepare(byte[] bArr, int i, int i2, int i3, STHumanAction sTHumanAction);

    public native int processTexture(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5);

    public native int processTextureAndOutputBuffer(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, int i6, byte[] bArr);

    public native int processTextureAndOutputBufferNative(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr);

    public native int processTextureNative(int i, long j, int i2, int i3, int i4, int i5);

    public native int removeMakeup(int i);

    public native int setMakeupForType(int i, String str);

    public native int setMakeupForTypeFromAssetsFile(int i, String str, AssetManager assetManager);

    public native int setPerformanceHint(int i);

    public native void setResourceForType(int i, int i2, STImage sTImage);

    public native void setSmoothStrengthForType(int i, float f);

    public native void setStrengthForType(int i, float f);

    public native int updateInternalMask(STHumanAction sTHumanAction, STHumanAction sTHumanAction2, int i, int i2, int i3);

    public native int updateInternalMaskNative(long j, long j2, int i, int i2, int i3);
}
