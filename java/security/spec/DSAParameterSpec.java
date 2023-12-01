package java.security.spec;

import java.math.BigInteger;
import java.security.interfaces.DSAParams;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/DSAParameterSpec.class */
public class DSAParameterSpec implements AlgorithmParameterSpec, DSAParams {
    private final BigInteger g;
    private final BigInteger p;
    private final BigInteger q;

    public DSAParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.p = bigInteger;
        this.q = bigInteger2;
        this.g = bigInteger3;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getG() {
        return this.g;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getP() {
        return this.p;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getQ() {
        return this.q;
    }
}
