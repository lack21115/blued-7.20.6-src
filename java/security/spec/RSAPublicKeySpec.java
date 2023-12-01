package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/RSAPublicKeySpec.class */
public class RSAPublicKeySpec implements KeySpec {
    private final BigInteger modulus;
    private final BigInteger publicExponent;

    public RSAPublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.publicExponent = bigInteger2;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}
