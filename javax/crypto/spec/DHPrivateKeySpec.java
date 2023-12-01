package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/DHPrivateKeySpec.class */
public class DHPrivateKeySpec implements KeySpec {
    private final BigInteger g;
    private final BigInteger p;
    private final BigInteger x;

    public DHPrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.x = bigInteger;
        this.p = bigInteger2;
        this.g = bigInteger3;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getX() {
        return this.x;
    }
}
