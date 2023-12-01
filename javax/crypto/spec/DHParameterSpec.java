package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/spec/DHParameterSpec.class */
public class DHParameterSpec implements AlgorithmParameterSpec {
    private final BigInteger g;
    private final int l;
    private final BigInteger p;

    public DHParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.p = bigInteger;
        this.g = bigInteger2;
        this.l = 0;
    }

    public DHParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.p = bigInteger;
        this.g = bigInteger2;
        this.l = i;
    }

    public BigInteger getG() {
        return this.g;
    }

    public int getL() {
        return this.l;
    }

    public BigInteger getP() {
        return this.p;
    }
}
