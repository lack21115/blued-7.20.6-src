package java.security.spec;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/EllipticCurve.class */
public class EllipticCurve {

    /* renamed from: a  reason: collision with root package name */
    private final BigInteger f42261a;
    private final BigInteger b;
    private final ECField field;
    private volatile int hash;
    private final byte[] seed;

    public EllipticCurve(ECField eCField, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCField, bigInteger, bigInteger2, null);
    }

    public EllipticCurve(ECField eCField, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.field = eCField;
        if (this.field == null) {
            throw new NullPointerException("field == null");
        }
        this.f42261a = bigInteger;
        if (this.f42261a == null) {
            throw new NullPointerException("a == null");
        }
        this.b = bigInteger2;
        if (this.b == null) {
            throw new NullPointerException("b == null");
        }
        if (bArr == null) {
            this.seed = null;
        } else {
            this.seed = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.seed, 0, this.seed.length);
        }
        if (this.field instanceof ECFieldFp) {
            BigInteger p = ((ECFieldFp) this.field).getP();
            if (this.f42261a.signum() < 0 || this.f42261a.compareTo(p) >= 0) {
                throw new IllegalArgumentException("the a is not in the field");
            }
            if (this.b.signum() < 0 || this.b.compareTo(p) >= 0) {
                throw new IllegalArgumentException("the b is not in the field");
            }
        } else if (this.field instanceof ECFieldF2m) {
            int fieldSize = this.field.getFieldSize();
            if (this.f42261a.bitLength() > fieldSize) {
                throw new IllegalArgumentException("the a is not in the field");
            }
            if (this.b.bitLength() > fieldSize) {
                throw new IllegalArgumentException("the b is not in the field");
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EllipticCurve) {
            EllipticCurve ellipticCurve = (EllipticCurve) obj;
            return this.field.equals(ellipticCurve.field) && this.f42261a.equals(ellipticCurve.f42261a) && this.b.equals(ellipticCurve.b) && Arrays.equals(this.seed, ellipticCurve.seed);
        }
        return false;
    }

    public BigInteger getA() {
        return this.f42261a;
    }

    public BigInteger getB() {
        return this.b;
    }

    public ECField getField() {
        return this.field;
    }

    public byte[] getSeed() {
        if (this.seed == null) {
            return null;
        }
        byte[] bArr = new byte[this.seed.length];
        System.arraycopy(this.seed, 0, bArr, 0, bArr.length);
        return bArr;
    }

    public int hashCode() {
        int i;
        if (this.hash == 0) {
            int hashCode = ((((this.field.hashCode() + 341) * 31) + this.f42261a.hashCode()) * 31) + this.b.hashCode();
            if (this.seed != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    i = hashCode;
                    if (i3 >= this.seed.length) {
                        break;
                    }
                    hashCode = (hashCode * 31) + this.seed[i3];
                    i2 = i3 + 1;
                }
            } else {
                i = hashCode * 31;
            }
            this.hash = i;
        }
        return this.hash;
    }
}
