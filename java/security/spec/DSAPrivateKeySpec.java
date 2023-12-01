package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/DSAPrivateKeySpec.class */
public class DSAPrivateKeySpec implements KeySpec {
    private final BigInteger g;
    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger x;

    public DSAPrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.x = bigInteger;
        this.p = bigInteger2;
        this.q = bigInteger3;
        this.g = bigInteger4;
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getX() {
        return this.x;
    }
}
