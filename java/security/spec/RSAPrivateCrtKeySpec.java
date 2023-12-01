package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/RSAPrivateCrtKeySpec.class */
public class RSAPrivateCrtKeySpec extends RSAPrivateKeySpec {
    private final BigInteger crtCoefficient;
    private final BigInteger primeExponentP;
    private final BigInteger primeExponentQ;
    private final BigInteger primeP;
    private final BigInteger primeQ;
    private final BigInteger publicExponent;

    public RSAPrivateCrtKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(bigInteger, bigInteger3);
        this.publicExponent = bigInteger2;
        this.primeP = bigInteger4;
        this.primeQ = bigInteger5;
        this.primeExponentP = bigInteger6;
        this.primeExponentQ = bigInteger7;
        this.crtCoefficient = bigInteger8;
    }

    public BigInteger getCrtCoefficient() {
        return this.crtCoefficient;
    }

    public BigInteger getPrimeExponentP() {
        return this.primeExponentP;
    }

    public BigInteger getPrimeExponentQ() {
        return this.primeExponentQ;
    }

    public BigInteger getPrimeP() {
        return this.primeP;
    }

    public BigInteger getPrimeQ() {
        return this.primeQ;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}
