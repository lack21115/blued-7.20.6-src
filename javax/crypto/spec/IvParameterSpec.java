package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/IvParameterSpec.class */
public class IvParameterSpec implements AlgorithmParameterSpec {
    private final byte[] iv;

    public IvParameterSpec(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("iv == null");
        }
        this.iv = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.iv, 0, bArr.length);
    }

    public IvParameterSpec(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length - i < i2) {
            throw new IllegalArgumentException();
        }
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        this.iv = new byte[i2];
        System.arraycopy(bArr, i, this.iv, 0, i2);
    }

    public byte[] getIV() {
        byte[] bArr = new byte[this.iv.length];
        System.arraycopy(this.iv, 0, bArr, 0, this.iv.length);
        return bArr;
    }
}
