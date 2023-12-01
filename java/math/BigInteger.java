package java.math;

import android.widget.ExpandableListView;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

/* loaded from: source-2895416-dex2jar.jar:java/math/BigInteger.class */
public class BigInteger extends Number implements Comparable<BigInteger>, Serializable {
    private static final long serialVersionUID = -8287574255936472291L;
    private transient BigInt bigInt;
    transient int[] digits;
    private transient int firstNonzeroDigit;
    private transient int hashCode;
    private transient boolean javaIsValid;
    private byte[] magnitude;
    private transient boolean nativeIsValid;
    transient int numberLength;
    transient int sign;
    private int signum;
    public static final BigInteger ZERO = new BigInteger(0, 0);
    public static final BigInteger ONE = new BigInteger(1, 1);
    public static final BigInteger TEN = new BigInteger(1, 10);
    static final BigInteger MINUS_ONE = new BigInteger(-1, 1);
    static final BigInteger[] SMALL_VALUES = {ZERO, ONE, new BigInteger(1, 2), new BigInteger(1, 3), new BigInteger(1, 4), new BigInteger(1, 5), new BigInteger(1, 6), new BigInteger(1, 7), new BigInteger(1, 8), new BigInteger(1, 9), TEN};

    public BigInteger(int i, int i2, Random random) {
        int i3;
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        if (i < 2) {
            throw new ArithmeticException("bitLength < 2: " + i);
        }
        if (i >= 16) {
            do {
                setBigInt(BigInt.generatePrimeDefault(i));
            } while (bitLength() != i);
            return;
        }
        do {
            int nextInt = (random.nextInt() & ((1 << i) - 1)) | (1 << (i - 1));
            i3 = i > 2 ? nextInt | 1 : nextInt;
        } while (!isSmallPrime(i3));
        BigInt bigInt = new BigInt();
        bigInt.putULongInt(i3, false);
        setBigInt(bigInt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger(int i, int i2, int[] iArr) {
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        setJavaRepresentation(i, i2, iArr);
    }

    BigInteger(int i, long j) {
        boolean z = false;
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        BigInt bigInt = new BigInt();
        bigInt.putULongInt(j, i < 0 ? true : z);
        setBigInt(bigInt);
    }

    public BigInteger(int i, Random random) {
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        if (i < 0) {
            throw new IllegalArgumentException("numBits < 0: " + i);
        }
        if (i == 0) {
            setJavaRepresentation(0, 1, new int[]{0});
        } else {
            int i2 = (i + 31) >> 5;
            int[] iArr = new int[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    break;
                }
                iArr[i4] = random.nextInt();
                i3 = i4 + 1;
            }
            int i5 = i2 - 1;
            iArr[i5] = iArr[i5] >>> ((-i) & 31);
            setJavaRepresentation(1, i2, iArr);
        }
        this.javaIsValid = true;
    }

    public BigInteger(int i, byte[] bArr) {
        boolean z = true;
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        if (bArr == null) {
            throw new NullPointerException("magnitude == null");
        }
        if (i < -1 || i > 1) {
            throw new NumberFormatException("Invalid signum: " + i);
        }
        if (i == 0) {
            int length = bArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                } else if (bArr[i3] != 0) {
                    throw new NumberFormatException("signum-magnitude mismatch");
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(bArr, i >= 0 ? false : z);
        setBigInt(bigInt);
    }

    public BigInteger(String str) {
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        BigInt bigInt = new BigInt();
        bigInt.putDecString(str);
        setBigInt(bigInt);
    }

    public BigInteger(String str, int i) {
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        if (i == 10) {
            BigInt bigInt = new BigInt();
            bigInt.putDecString(str);
            setBigInt(bigInt);
        } else if (i == 16) {
            BigInt bigInt2 = new BigInt();
            bigInt2.putHexString(str);
            setBigInt(bigInt2);
        } else if (i < 2 || i > 36) {
            throw new NumberFormatException("Invalid radix: " + i);
        } else {
            if (str.isEmpty()) {
                throw new NumberFormatException("value.isEmpty()");
            }
            parseFromString(this, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger(BigInt bigInt) {
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        if (bigInt == null || bigInt.getNativeBIGNUM() == 0) {
            throw new AssertionError();
        }
        setBigInt(bigInt);
    }

    public BigInteger(byte[] bArr) {
        this.nativeIsValid = false;
        this.javaIsValid = false;
        this.firstNonzeroDigit = -2;
        this.hashCode = 0;
        if (bArr.length == 0) {
            throw new NumberFormatException("value.length == 0");
        }
        BigInt bigInt = new BigInt();
        bigInt.putBigEndianTwosComplement(bArr);
        setBigInt(bigInt);
    }

    static int inplaceAdd(int[] iArr, int i, int i2) {
        long j = i2 & ExpandableListView.PACKED_POSITION_VALUE_NULL;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (j == 0 || i4 >= i) {
                break;
            }
            long j2 = j + (iArr[i4] & ExpandableListView.PACKED_POSITION_VALUE_NULL);
            iArr[i4] = (int) j2;
            j = j2 >> 32;
            i3 = i4 + 1;
        }
        return (int) j;
    }

    private static boolean isSmallPrime(int i) {
        if (i == 2) {
            return true;
        }
        if (i % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(i);
        int i2 = 3;
        while (true) {
            int i3 = i2;
            if (i3 > sqrt) {
                return true;
            }
            if (i % i3 == 0) {
                return false;
            }
            i2 = i3 + 2;
        }
    }

    static int multiplyByInt(int[] iArr, int[] iArr2, int i, int i2) {
        long j = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return (int) j;
            }
            long j2 = j + ((iArr2[i4] & ExpandableListView.PACKED_POSITION_VALUE_NULL) * (i2 & ExpandableListView.PACKED_POSITION_VALUE_NULL));
            iArr[i4] = (int) j2;
            j = j2 >>> 32;
            i3 = i4 + 1;
        }
    }

    private static void parseFromString(BigInteger bigInteger, String str, int i) {
        int i2;
        int i3;
        int i4;
        int length = str.length();
        if (str.charAt(0) == '-') {
            i2 = -1;
            i3 = 1;
            i4 = length - 1;
        } else {
            i2 = 1;
            i3 = 0;
            i4 = length;
        }
        int i5 = Conversion.digitFitInInt[i];
        int i6 = i4 / i5;
        int i7 = i4 % i5;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + 1;
        }
        int[] iArr = new int[i8];
        int i9 = Conversion.bigRadices[i - 2];
        int i10 = i7;
        if (i7 == 0) {
            i10 = i5;
        }
        int i11 = i3;
        int i12 = i3 + i10;
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i11 >= length) {
                bigInteger.setJavaRepresentation(i2, i14, iArr);
                return;
            }
            iArr[i14] = multiplyByInt(iArr, iArr, i14, i9) + inplaceAdd(iArr, i14, Integer.parseInt(str.substring(i11, i12), i));
            i11 = i12;
            i12 = i11 + i5;
            i13 = i14 + 1;
        }
    }

