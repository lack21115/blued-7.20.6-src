package com.qiniu.pili.droid.beauty;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/beauty/JNIControl.class */
public class JNIControl {
    public static native int getOutputTexture();

    public static native void onSurfaceChanged(int i, int i2);

    public static native void onSurfaceCreated(Context context, int i);

    public static native void processThrough(long j, int i, int i2, int i3, int i4, int i5);

    public static native void reInit();

    public static native void setBeautify(float f);

    public static native void setCurrentDirection(int i);

    public static native void setGLES(int i);

    public static native void setIsPortraitDisplay(boolean z);

    public static native void setRedden(float f);

    public static native void setSurfaceTextureID(int i);

    public static native void setWhiten(float f);
}
