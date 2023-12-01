package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/RC2ParameterSpec.class */
public class RC2ParameterSpec implements AlgorithmParameterSpec {
    private final int effectiveKeyBits;
    private final byte[] iv;

    public RC2ParameterSpec(int i) {
        this.effectiveKeyBits = i;
        this.iv = null;
    }

    public RC2ParameterSpec(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("iv == null");
        }
        if (bArr.length < 8) {
            throw new IllegalArgumentException("iv.length < 8");
        }
        this.effectiveKeyBits = i;
        this.iv = new byte[8];
        System.arraycopy(bArr, 0, this.iv, 0, 8);
    }

    public RC2ParameterSpec(int i, byte[] bArr, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("iv == null");
        }
        if (bArr.length - i2 < 8) {
            throw new IllegalArgumentException("iv.length - offset < 8");
        }
        this.effectiveKeyBits = i;
        this.iv = new byte[8];
        System.arraycopy(bArr, i2, this.iv, 0, 8);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RC2ParameterSpec) {
            RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) obj;
            return this.effectiveKeyBits == rC2ParameterSpec.effectiveKeyBits && Arrays.equals(this.iv, rC2ParameterSpec.iv);
        }
        return false;
    }

    public int getEffectiveKeyBits() {
        return this.effectiveKeyBits;
    }

    public byte[] getIV() {
        if (this.iv == null) {
            return null;
        }
        byte[] bArr = new byte[this.iv.length];
        System.arraycopy(this.iv, 0, bArr, 0, this.iv.length);
        return bArr;
    }

    public int hashCode() {
        int i = this.effectiveKeyBits;
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
            i += bArr[i3];
            i2 = i3 + 1;
        }
    }
}
