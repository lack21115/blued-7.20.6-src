package javax.crypto.spec;

import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/DESKeySpec.class */
public class DESKeySpec implements KeySpec {
    public static final int DES_KEY_LEN = 8;
    private static final byte[][] SEMIWEAKS = {new byte[]{-32, 1, -32, 1, -15, 1, -15, 1}, new byte[]{1, -32, 1, -32, 1, -15, 1, -15}, new byte[]{-2, 31, -2, 31, -2, 14, -2, 14}, new byte[]{31, -2, 31, -2, 14, -2, 14, -2}, new byte[]{-32, 31, -32, 31, -15, 14, -15, 14}, new byte[]{31, -32, 31, -32, 14, -15, 14, -15}, new byte[]{1, -2, 1, -2, 1, -2, 1, -2}, new byte[]{-2, 1, -2, 1, -2, 1, -2, 1}, new byte[]{1, 31, 1, 31, 1, 14, 1, 14}, new byte[]{31, 1, 31, 1, 14, 1, 14, 1}, new byte[]{-32, -2, -32, -2, -15, -2, -15, -2}, new byte[]{-2, -32, -2, -32, -2, -15, -2, -15}, new byte[]{1, 1, 1, 1, 1, 1, 1, 1}, new byte[]{-2, -2, -2, -2, -2, -2, -2, -2}, new byte[]{-32, -32, -32, -32, -15, -15, -15, -15}, new byte[]{31, 31, 31, 31, 14, 14, 14, 14}};
    private final byte[] key;

    public DESKeySpec(byte[] bArr) throws InvalidKeyException {
        this(bArr, 0);
    }

    public DESKeySpec(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr == null) {
            throw new NullPointerException("key == null");
        }
        if (bArr.length - i < 8) {
            throw new InvalidKeyException("key too short");
        }
        this.key = new byte[8];
        System.arraycopy(bArr, i, this.key, 0, 8);
    }

    public static boolean isParityAdjusted(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr == null) {
            throw new InvalidKeyException("key == null");
        }
        if (bArr.length - i < 8) {
            throw new InvalidKeyException("key too short");
        }
        while (i < 8) {
            byte b = bArr[i];
            int i2 = b ^ (b >> 1);
            int i3 = i2 ^ (i2 >> 2);
            if (((i3 ^ (i3 >> 4)) & 1) == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isWeak(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr == null) {
            throw new InvalidKeyException("key == null");
        }
        if (bArr.length - i < 8) {
            throw new InvalidKeyException("key too short");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= SEMIWEAKS.length) {
                return false;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 8) {
                    return true;
                }
                if (SEMIWEAKS[i3][i5] != bArr[i + i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
            i2 = i3 + 1;
        }
    }

    public byte[] getKey() {
        byte[] bArr = new byte[8];
        System.arraycopy(this.key, 0, bArr, 0, 8);
        return bArr;
    }
}
