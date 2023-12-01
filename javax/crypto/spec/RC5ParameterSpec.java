package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/RC5ParameterSpec.class */
public class RC5ParameterSpec implements AlgorithmParameterSpec {
    private final byte[] iv;
    private final int rounds;
    private final int version;
    private final int wordSize;

    public RC5ParameterSpec(int i, int i2, int i3) {
        this.version = i;
        this.rounds = i2;
        this.wordSize = i3;
        this.iv = null;
    }

    public RC5ParameterSpec(int i, int i2, int i3, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("iv == null");
        }
        if (bArr.length < (i3 / 8) * 2) {
            throw new IllegalArgumentException("iv.length < 2 * (wordSize / 8)");
        }
        this.version = i;
        this.rounds = i2;
        this.wordSize = i3;
        this.iv = new byte[(i3 / 8) * 2];
        System.arraycopy(bArr, 0, this.iv, 0, (i3 / 8) * 2);
    }

    public RC5ParameterSpec(int i, int i2, int i3, byte[] bArr, int i4) {
        if (bArr == null) {
            throw new IllegalArgumentException("iv == null");
        }
        if (i4 < 0) {
            throw new ArrayIndexOutOfBoundsException("offset < 0: " + i4);
        }
        if (bArr.length - i4 < (i3 / 8) * 2) {
            throw new IllegalArgumentException("iv.length - offset < 2 * (wordSize / 8)");
        }
        this.version = i;
        this.rounds = i2;
        this.wordSize = i3;
        this.iv = new byte[((i3 / 8) * 2) + i4];
        System.arraycopy(bArr, i4, this.iv, 0, (i3 / 8) * 2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RC5ParameterSpec) {
            RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec) obj;
            return this.version == rC5ParameterSpec.version && this.rounds == rC5ParameterSpec.rounds && this.wordSize == rC5ParameterSpec.wordSize && Arrays.equals(this.iv, rC5ParameterSpec.iv);
        }
        return false;
    }

    public byte[] getIV() {
        if (this.iv == null) {
            return null;
        }
        byte[] bArr = new byte[this.iv.length];
        System.arraycopy(this.iv, 0, bArr, 0, this.iv.length);
        return bArr;
    }

    public int getRounds() {
        return this.rounds;
    }

    public int getVersion() {
        return this.version;
    }

    public int getWordSize() {
        return this.wordSize;
    }

    public int hashCode() {
        int i = this.version + this.rounds + this.wordSize;
        if (this.iv == null) {
            return i;
        }
        byte[] bArr = this.iv;
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return i;
            }
            i += bArr[i3] & 255;
            i2 = i3 + 1;
        }
    }
}
