package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/RSAKeyGenParameterSpec.class */
public class RSAKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final BigInteger F0 = BigInteger.valueOf(3);
    public static final BigInteger F4 = BigInteger.valueOf(65537);
    private final int keysize;
    private final BigInteger publicExponent;

    public RSAKeyGenParameterSpec(int i, BigInteger bigInteger) {
        this.keysize = i;
        this.publicExponent = bigInteger;
    }

    public int getKeysize() {
        return this.keysize;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}
