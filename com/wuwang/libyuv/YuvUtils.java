package com.wuwang.libyuv;

/* loaded from: source-8829756-dex2jar.jar:com/wuwang/libyuv/YuvUtils.class */
public class YuvUtils {
    static {
        System.loadLibrary("DoggyYuv");
    }

    public static native void I420Scale(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5, boolean z);

    public static native void I420ToNV21(byte[] bArr, byte[] bArr2, int i, int i2, boolean z);

    public static native int I420ToRgba(int i, byte[] bArr, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7);

    public static native int I420ToRgba(int i, byte[] bArr, byte[] bArr2, int i2, int i3);

    public static native void NV21Scale(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5);

    public static native void NV21ToI420(byte[] bArr, byte[] bArr2, int i, int i2, boolean z);

    public static native void NV21ToI420Rotate(byte[] bArr, int i, int i2, byte[] bArr2, int i3, boolean z);

    public static native void RgbaScale(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, int i5);

    public static native int RgbaToI420(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int i4, int i5, int i6, int i7);

    public static native int RgbaToI420(int i, byte[] bArr, byte[] bArr2, int i2, int i3);
}
