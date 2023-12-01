package com.tencent.cloud.huiyansdkface.record;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/WeWrapMp4Jni.class */
public class WeWrapMp4Jni {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36058a = WeWrapMp4Jni.class.getSimpleName();
    private int b = 0;

    static {
        System.loadLibrary("weyuv");
        System.loadLibrary("weconvert");
    }

    private final native void NV21ToI420(byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3, byte[] bArr4);

    private final native void NV21ToNV12(byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3, byte[] bArr4);

    public void NV21ToTarget(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, byte[] bArr3, byte[] bArr4) {
        if (i3 != 39 && i3 != 2130706688) {
            switch (i3) {
                case 19:
                case 20:
                    NV21ToI420(bArr, bArr2, i, i2, i4, bArr3, bArr4);
                    return;
                case 21:
                    break;
                default:
                    return;
            }
        }
        NV21ToNV12(bArr, bArr2, i, i2, i4, bArr3, bArr4);
    }
}
