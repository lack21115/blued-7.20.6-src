package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/ECFieldFp.class */
public class ECFieldFp implements ECField {
    private final BigInteger p;

    public ECFieldFp(BigInteger bigInteger) {
        this.p = bigInteger;
        if (this.p == null) {
            throw new NullPointerException("p == null");
        }
        if (this.p.signum() != 1) {
            throw new IllegalArgumentException("p <= 0");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ECFieldFp) {
            return this.p.equals(((ECFieldFp) obj).p);
        }
        return false;
    }

    @Override // java.security.spec.ECField
    public int getFieldSize() {
        return this.p.bitLength();
    }

    public BigInteger getP() {
        return this.p;
    }

    public int hashCode() {
        return this.p.hashCode();
    }
}
