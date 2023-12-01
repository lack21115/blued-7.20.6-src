package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/DHPublicKeySpec.class */
public class DHPublicKeySpec implements KeySpec {
    private final BigInteger g;
    private final BigInteger p;
    private final BigInteger y;

    public DHPublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.y = bigInteger;
        this.p = bigInteger2;
        this.g = bigInteger3;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getY() {
        return this.y;
    }
}
