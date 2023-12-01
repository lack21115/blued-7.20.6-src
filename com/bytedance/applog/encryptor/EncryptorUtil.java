package com.bytedance.applog.encryptor;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/encryptor/EncryptorUtil.class */
public class EncryptorUtil {
    static {
        try {
            System.loadLibrary("EncryptorP");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(byte[] bArr, int i) {
        if (bArr == null || i <= 0) {
            return null;
        }
        try {
            if (bArr.length != i) {
                return null;
            }
            return ttEncrypt(bArr, i);
        } catch (Throwable th) {
            return null;
        }
    }

    private static native byte[] ttEncrypt(byte[] bArr, int i);
}
