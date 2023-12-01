package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/GCMParameterSpec.class */
public class GCMParameterSpec implements AlgorithmParameterSpec {
    private final byte[] iv;
    private final int tagLen;

    public GCMParameterSpec(int i, byte[] bArr) {
        if (i < 0) {
            throw new IllegalArgumentException("tag should be a non-negative integer");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("iv == null");
        }
        this.tagLen = i;
        this.iv = (byte[]) bArr.clone();
    }

    public GCMParameterSpec(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            throw new IllegalArgumentException("tag should be a non-negative integer");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("iv == null");
        }
        try {
            Arrays.checkOffsetAndCount(bArr.length, i2, i3);
            this.tagLen = i;
            this.iv = Arrays.copyOfRange(bArr, i2, i2 + i3);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public byte[] getIV() {
        return (byte[]) this.iv.clone();
    }

    public int getTLen() {
        return this.tagLen;
    }
}
