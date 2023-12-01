package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/PBEParameterSpec.class */
public class PBEParameterSpec implements AlgorithmParameterSpec {
    private final int iterationCount;
    private final byte[] salt;

    public PBEParameterSpec(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("salt == null");
        }
        this.salt = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.salt, 0, bArr.length);
        this.iterationCount = i;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getSalt() {
        byte[] bArr = new byte[this.salt.length];
        System.arraycopy(this.salt, 0, bArr, 0, this.salt.length);
        return bArr;
    }
}
