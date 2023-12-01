package com.sensetime.stmobile;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/STMobileColorConvertNative.class */
public class STMobileColorConvertNative {
    private long colorConvertNativeHandle;

    static {
        System.loadLibrary("st_mobile");
        System.loadLibrary("stmobile_jni");
    }

    public native int createInstance();

    public native void destroyInstance();

    public native int nv12BufferToRgbaTexture(int i, int i2, int i3, boolean z, byte[] bArr, int i4);

    public native int nv21BufferToRgbaTexture(int i, int i2, int i3, boolean z, byte[] bArr, int i4);

    public native int rgbaTextureToGray8Buffer(int i, int i2, int i3, byte[] bArr);

    public native int rgbaTextureToNv12Buffer(int i, int i2, int i3, byte[] bArr);

    public native int rgbaTextureToNv21Buffer(int i, int i2, int i3, byte[] bArr);

    public native int setTextureSize(int i, int i2);
}
