package java.security.spec;

import java.math.BigInteger;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/ECPoint.class */
public class ECPoint {
    public static final ECPoint POINT_INFINITY = new ECPoint();
    private final BigInteger affineX;
    private final BigInteger affineY;

    private ECPoint() {
        this.affineX = null;
        this.affineY = null;
    }

    public ECPoint(BigInteger bigInteger, BigInteger bigInteger2) {
        this.affineX = bigInteger;
        if (this.affineX == null) {
            throw new NullPointerException("affineX == null");
        }
        this.affineY = bigInteger2;
        if (this.affineY == null) {
            throw new NullPointerException("affineY == null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ECPoint) {
            if (this.affineX == null) {
                return obj == POINT_INFINITY;
            }
            ECPoint eCPoint = (ECPoint) obj;
            return this.affineX.equals(eCPoint.affineX) && this.affineY.equals(eCPoint.affineY);
        }
        return false;
    }

    public BigInteger getAffineX() {
        return this.affineX;
    }

    public BigInteger getAffineY() {
        return this.affineY;
    }

    public int hashCode() {
        if (this.affineX != null) {
            return (this.affineX.hashCode() * 31) + this.affineY.hashCode();
        }
        return 11;
    }
}