    public static BigInteger probablePrime(int i, Random random) {
        return new BigInteger(i, 100, random);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        BigInt bigInt = new BigInt();
        bigInt.putBigEndian(this.magnitude, this.signum < 0);
        setBigInt(bigInt);
    }

    private void setBigInt(BigInt bigInt) {
        this.bigInt = bigInt;
        this.nativeIsValid = true;
    }

    private void setJavaRepresentation(int i, int i2, int[] iArr) {
        int i3;
        do {
            i3 = i2;
            if (i2 <= 0) {
                break;
            }
            i3 = i2 - 1;
            i2 = i3;
        } while (iArr[i3] == 0);
        if (iArr[i3] == 0) {
            i = 0;
        }
        this.sign = i;
        this.digits = iArr;
        this.numberLength = i3 + 1;
        this.javaIsValid = true;
    }

    private byte[] twosComplement() {
        int i;
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        prepareJavaRepresentation();
        if (this.sign != 0) {
            int bitLength = bitLength();
            int firstNonzeroDigit = getFirstNonzeroDigit();
            int i5 = (bitLength >> 3) + 1;
            byte[] bArr2 = new byte[i5];
            int i6 = 0;
            int i7 = 4;
            if (i5 - (this.numberLength << 2) == 1) {
                bArr2[0] = (byte) (this.sign < 0 ? -1 : 0);
                i = 4;
                i6 = 0 + 1;
            } else {
                i = i5 & 3;
                if (i == 0) {
                    i = 4;
                }
            }
            int i8 = i5 - (firstNonzeroDigit << 2);
            int i9 = 4;
            int i10 = i8;
            int i11 = firstNonzeroDigit;
            if (this.sign < 0) {
                int i12 = -this.digits[firstNonzeroDigit];
                int i13 = firstNonzeroDigit + 1;
                if (i13 == this.numberLength) {
                    i7 = i;
                }
                int i14 = 0;
                int i15 = i12;
                int i16 = i8;
                while (true) {
                    i2 = i7;
                    i3 = i16;
                    i4 = i13;
                    if (i14 >= i7) {
                        break;
                    }
                    i16--;
                    bArr2[i16] = (byte) i15;
                    i14++;
                    i15 >>= 8;
                }
                while (true) {
                    bArr = bArr2;
                    if (i3 <= i6) {
                        break;
                    }
                    int i17 = this.digits[i4] ^ (-1);
                    int i18 = i4 + 1;
                    int i19 = i2;
                    if (i18 == this.numberLength) {
                        i19 = i;
                    }
                    int i20 = 0;
                    int i21 = i3;
                    while (true) {
                        i2 = i19;
                        i3 = i21;
                        i4 = i18;
                        if (i20 < i19) {
                            i21--;
                            bArr2[i21] = (byte) i17;
                            i20++;
                            i17 >>= 8;
                        }
                    }
                }
            }
            while (true) {
                bArr = bArr2;
                if (i10 <= i6) {
                    break;
                }
                int i22 = this.digits[i11];
                int i23 = i11 + 1;
                int i24 = i9;
                if (i23 == this.numberLength) {
                    i24 = i;
                }
                int i25 = 0;
                int i26 = i10;
                while (true) {
                    i9 = i24;
                    i10 = i26;
                    i11 = i23;
                    if (i25 < i24) {
                        i26--;
                        bArr2[i26] = (byte) i22;
                        i25++;
                        i22 >>= 8;
                    }
                }
            }
        } else {
            bArr = new byte[]{0};
        }
        return bArr;
    }

