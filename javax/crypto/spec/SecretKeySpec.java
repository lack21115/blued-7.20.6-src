package javax.crypto.spec;

import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/SecretKeySpec.class */
public class SecretKeySpec implements SecretKey, KeySpec, Serializable {
    private static final long serialVersionUID = 6577238317307289933L;
    private final String algorithm;
    private final byte[] key;

    public SecretKeySpec(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("key == null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("key.length == 0");
        }
        if (i2 < 0 || i < 0) {
            throw new ArrayIndexOutOfBoundsException("len < 0 || offset < 0");
        }
        if (bArr.length - i < i2) {
            throw new IllegalArgumentException("key too short");
        }
        if (str == null) {
            throw new IllegalArgumentException("algorithm == null");
        }
        this.algorithm = str;
        this.key = new byte[i2];
        System.arraycopy(bArr, i, this.key, 0, i2);
    }

    public SecretKeySpec(byte[] bArr, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("key == null");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("key.length == 0");
        }
        if (str == null) {
            throw new IllegalArgumentException("algorithm == null");
        }
        this.algorithm = str;
        this.key = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.key, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecretKeySpec) {
            SecretKeySpec secretKeySpec = (SecretKeySpec) obj;
            return this.algorithm.equalsIgnoreCase(secretKeySpec.algorithm) && Arrays.equals(this.key, secretKeySpec.key);
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] bArr = new byte[this.key.length];
        System.arraycopy(this.key, 0, bArr, 0, this.key.length);
        return bArr;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "RAW";
    }

    public int hashCode() {
        int length = this.algorithm.length();
        byte[] bArr = this.key;
        int length2 = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length2) {
                return length;
            }
            length += bArr[i2];
            i = i2 + 1;
        }
    }
}
