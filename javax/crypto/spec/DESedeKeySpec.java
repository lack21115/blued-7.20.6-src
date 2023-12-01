package javax.crypto.spec;

import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/DESedeKeySpec.class */
public class DESedeKeySpec implements KeySpec {
    public static final int DES_EDE_KEY_LEN = 24;
    private final byte[] key;

    public DESedeKeySpec(byte[] bArr) throws InvalidKeyException {
        if (bArr == null) {
            throw new NullPointerException("key == null");
        }
        if (bArr.length < 24) {
            throw new InvalidKeyException();
        }
        this.key = new byte[24];
        System.arraycopy(bArr, 0, this.key, 0, 24);
    }

    public DESedeKeySpec(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr == null) {
            throw new NullPointerException("key == null");
        }
        if (bArr.length - i < 24) {
            throw new InvalidKeyException();
        }
        this.key = new byte[24];
        System.arraycopy(bArr, i, this.key, 0, 24);
    }

    public static boolean isParityAdjusted(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length - i < 24) {
            throw new InvalidKeyException();
        }
        int i2 = i;
        while (true) {
            int i3 = i2;
            if (i3 >= i + 24) {
                return true;
            }
            byte b = bArr[i3];
            if ((((b & 1) + ((b & 2) >> 1) + ((b & 4) >> 2) + ((b & 8) >> 3) + ((b & 16) >> 4) + ((b & 32) >> 5) + ((b & 64) >> 6)) & 1) == ((b & 128) >> 7)) {
                return false;
            }
            i2 = i3 + 1;
        }
    }

    public byte[] getKey() {
        byte[] bArr = new byte[24];
        System.arraycopy(this.key, 0, bArr, 0, 24);
        return bArr;
    }
}