    public static BigInteger valueOf(long j) {
        return j < 0 ? j != -1 ? new BigInteger(-1, -j) : MINUS_ONE : j < ((long) SMALL_VALUES.length) ? SMALL_VALUES[(int) j] : new BigInteger(1, j);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        BigInt bigInt = getBigInt();
        this.signum = bigInt.sign();
        this.magnitude = bigInt.bigEndianMagnitude();
        objectOutputStream.defaultWriteObject();
    }

    public BigInteger abs() {
        BigInt bigInt = getBigInt();
        if (bigInt.sign() >= 0) {
            return this;
        }
        BigInt copy = bigInt.copy();
        copy.setSign(1);
        return new BigInteger(copy);
    }

    public BigInteger add(BigInteger bigInteger) {
        BigInt bigInt = getBigInt();
        BigInt bigInt2 = bigInteger.getBigInt();
        return bigInt2.sign() == 0 ? this : bigInt.sign() == 0 ? bigInteger : new BigInteger(BigInt.addition(bigInt, bigInt2));
    }

    public BigInteger and(BigInteger bigInteger) {
        prepareJavaRepresentation();
        bigInteger.prepareJavaRepresentation();
        return Logical.and(this, bigInteger);
    }

    public BigInteger andNot(BigInteger bigInteger) {
        prepareJavaRepresentation();
        bigInteger.prepareJavaRepresentation();
        return Logical.andNot(this, bigInteger);
    }

    public int bitCount() {
        prepareJavaRepresentation();
        return BitLevel.bitCount(this);
    }

    public int bitLength() {
        return (this.nativeIsValid || !this.javaIsValid) ? getBigInt().bitLength() : BitLevel.bitLength(this);
    }

    public BigInteger clearBit(int i) {
        prepareJavaRepresentation();
        BigInteger bigInteger = this;
        if (testBit(i)) {
            bigInteger = BitLevel.flipBit(this, i);
        }
        return bigInteger;
    }

    @Override // java.lang.Comparable
    public int compareTo(BigInteger bigInteger) {
        return BigInt.cmp(getBigInt(), bigInteger.getBigInt());
    }

    BigInteger copy() {
        prepareJavaRepresentation();
        int[] iArr = new int[this.numberLength];
        System.arraycopy(this.digits, 0, iArr, 0, this.numberLength);
        return new BigInteger(this.sign, this.numberLength, iArr);
    }

    public BigInteger divide(BigInteger bigInteger) {
        BigInt bigInt = new BigInt();
        BigInt.division(getBigInt(), bigInteger.getBigInt(), bigInt, null);
        return new BigInteger(bigInt);
    }

