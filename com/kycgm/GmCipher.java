package com.kycgm;

/* loaded from: source-7994992-dex2jar.jar:com/kycgm/GmCipher.class */
public class GmCipher {
    static {
        System.loadLibrary("kycgm");
    }

    private GmCipher() {
        throw new UnsupportedOperationException();
    }

    public static native byte[] sm2Encrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] sm4CbcDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] sm4CbcEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
