package com.tencent.liteav.beauty;

import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/NativeLoad.class */
public class NativeLoad {
    public static final int PROGRAM_BEAUTY = 1;
    public static final int PROGRAM_BEAUTY2 = 5;
    public static final int PROGRAM_BEAUTY2_SAMSUNG_S4 = 15;
    public static final int PROGRAM_BEAUTY3_FILTER = 14;
    public static final int PROGRAM_BEAUTYBLEND = 12;
    public static final int PROGRAM_EYE_SCALE = 3;
    public static final int PROGRAM_FACE_SLIM = 4;
    public static final int PROGRAM_FACE_VAR = 2;
    public static final int PROGRAM_I4202RGBA = 7;
    public static final int PROGRAM_NV122RGBA = 10;
    public static final int PROGRAM_NV212RGBA = 9;
    public static final int PROGRAM_RGBA2I420 = 8;
    public static final int PROGRAM_RGBA2NV21 = 11;
    public static final int PROGRAM_SKIN = 6;
    public static final int PROGRAM_SMOOTHHORIZONTAL = 13;
    private static final String TAG = "NativeLoad";

    static {
        onLoadBeauty();
        LiteavLog.i(TAG, "loaded liteav library");
    }

    public static native void nativeClearQueue();

    public static native void nativeDeleteYuv2Yuv();

    public static native void nativeGlMapBufferToQueue(int i, int i2, ByteBuffer byteBuffer);

    public static native void nativeGlReadPixs(int i, int i2, byte[] bArr);

    public static native boolean nativeGlReadPixsFromQueue(int i, int i2, byte[] bArr);

    public static native void nativeGlReadPixsToQueue(int i, int i2);

    public static native int nativeLoadGLProgram(int i);

    public static native void nativeglTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr, int i9);

    public static native void onLoadBeauty();
}
