package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/RSAOtherPrimeInfo.class */
public class RSAOtherPrimeInfo {
    private final BigInteger crtCoefficient;
    private final BigInteger prime;
    private final BigInteger primeExponent;

    public RSAOtherPrimeInfo(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        if (bigInteger == null) {
            throw new NullPointerException("prime == null");
        }
        if (bigInteger2 == null) {
            throw new NullPointerException("primeExponent == null");
        }
        if (bigInteger3 == null) {
            throw new NullPointerException("crtCoefficient == null");
        }
        this.prime = bigInteger;
        this.primeExponent = bigInteger2;
        this.crtCoefficient = bigInteger3;
    }

    public final BigInteger getCrtCoefficient() {
        return this.crtCoefficient;
    }

    public final BigInteger getExponent() {
        return this.primeExponent;
    }

    public final BigInteger getPrime() {
        return this.prime;
    }
}
