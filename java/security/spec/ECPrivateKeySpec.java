package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/ECPrivateKeySpec.class */
public class ECPrivateKeySpec implements KeySpec {
    private final ECParameterSpec params;
    private final BigInteger s;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        this.s = bigInteger;
        this.params = eCParameterSpec;
        if (this.s == null) {
            throw new NullPointerException("s == null");
        }
        if (this.params == null) {
            throw new NullPointerException("params == null");
        }
    }

    public ECParameterSpec getParams() {
        return this.params;
    }

    public BigInteger getS() {
        return this.s;
    }
}