    public BigInteger[] divideAndRemainder(BigInteger bigInteger) {
        BigInt bigInt = bigInteger.getBigInt();
        BigInt bigInt2 = new BigInt();
        BigInt bigInt3 = new BigInt();
        BigInt.division(getBigInt(), bigInt, bigInt2, bigInt3);
        return new BigInteger[]{new BigInteger(bigInt2), new BigInteger(bigInt3)};
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Conversion.bigInteger2Double(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BigInteger) && compareTo((BigInteger) obj) == 0;
    }

    public BigInteger flipBit(int i) {
        prepareJavaRepresentation();
        if (i < 0) {
            throw new ArithmeticException("n < 0: " + i);
        }
        return BitLevel.flipBit(this, i);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    public BigInteger gcd(BigInteger bigInteger) {
        return new BigInteger(BigInt.gcd(getBigInt(), bigInteger.getBigInt()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInt getBigInt() {
        if (this.nativeIsValid) {
            return this.bigInt;
        }
        synchronized (this) {
            if (this.nativeIsValid) {
                return this.bigInt;
            }
            BigInt bigInt = new BigInt();
            bigInt.putLittleEndianInts(this.digits, this.sign < 0);
            setBigInt(bigInt);
            return bigInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFirstNonzeroDigit() {
        int i;
        if (this.firstNonzeroDigit == -2) {
            if (this.sign != 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    i = i3;
                    if (this.digits[i3] != 0) {
                        break;
                    }
                    i2 = i3 + 1;
                }
            } else {
                i = -1;
            }
            this.firstNonzeroDigit = i;
        }
        return this.firstNonzeroDigit;
    }

    public int getLowestSetBit() {
        prepareJavaRepresentation();
        if (this.sign == 0) {
            return -1;
        }
        int firstNonzeroDigit = getFirstNonzeroDigit();
        return (firstNonzeroDigit << 5) + Integer.numberOfTrailingZeros(this.digits[firstNonzeroDigit]);
    }

    public int hashCode() {
        if (this.hashCode != 0) {
            return this.hashCode;
        }
        prepareJavaRepresentation();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.numberLength) {
                this.hashCode *= this.sign;
                return this.hashCode;
            }
            this.hashCode = (this.hashCode * 33) + this.digits[i2];
            i = i2 + 1;
        }
    }

    @Override // java.lang.Number
    public int intValue() {
        if (this.nativeIsValid && this.bigInt.twosCompFitsIntoBytes(4)) {
            return (int) this.bigInt.longInt();
        }
        prepareJavaRepresentation();
        return this.sign * this.digits[0];
    }

    public boolean isProbablePrime(int i) {
        if (i <= 0) {
            return true;
        }
        return getBigInt().isPrime(i);
    }

    @Override // java.lang.Number
    public long longValue() {
        if (this.nativeIsValid && this.bigInt.twosCompFitsIntoBytes(8)) {
            return this.bigInt.longInt();
        }
        prepareJavaRepresentation();
        return this.sign * (this.numberLength > 1 ? (this.digits[1] << 32) | (this.digits[0] & ExpandableListView.PACKED_POSITION_VALUE_NULL) : this.digits[0] & ExpandableListView.PACKED_POSITION_VALUE_NULL);
    }

    public BigInteger max(BigInteger bigInteger) {
        return compareTo(bigInteger) == 1 ? this : bigInteger;
    }

    public BigInteger min(BigInteger bigInteger) {
        return compareTo(bigInteger) == -1 ? this : bigInteger;
    }

    public BigInteger mod(BigInteger bigInteger) {
        if (bigInteger.signum() <= 0) {
            throw new ArithmeticException("m.signum() <= 0");
        }
        return new BigInteger(BigInt.modulus(getBigInt(), bigInteger.getBigInt()));
    }

    public BigInteger modInverse(BigInteger bigInteger) {
        if (bigInteger.signum() <= 0) {
            throw new ArithmeticException("modulus not positive");
        }
        return new BigInteger(BigInt.modInverse(getBigInt(), bigInteger.getBigInt()));
    }

    public BigInteger modPow(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() <= 0) {
            throw new ArithmeticException("modulus.signum() <= 0");
        }
        int signum = bigInteger.signum();
        if (signum == 0) {
            return ONE.mod(bigInteger2);
        }
        return new BigInteger(BigInt.modExp((signum < 0 ? modInverse(bigInteger2) : this).getBigInt(), bigInteger.getBigInt(), bigInteger2.getBigInt()));
    }

    public BigInteger multiply(BigInteger bigInteger) {
        return new BigInteger(BigInt.product(getBigInt(), bigInteger.getBigInt()));
    }

    public BigInteger negate() {
        BigInt bigInt = getBigInt();
        int sign = bigInt.sign();
        if (sign == 0) {
            return this;
        }
        BigInt copy = bigInt.copy();
        copy.setSign(-sign);
        return new BigInteger(copy);
    }

    public BigInteger nextProbablePrime() {
        if (this.sign < 0) {
            throw new ArithmeticException("sign < 0");
        }
        return Primality.nextProbablePrime(this);
    }

    public BigInteger not() {
        prepareJavaRepresentation();
        return Logical.not(this);
    }

    public BigInteger or(BigInteger bigInteger) {
        prepareJavaRepresentation();
        bigInteger.prepareJavaRepresentation();
        return Logical.or(this, bigInteger);
    }

    public BigInteger pow(int i) {
        if (i < 0) {
            throw new ArithmeticException("exp < 0: " + i);
        }
        return new BigInteger(BigInt.exp(getBigInt(), i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prepareJavaRepresentation() {
        int[] iArr;
        if (this.javaIsValid) {
            return;
        }
        synchronized (this) {
            if (this.javaIsValid) {
                return;
            }
            int sign = this.bigInt.sign();
            if (sign != 0) {
                iArr = this.bigInt.littleEndianIntsMagnitude();
            } else {
                iArr = new int[1];
                iArr[0] = 0;
            }
            setJavaRepresentation(sign, iArr.length, iArr);
        }
    }

    public BigInteger remainder(BigInteger bigInteger) {
        BigInt bigInt = new BigInt();
        BigInt.division(getBigInt(), bigInteger.getBigInt(), null, bigInt);
        return new BigInteger(bigInt);
    }

    public BigInteger setBit(int i) {
        prepareJavaRepresentation();
        BigInteger bigInteger = this;
        if (!testBit(i)) {
            bigInteger = BitLevel.flipBit(this, i);
        }
        return bigInteger;
    }

    public BigInteger shiftLeft(int i) {
        int signum;
        return (i == 0 || (signum = signum()) == 0) ? this : (signum > 0 || i >= 0) ? new BigInteger(BigInt.shift(getBigInt(), i)) : BitLevel.shiftRight(this, -i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger shiftLeftOneBit() {
        return signum() == 0 ? this : BitLevel.shiftLeftOneBit(this);
    }

    public BigInteger shiftRight(int i) {
        return shiftLeft(-i);
    }

    public int signum() {
        return this.javaIsValid ? this.sign : getBigInt().sign();
    }

    public BigInteger subtract(BigInteger bigInteger) {
        BigInt bigInt = getBigInt();
        BigInt bigInt2 = bigInteger.getBigInt();
        return bigInt2.sign() == 0 ? this : new BigInteger(BigInt.subtraction(bigInt, bigInt2));
    }

    public boolean testBit(int i) {
        boolean z = true;
        if (i < 0) {
            throw new ArithmeticException("n < 0: " + i);
        }
        int signum = signum();
        if (signum <= 0 || !this.nativeIsValid || this.javaIsValid) {
            prepareJavaRepresentation();
            if (i != 0) {
                int i2 = i >> 5;
                if (i2 < this.numberLength) {
                    int i3 = this.digits[i2];
                    int i4 = i3;
                    if (signum < 0) {
                        int firstNonzeroDigit = getFirstNonzeroDigit();
                        if (i2 < firstNonzeroDigit) {
                            return false;
                        }
                        i4 = firstNonzeroDigit == i2 ? -i3 : i3 ^ (-1);
                    }
                    if ((i4 & (1 << (i & 31))) == 0) {
                        return false;
                    }
                } else if (signum >= 0) {
                    return false;
                }
            } else if ((this.digits[0] & 1) == 0) {
                return false;
            }
        } else {
            z = getBigInt().isBitSet(i);
        }
        return z;
    }

    public byte[] toByteArray() {
        return twosComplement();
    }

    public String toString() {
        return getBigInt().decString();
    }

    public String toString(int i) {
        if (i == 10) {
            return getBigInt().decString();
        }
        prepareJavaRepresentation();
        return Conversion.bigInteger2String(this, i);
    }

    public BigInteger xor(BigInteger bigInteger) {
        prepareJavaRepresentation();
        bigInteger.prepareJavaRepresentation();
        return Logical.xor(this, bigInteger);
    }
}
