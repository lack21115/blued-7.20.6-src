package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/RSAMultiPrimePrivateCrtKeySpec.class */
public class RSAMultiPrimePrivateCrtKeySpec extends RSAPrivateKeySpec {
    private final BigInteger crtCoefficient;
    private final RSAOtherPrimeInfo[] otherPrimeInfo;
    private final BigInteger primeExponentP;
    private final BigInteger primeExponentQ;
    private final BigInteger primeP;
    private final BigInteger primeQ;
    private final BigInteger publicExponent;

    public RSAMultiPrimePrivateCrtKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8, RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr) {
        super(bigInteger, bigInteger3);
        if (bigInteger == null) {
            throw new NullPointerException("modulus == null");
        }
        if (bigInteger3 == null) {
            throw new NullPointerException("privateExponent == null");
        }
        if (bigInteger2 == null) {
            throw new NullPointerException("publicExponent == null");
        }
        if (bigInteger4 == null) {
            throw new NullPointerException("primeP == null");
        }
        if (bigInteger5 == null) {
            throw new NullPointerException("primeQ == null");
        }
        if (bigInteger6 == null) {
            throw new NullPointerException("primeExponentP == null");
        }
        if (bigInteger7 == null) {
            throw new NullPointerException("primeExponentQ == null");
        }
        if (bigInteger8 == null) {
            throw new NullPointerException("crtCoefficient == null");
        }
        if (rSAOtherPrimeInfoArr == null) {
            this.otherPrimeInfo = null;
        } else if (rSAOtherPrimeInfoArr.length == 0) {
            throw new IllegalArgumentException("otherPrimeInfo.length == 0");
        } else {
            this.otherPrimeInfo = new RSAOtherPrimeInfo[rSAOtherPrimeInfoArr.length];
            System.arraycopy(rSAOtherPrimeInfoArr, 0, this.otherPrimeInfo, 0, this.otherPrimeInfo.length);
        }
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

    public RSAOtherPrimeInfo[] getOtherPrimeInfo() {
        if (this.otherPrimeInfo == null) {
            return null;
        }
        RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr = new RSAOtherPrimeInfo[this.otherPrimeInfo.length];
        System.arraycopy(this.otherPrimeInfo, 0, rSAOtherPrimeInfoArr, 0, rSAOtherPrimeInfoArr.length);
        return rSAOtherPrimeInfoArr;
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
