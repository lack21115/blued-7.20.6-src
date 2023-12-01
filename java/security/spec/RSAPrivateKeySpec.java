package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/RSAPrivateKeySpec.class */
public class RSAPrivateKeySpec implements KeySpec {
    private final BigInteger modulus;
    private final BigInteger privateExponent;

    public RSAPrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.modulus = bigInteger;
        this.privateExponent = bigInteger2;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }
}
