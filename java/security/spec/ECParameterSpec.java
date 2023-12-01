package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/ECParameterSpec.class */
public class ECParameterSpec implements AlgorithmParameterSpec {
    private final int cofactor;
    private final EllipticCurve curve;
    private String curveName;
    private final ECPoint generator;
    private final BigInteger order;

    public ECParameterSpec(EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, int i) {
        this.curve = ellipticCurve;
        this.generator = eCPoint;
        this.order = bigInteger;
        this.cofactor = i;
        if (this.curve == null) {
            throw new NullPointerException("curve == null");
        }
        if (this.generator == null) {
            throw new NullPointerException("generator == null");
        }
        if (this.order == null) {
            throw new NullPointerException("order == null");
        }
        if (this.order.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("order <= 0");
        }
        if (this.cofactor <= 0) {
            throw new IllegalArgumentException("cofactor <= 0");
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public EllipticCurve getCurve() {
        return this.curve;
    }

    public String getCurveName() {
        return this.curveName;
    }

    public ECPoint getGenerator() {
        return this.generator;
    }

    public BigInteger getOrder() {
        return this.order;
    }

    public void setCurveName(String str) {
        this.curveName = str;
    }
}
