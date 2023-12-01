package android.media;

import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaCrypto.class */
public final class MediaCrypto {
    private long mNativeContext;

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    public MediaCrypto(UUID uuid, byte[] bArr) throws MediaCryptoException {
        native_setup(getByteArrayFromUUID(uuid), bArr);
    }

    private static final byte[] getByteArrayFromUUID(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return bArr;
            }
            bArr[i2] = (byte) (mostSignificantBits >>> ((7 - i2) * 8));
            bArr[i2 + 8] = (byte) (leastSignificantBits >>> ((7 - i2) * 8));
            i = i2 + 1;
        }
    }

    public static final boolean isCryptoSchemeSupported(UUID uuid) {
        return isCryptoSchemeSupportedNative(getByteArrayFromUUID(uuid));
    }

    private static final native boolean isCryptoSchemeSupportedNative(byte[] bArr);

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(byte[] bArr, byte[] bArr2) throws MediaCryptoException;

    protected void finalize() {
        native_finalize();
    }

    public final native void release();

    public final native boolean requiresSecureDecoderComponent(String str);
}
