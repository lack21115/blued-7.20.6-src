package java.security.spec;

import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/ECFieldF2m.class */
public class ECFieldF2m implements ECField {
    private static final int PPB_LEN = 5;
    private static final int PPB_MID_LEN = 3;
    private static final int TPB_LEN = 3;
    private static final int TPB_MID_LEN = 1;
    private final int[] ks;
    private final int m;
    private final BigInteger rp;

    public ECFieldF2m(int i) {
        this.m = i;
        if (this.m <= 0) {
            throw new IllegalArgumentException("m <= 0");
        }
        this.rp = null;
        this.ks = null;
    }

    public ECFieldF2m(int i, BigInteger bigInteger) {
        this.m = i;
        if (this.m <= 0) {
            throw new IllegalArgumentException("m <= 0");
        }
        this.rp = bigInteger;
        if (this.rp == null) {
            throw new NullPointerException("rp == null");
        }
        int bitCount = this.rp.bitCount();
        if (this.rp.bitLength() != i + 1 || ((bitCount != 3 && bitCount != 5) || !this.rp.testBit(0) || !this.rp.testBit(i))) {
            throw new IllegalArgumentException("rp is invalid");
        }
        this.ks = new int[bitCount - 2];
        BigInteger clearBit = bigInteger.clearBit(0);
        int length = this.ks.length;
        while (true) {
            int i2 = length - 1;
            if (i2 < 0) {
                return;
            }
            this.ks[i2] = clearBit.getLowestSetBit();
            clearBit = clearBit.clearBit(this.ks[i2]);
            length = i2;
        }
    }

    public ECFieldF2m(int i, int[] iArr) {
        boolean z;
        this.m = i;
        if (this.m <= 0) {
            throw new IllegalArgumentException("m <= 0");
        }
        this.ks = new int[iArr.length];
        System.arraycopy(iArr, 0, this.ks, 0, this.ks.length);
        if (this.ks.length != 1 && this.ks.length != 3) {
            throw new IllegalArgumentException("the length of ks is invalid");
        }
        int i2 = this.m;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            z = false;
            if (i4 < this.ks.length) {
                if (this.ks[i4] >= i2) {
                    z = true;
                    break;
                } else {
                    i2 = this.ks[i4];
                    i3 = i4 + 1;
                }
            } else {
                break;
            }
        }
        if (z || i2 < 1) {
            throw new IllegalArgumentException("ks is invalid");
        }
        BigInteger bit = BigInteger.ONE.setBit(this.m);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.ks.length) {
                this.rp = bit;
                return;
            } else {
                bit = bit.setBit(this.ks[i6]);
                i5 = i6 + 1;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ECFieldF2m) {
            ECFieldF2m eCFieldF2m = (ECFieldF2m) obj;
            if (this.m == eCFieldF2m.m) {
                return this.rp == null ? eCFieldF2m.rp == null : Arrays.equals(this.ks, eCFieldF2m.ks);
            }
            return false;
        }
        return false;
    }

    @Override // java.security.spec.ECField
    public int getFieldSize() {
        return this.m;
    }

    public int getM() {
        return this.m;
    }

    public int[] getMidTermsOfReductionPolynomial() {
        if (this.ks == null) {
            return null;
        }
        int[] iArr = new int[this.ks.length];
        System.arraycopy(this.ks, 0, iArr, 0, iArr.length);
        return iArr;
    }

    public BigInteger getReductionPolynomial() {
        return this.rp;
    }

    public int hashCode() {
        return this.rp == null ? this.m : this.m + this.rp.hashCode();
    }
}
