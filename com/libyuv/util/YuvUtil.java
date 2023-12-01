package com.libyuv.util;

/* loaded from: source-7994992-dex2jar.jar:com/libyuv/util/YuvUtil.class */
public class YuvUtil {
    static {
        System.loadLibrary("yuvutil");
    }

    public static native void compressYUV(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, boolean z);

    public static native void cropYUV(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, int i6);

    public static native String getBoot();

    public static native String getUpdate();

    public static native void init(int i, int i2, int i3, int i4);

    public static native void yuvI420ToNV21(byte[] bArr, byte[] bArr2, int i, int i2);
}
